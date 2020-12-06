package gaia.entity.monster;

import java.util.HashSet;

import gaia.GaiaItem;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobBase;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityGaiaEnderDragonGirl extends EntityMobBase {

	static HashSet<Block> carriableBlocks = new HashSet<Block>();
    private static final AttributeModifier attackingSpeedBoostModifier = (new AttributeModifier("Attacking speed boost", 6.0D, 0)).setSaved(false);
	private int teleportDelay = 0;
    private int stareTimer;
    private Entity lastEntityToAttack;
    private boolean isAggressive;

	public EntityGaiaEnderDragonGirl(World par1World) {
		super(par1World);
		this.setSize(0.6F, 2.9F);
		this.experienceValue = EntityAttributes.experienceValue2;
		this.stepHeight = 1.0F;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)EntityAttributes.maxHealth2);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)EntityAttributes.moveSpeed2);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)EntityAttributes.attackDamage2);
	}

	public int getTotalArmorValue() {
		return EntityAttributes.rateArmor2;
	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
		this.dataWatcher.addObject(17, new Byte((byte)0));
		this.dataWatcher.addObject(18, new Byte((byte)0));
	}

	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setShort("carried", (short)this.getCarried());
		par1NBTTagCompound.setShort("carriedData", (short)this.getCarryingData());
	}

	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		this.setCarried(par1NBTTagCompound.getShort("carried"));
		this.setCarryingData(par1NBTTagCompound.getShort("carriedData"));
	}

    protected Entity findPlayerToAttack() {
        EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0D);

        if (entityplayer != null) {
            if (this.shouldAttackPlayer(entityplayer)) {
                this.isAggressive = true;

                if (this.stareTimer == 0) {
                    this.worldObj.playSoundEffect(entityplayer.posX, entityplayer.posY, entityplayer.posZ, "mob.endermen.stare", 1.0F, 1.0F);
                }

                if (this.stareTimer++ == 5) {
                    this.stareTimer = 0;
                    this.setScreaming(true);
                    return entityplayer;
                }
            }
            else {
                this.stareTimer = 0;
            }
        }

        return null;
    }

    private boolean shouldAttackPlayer(EntityPlayer entityplayer) {
        ItemStack itemstack = entityplayer.inventory.armorInventory[3];

        if (itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.pumpkin)) {
            return false;
        } else {
            Vec3 vec3 = entityplayer.getLook(1.0F).normalize();
            Vec3 vec31 = Vec3.createVectorHelper(this.posX - entityplayer.posX, this.boundingBox.minY + (double)(this.height / 2.0F) - (entityplayer.posY + (double)entityplayer.getEyeHeight()), this.posZ - entityplayer.posZ);
            double d0 = vec31.lengthVector();
            vec31 = vec31.normalize();
            double d1 = vec3.dotProduct(vec31);
            return d1 > 1.0D - 0.025D / d0 && entityplayer.canEntityBeSeen(this);
        }
    }

	public void onLivingUpdate() {
		if(this.isWet()) {
			this.attackEntityFrom(DamageSource.drown, 1);
		}

        if (this.lastEntityToAttack != this.entityToAttack) {
            IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
            iattributeinstance.removeModifier(attackingSpeedBoostModifier);

            if (this.entityToAttack != null) {
                iattributeinstance.applyModifier(attackingSpeedBoostModifier);
            }
        }

        this.lastEntityToAttack = this.entityToAttack;
		int f;
		if(!this.worldObj.isRemote && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
			int j;
			int k;
			int l;
			if(this.getCarried() == 0) {
				if(this.rand.nextInt(20) == 0) {
					f = MathHelper.floor_double(this.posX - 2.0D + this.rand.nextDouble() * 4.0D);
					j = MathHelper.floor_double(this.posY + this.rand.nextDouble() * 3.0D);
					k = MathHelper.floor_double(this.posZ - 2.0D + this.rand.nextDouble() * 4.0D);
					Block b = this.worldObj.getBlock(f, j, k);
					if (carriableBlocks.contains(b)) {
						this.setCarried(Block.getIdFromBlock(b));
						this.setCarryingData(this.worldObj.getBlockMetadata(f, j, k));
						this.worldObj.setBlock(f, j, k, Blocks.air);
					}
				}
			} else {
				Block b3 = Block.getBlockById(getCarried());
				if (b3 == null || b3 == Blocks.air) {
					setCarried(0);
					return;
				}
				if (this.rand.nextInt(2000) == 0) {
					f = MathHelper.floor_double(this.posX - 1.0D
							+ this.rand.nextDouble() * 2.0D);
					j = MathHelper.floor_double(this.posY
							+ this.rand.nextDouble() * 2.0D);
					k = MathHelper.floor_double(this.posZ - 1.0D
							+ this.rand.nextDouble() * 2.0D);
					Block b = this.worldObj.getBlock(f, j, k);
					Block b2 = this.worldObj.getBlock(f, j - 1, k);
					if (b == Blocks.air && b2 != Blocks.air
							&& b2.renderAsNormalBlock()) {
						this.worldObj.setBlock(f, j, k, b3,
								this.getCarryingData(), 3);
						this.setCarried(0);
					}
				}
			}
		}

		for(f = 0; f < 2; ++f) {
			this.worldObj.spawnParticle("portal", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
		}

		if(this.worldObj.isDaytime() && !this.worldObj.isRemote) {
			float var6 = this.getBrightness(1.0F);
			if(var6 > 0.5F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) && this.rand.nextFloat() * 30.0F < (var6 - 0.4F) * 2.0F) {
				this.entityToAttack = null;
				this.setScreaming(false);
				this.teleportRandomly();
			}
		}

		if(this.isWet() || this.isBurning()) {
			this.entityToAttack = null;
			this.setScreaming(false);
			this.teleportRandomly();
		}

		this.isJumping = false;
		if(this.entityToAttack != null) {
			this.faceEntity(this.entityToAttack, 100.0F, 100.0F);
		}

		if(!this.worldObj.isRemote && this.isEntityAlive()) {
			if(this.entityToAttack != null) {
				if(this.entityToAttack instanceof EntityPlayer && this.shouldAttackPlayer((EntityPlayer)this.entityToAttack)) {
					this.moveStrafing = this.moveForward = 0.0F;
					this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
					if(this.entityToAttack.getDistanceSqToEntity(this) < 16.0D) {
						this.teleportRandomly();
					}

					this.teleportDelay = 0;
				} else if(this.entityToAttack.getDistanceSqToEntity(this) > 256.0D && this.teleportDelay++ >= 30 && this.teleportToEntity(this.entityToAttack)) {
					this.teleportDelay = 0;
				}
			} else {
				this.setScreaming(false);
				this.teleportDelay = 0;
			}
		}

		super.onLivingUpdate();
	}

	protected boolean teleportRandomly() {
		double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * 64.0D;
		double d1 = this.posY + (double)(this.rand.nextInt(64) - 32);
		double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * 64.0D;
		return this.teleportTo(d0, d1, d2);
	}

	protected boolean teleportToEntity(Entity par1Entity) {
		Vec3 vec3 = Vec3.createVectorHelper(this.posX - par1Entity.posX, this.boundingBox.minY + (double)(this.height / 2.0F) - par1Entity.posY + (double)par1Entity.getEyeHeight(), this.posZ - par1Entity.posZ);
		vec3 = vec3.normalize();
		double d0 = 16.0D;
		double d1 = this.posX + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.xCoord * d0;
		double d2 = this.posY + (double)(this.rand.nextInt(16) - 8) - vec3.yCoord * d0;
		double d3 = this.posZ + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.zCoord * d0;
		return this.teleportTo(d1, d2, d3);
	}

	protected boolean teleportTo(double par1, double par3, double par5) {
		EnderTeleportEvent event = new EnderTeleportEvent(this, par1, par3, par5, 0.0F);
		if(MinecraftForge.EVENT_BUS.post(event)) {
			return false;
		} else {
			double d3 = this.posX;
			double d4 = this.posY;
			double d5 = this.posZ;
			this.posX = event.targetX;
			this.posY = event.targetY;
			this.posZ = event.targetZ;
			boolean flag = false;
			int i = MathHelper.floor_double(this.posX);
			int j = MathHelper.floor_double(this.posY);
			int k = MathHelper.floor_double(this.posZ);
			if(this.worldObj.blockExists(i, j, k)) {
				boolean short1 = false;

				while(!short1 && j > 0) {
					Block l = this.worldObj.getBlock(i, j - 1, k);
					if(l != Blocks.air && l.getMaterial().blocksMovement()) {
						short1 = true;
					} else {
						--this.posY;
						--j;
					}
				}

				if(short1) {
					this.setPosition(this.posX, this.posY, this.posZ);
					if(this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox)) {
						flag = true;
					}
				}
			}

			if(!flag) {
				this.setPosition(d3, d4, d5);
				return false;
			} else {
				short var31 = 128;
				int l;

				for(l = 0; l < var31; ++l) {
					double d6 = (double)l / ((double)var31 - 1.0D);
					float f = (this.rand.nextFloat() - 0.5F) * 0.2F;
					float f1 = (this.rand.nextFloat() - 0.5F) * 0.2F;
					float f2 = (this.rand.nextFloat() - 0.5F) * 0.2F;
					double d7 = d3 + (this.posX - d3) * d6 + (this.rand.nextDouble() - 0.5D) * (double)this.width * 2.0D;
					double d8 = d4 + (this.posY - d4) * d6 + this.rand.nextDouble() * (double)this.height;
					double d9 = d5 + (this.posZ - d5) * d6 + (this.rand.nextDouble() - 0.5D) * (double)this.width * 2.0D;
					this.worldObj.spawnParticle("portal", d7, d8, d9, (double)f, (double)f1, (double)f2);
				}

				this.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal", 1.0F, 1.0F);
				this.playSound("mob.endermen.portal", 1.0F, 1.0F);
				return true;
			}
		}
	}

	protected String getLivingSound() {
		return this.isScreaming()?"mob.endermen.scream":"mob.endermen.idle";
	}

	protected String getHurtSound() {
		return "mob.endermen.hit";
	}

	protected String getDeathSound() {
		return "mob.endermen.death";
	}

	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.playSound("mob.pig.step", 0.15F, 1.0F);
	}

	protected void dropFewItems(boolean par1, int par2) {
		int var3 = this.rand.nextInt(3 + par2);

		for(int var4 = 0; var4 < var3; ++var4) {
			this.dropItem(Items.ender_pearl,1);
		}
		
		var3 = this.rand.nextInt(3 + par2);

		for(int var4 = 0; var4 < var3; ++var4) {
			this.dropItem(GaiaItem.Shard,1);
		}

		if(par1 && (this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + par2) > 0)) {
            this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 1), 0.0F);
		}

		if(par1 && (this.rand.nextInt(4) == 0 || this.rand.nextInt(1 + par2) > 0)) {
			this.dropItem(GaiaItem.Fragment, 1);
		}
	}

	protected void dropRareDrop(int par1) {
		switch(this.rand.nextInt(4)) {
		case 0:
			this.dropItem(GaiaItem.BoxGold,1);
			break;
		case 1:
			this.dropItem(GaiaItem.BagBook,1);
			break;
		case 2:
			this.dropItem(GaiaItem.BookEnder,1);
			break;
		case 3:
			this.dropItem(Items.ender_eye,1);
		}
	}

	public void setCarried(int par1) {
		this.dataWatcher.updateObject(16, Byte.valueOf((byte)(par1 & 255)));
	}

	public int getCarried() {
		return this.dataWatcher.getWatchableObjectByte(16);
	}

	public void setCarryingData(int par1) {
		this.dataWatcher.updateObject(17, Byte.valueOf((byte)(par1 & 255)));
	}

	public int getCarryingData() {
		return this.dataWatcher.getWatchableObjectByte(17);
	}
	
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        if (this.isEntityInvulnerable()) {
            return false;
        } else {
            this.setScreaming(true);

            if (par1DamageSource instanceof EntityDamageSource && par1DamageSource.getEntity() instanceof EntityPlayer) {
                this.isAggressive = true;
            }

            if (par1DamageSource instanceof EntityDamageSourceIndirect) {
            	this.isAggressive = false;

            	for (int i = 0; i < 64; ++i) {
            		if (this.teleportRandomly()) {
            			return true;
            		}
            	}

            	return super.attackEntityFrom(par1DamageSource, par2);
            } else {
            	return super.attackEntityFrom(par1DamageSource, par2);
            }
        }
    }

	public boolean isScreaming() {
		return this.dataWatcher.getWatchableObjectByte(18) > 0;
	}

	public void setScreaming(boolean par1) {
		this.dataWatcher.updateObject(18, Byte.valueOf((byte)(par1?1:0)));
	}

	public void knockBack(Entity par1Entity, float par2, double par3, double par5) {
		if(this.rand.nextDouble() >= this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue()) {
			this.isAirBorne = true;
			float f1 = MathHelper.sqrt_double(par3 * par3 + par5 * par5);
			float f2 = 0.4F;
			this.motionX /= 2.0D;
			this.motionY /= 2.0D;
			this.motionZ /= 2.0D;
			this.motionX -= par3 / (double)f1 * (double)f2;
			this.motionY += (double)f2;
			this.motionZ -= par5 / (double)f1 * (double)f2;
			if(this.motionY > EntityAttributes.knockback2) {
				this.motionY = EntityAttributes.knockback2;
			}
		}
	}

	static {
		carriableBlocks.add(Blocks.grass);
		carriableBlocks.add(Blocks.dirt);
		carriableBlocks.add(Blocks.sand);
		carriableBlocks.add(Blocks.gravel);
		carriableBlocks.add(Blocks.yellow_flower);
		carriableBlocks.add(Blocks.red_flower);
		carriableBlocks.add(Blocks.red_mushroom);
		carriableBlocks.add(Blocks.brown_mushroom);
		carriableBlocks.add(Blocks.tnt);
		carriableBlocks.add(Blocks.cactus);
		carriableBlocks.add(Blocks.clay);
		carriableBlocks.add(Blocks.pumpkin);
		carriableBlocks.add(Blocks.melon_block);
		carriableBlocks.add(Blocks.mycelium);
	}
}
