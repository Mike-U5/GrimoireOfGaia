package gaia.entity.monster;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gaia.GaiaItem;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobDay;
import gaia.entity.ai.EntityAIGaiaAttackOnCollide;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityGaiaCobbleGolem extends EntityMobDay {
	private float field_70926_e;
	private float field_70924_f;
	private int attackTimer;
	private int holdRoseTick;

	public EntityGaiaCobbleGolem(World par1World) {
		super(par1World);
		this.experienceValue = EntityAttributes.experienceValue1;
		this.stepHeight = 1.0F;
		this.isImmuneToFire = true;
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAIGaiaAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(2, new EntityAIWander(this, 0.5D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)EntityAttributes.maxHealth1);
		//		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)EntityAttributes.moveSpeed1);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)EntityAttributes.attackDamage1);
	}

	public int getTotalArmorValue() {
		return EntityAttributes.rateArmor1;
	}

	public boolean attackEntityAsMob(Entity par1Entity) {
		this.attackTimer = 10;
		this.worldObj.setEntityState(this, (byte)4);
		boolean var2 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(7 + this.rand.nextInt(15)));
		if(var2) {
			par1Entity.motionY += 0.2000000059604645D;
		}

		this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
		return var2;
	}

	@SideOnly(Side.CLIENT)
	public void handleHealthUpdate(byte par1) {
		if(par1 == 4) {
			this.attackTimer = 10;
			this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
		} else if(par1 == 11) {
			this.holdRoseTick = 400;
		} else {
			super.handleHealthUpdate(par1);
		}
	}

	@SideOnly(Side.CLIENT)
	public int getAttackTimer() {
		return this.attackTimer;
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, float damage) {
		Entity entity = par1DamageSource.getEntity();
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			ItemStack itemstack = player.getCurrentEquippedItem();
			if (itemstack != null) {
				Item item = itemstack.getItem();
				if (item != null) {
					if (item == Items.wooden_pickaxe) {
						damage = 6.0F;
					}

					if (item == Items.stone_pickaxe) {
						damage = 7.0F;
					}

					if (item == Items.iron_pickaxe) {
						damage = 8.0F;
					}

					if (item == Items.golden_pickaxe) {
						damage = 6.0F;
					}

					if (item == Items.diamond_pickaxe) {
						damage = 9.0F;
					}
				}
			}
		}

		return super.attackEntityFrom(par1DamageSource, damage);
	}

	public boolean isAIEnabled() {
		return true;
	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(19, new Byte((byte)0));
	}

	public void onUpdate() {
		super.onUpdate();
		this.field_70924_f = this.field_70926_e;
		if(this.func_70922_bv()) {
			this.field_70926_e += (1.0F - this.field_70926_e) * 0.4F;
		} else {
			this.field_70926_e += (0.0F - this.field_70926_e) * 0.4F;
		}

		if(this.func_70922_bv()) {
			this.numTicksToChaseTarget = 10;
		}
	}

	public boolean func_70922_bv() {
		return this.dataWatcher.getWatchableObjectByte(19) == 1;
	}

	public void func_70918_i(boolean par1) {
		if(par1) {
			this.dataWatcher.updateObject(19, Byte.valueOf((byte)1));
		} else {
			this.dataWatcher.updateObject(19, Byte.valueOf((byte)0));
		}
	}

	public void setTarget(Entity par1Entity) {
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();
		if(elements.length > 2) {
			StackTraceElement previousMethod = elements[2];
			if(previousMethod.getClassName().startsWith("org.millenaire.") && previousMethod.getMethodName().equals("triggerMobAttacks")) {
				return;
			}
		}
		
		super.setTarget(par1Entity);
	}

	public void onLivingUpdate() {
		super.onLivingUpdate();
		if(this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7D && this.rand.nextInt(5) == 0) {
			int var1 = MathHelper.floor_double(this.posX);
			int var2 = MathHelper.floor_double(this.posY - 0.20000000298023224D - (double)this.yOffset);
			int var3 = MathHelper.floor_double(this.posZ);
			Block var4 = this.worldObj.getBlock(var1, var2, var3);
			if(var4 != Blocks.air) {
				this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(var4) + "_" + this.worldObj.getBlockMetadata(var1, var2, var3), this.posX + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, this.boundingBox.minY + 0.1D, this.posZ + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, 4.0D * ((double)this.rand.nextFloat() - 0.5D), 0.5D, ((double)this.rand.nextFloat() - 0.5D) * 4.0D);
			}
		}

	}

	protected String getLivingSound() {
		return "none";
	}

	protected String getHurtSound() {
		return "dig.stone";
	}

	protected String getDeathSound() {
		return "mob.irongolem.death";
	}

	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.worldObj.playSoundAtEntity(this, "mob.irongolem.walk", 1.0F, 1.0F);
	}

	protected void dropFewItems(boolean par1, int par2) {
		int var3 = this.rand.nextInt(3 + par2);

		for(int var4 = 0; var4 < var3; ++var4) {
			this.dropItem(Item.getItemFromBlock(Blocks.cobblestone), 1);
		}

		if(par1 && (this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + par2) > 0)) {
            this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 0), 0.0F);
		}

		if(par1 && (this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + par2) > 0)) {
            this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 0), 0.0F);
		}
	}

	protected void dropRareDrop(int par1) {
		switch(this.rand.nextInt(2)) {
		case 0:
			this.dropItem(GaiaItem.BoxIron,1);
			break;
		case 1:
			this.experienceValue = EntityAttributes.experienceValue1 * 5;
		}
	}

	public boolean isPotionApplicable(PotionEffect par1PotionEffect) {
		return par1PotionEffect.getPotionID() == Potion.poison.id?false:super.isPotionApplicable(par1PotionEffect);
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
			if(this.motionY > EntityAttributes.knockback1) {
				this.motionY = EntityAttributes.knockback1;
			}
		}
	}
	
	public boolean getCanSpawnHere() {
		return this.posY > 60.0D && super.getCanSpawnHere();
	}
}
