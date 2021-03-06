package gaia.entity.monster;

import javax.annotation.Nullable;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileDay;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaItems;
import gaia.init.GaiaLootTables;
import gaia.init.GaiaSounds;
import gaia.items.ItemShard;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaMandragora extends EntityMobHostileDay {
	private static final String IS_CHILD_TAG = "IsBaby";
	private static final String IS_SCREAMING_TAG = "IsScreaming";

	private static final DataParameter<Boolean> IS_CHILD = EntityDataManager.<Boolean>createKey(EntityGaiaMandragora.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_SCREAMING = EntityDataManager.<Boolean>createKey(EntityGaiaMandragora.class, DataSerializers.BOOLEAN);

	private int shovelAttack;

	private byte inWaterTimer;

	public EntityGaiaMandragora(World worldIn) {
		super(worldIn);

		setSize(0.75F, 1.0F);
		experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
		stepHeight = 1.0F;

		shovelAttack = 0;

		inWaterTimer = 0;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(1, new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_0, true));
		tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(2, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_1);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_0);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_1);
		getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_1);

		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.00D);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		float input = Math.min(damage, EntityAttributes.BASE_DEFENSE_1);
		Entity entity = source.getTrueSource();

		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			ItemStack itemstack = player.getHeldItem(getActiveHand());

			if (itemstack.getItem() instanceof ItemSpade) {
				input = input * 1.5F;
				shovelAttack += 1;
			}
		}

		return super.attackEntityFrom(source, input);
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
		super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_1);
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		if (super.attackEntityAsMob(entityIn)) {
			if (entityIn instanceof EntityLivingBase) {
				byte byte0 = 0;
				byte byte1 = 0;

				if (world.getDifficulty() == EnumDifficulty.NORMAL) {
					byte0 = 20;
					byte1 = 10;
				} else if (world.getDifficulty() == EnumDifficulty.HARD) {
					byte0 = 30;
					byte1 = 20;
				}

				if (byte0 > 0) {
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 20, 3));
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, byte0 * 20, 0));
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, byte1 * 20, 0));
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isAIDisabled() {
		return false;
	}

	@Override
	public void onLivingUpdate() {
		if (isScreaming()) {
			beaconDebuff(2, MobEffects.NAUSEA, 100, 0);
		}

		if (!world.isRemote) {
			if (isWet()) {
				if (inWaterTimer <= 100) {
					++inWaterTimer;
				} else {
					world.setEntityState(this, (byte) 8);
					heal(EntityAttributes.MAX_HEALTH_1 * 0.10F);
					addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 5 * 20, 0));
					inWaterTimer = 0;
				}
			}
		}

		if (motionX * motionX + motionZ * motionZ > 2.500000277905201E-7D && rand.nextInt(5) == 0) {
			int i = MathHelper.floor(posX);
			int j = MathHelper.floor(posY - 0.20000000298023224D);
			int k = MathHelper.floor(posZ);
			IBlockState iblockstate = world.getBlockState(new BlockPos(i, j, k));

			if (iblockstate.getMaterial() != Material.AIR) {
				world.spawnParticle(EnumParticleTypes.BLOCK_CRACK, posX + (rand.nextDouble() - 0.5D) * width, getEntityBoundingBox().minY + 0.1D, posZ + (rand.nextDouble() - 0.5D) * width, 4.0D * (rand.nextDouble() - 0.5D), 0.5D, (rand.nextDouble() - 0.5D) * 4.0D, Block.getStateId(iblockstate));
			}
		}

		if (isBurning()) {
			addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 0));
			addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 100, 0));
		}

		super.onLivingUpdate();
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.MANDRAGORA_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.MANDRAGORA_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.MANDRAGORA_DEATH;
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return GaiaLootTables.ENTITIES_GAIA_MANDRAGORA;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				dropItem(GaiaItems.FOOD_ROOT, 1);
			}

			if (shovelAttack >= 4) {
				if ((rand.nextInt(8) == 0)) {
					dropItem(GaiaItems.FOOD_MANDRAKE, 1);
				}
			} else {
				if ((rand.nextInt(16) == 0)) {
					dropItem(GaiaItems.FOOD_MANDRAKE, 1);
				}
			}

			// Nuggets/Fragments
			int dropNugget = rand.nextInt(GaiaConfig.DROPS.maxNuggetCount) + 1;

			for (int i = 0; i < dropNugget; ++i) {
				dropItem(Items.IRON_NUGGET, 1);
			}

			if (GaiaConfig.DROPS.additionalOre) {
				int dropNuggetAlt = rand.nextInt(GaiaConfig.DROPS.maxNuggetCount) + 1;

				for (int i = 0; i < dropNuggetAlt; ++i) {
					ItemShard.dropNugget(this, 4);
				}
			}

			// Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0)) {
				dropItem(GaiaItems.BOX_IRON, 1);
			}

			// Unique Rare
			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				dropItem(Item.getItemFromBlock(GaiaBlocks.DECO_GARDEN_GNOME), 1);
			}
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, livingdata);

		setChild(true);
		setScreaming(true);

		return ret;
	}

	/* CHILD CODE */
	@Override
	public float getEyeHeight() {
		float f;

		ItemStack itemstack = getItemStackFromSlot(EntityEquipmentSlot.CHEST);

		if (itemstack.isEmpty() || itemstack.getItem() != Items.EGG) {
			f = 1.74F;
		} else {
			f = 1.74F - 0.81F;
		}

		return f;
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(IS_CHILD, true);
		dataManager.register(IS_SCREAMING, true);
	}

	public boolean isChild() {
		return ((Boolean) getDataManager().get(IS_CHILD)).booleanValue();
	}

	public void setChild(boolean isChild) {
		getDataManager().set(IS_CHILD, Boolean.valueOf(isChild));
	}

	public boolean isScreaming() {
		return ((Boolean) getDataManager().get(IS_SCREAMING)).booleanValue();
	}

	public void setScreaming(boolean isScreaming) {
		getDataManager().set(IS_SCREAMING, Boolean.valueOf(isScreaming));
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean(IS_CHILD_TAG, isChild());
		compound.setBoolean(IS_SCREAMING_TAG, isScreaming());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		if (compound.hasKey(IS_CHILD_TAG)) {
			boolean b0 = compound.getBoolean(IS_CHILD_TAG);
			setChild(b0);
		}

		if (compound.hasKey(IS_SCREAMING_TAG)) {
			boolean b1 = compound.getBoolean(IS_SCREAMING_TAG);
			setScreaming(b1);
		}
	}
	/* CHILD CODE */

	/* IMMUNITIES */
	@Override
	public boolean isPotionApplicable(PotionEffect potioneffectIn) {
		return potioneffectIn.getPotion() == MobEffects.NAUSEA ? false : super.isPotionApplicable(potioneffectIn);
	}
	/* IMMUNITIES */

	@Override
	public boolean getCanSpawnHere() {
		return posY > ((!GaiaConfig.SPAWN.disableYRestriction) ? 60D : 0D) && super.getCanSpawnHere();
	}
}
