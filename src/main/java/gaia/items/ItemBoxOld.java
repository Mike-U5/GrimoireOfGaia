package gaia.items;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gaia.Gaia;
import gaia.GaiaItem;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemBoxOld extends Item {
	String texture;

	public ItemBoxOld(String texture) {

		this.texture = texture;
		this.maxStackSize = 1;
		this.setUnlocalizedName("GrimoireOfGaia.BoxOld");
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.rare;
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(StatCollector.translateToLocal("text.GrimoireOfGaia.RightClickUse.desc"));
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		world.playSoundAtEntity(entityplayer, "gaia:box_open2", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		
		Random random = new Random();
		int i = random.nextInt(8);
		switch(i) {
		case 0:
			return new ItemStack(GaiaItem.Shard, 1, 4);
		case 1:
			return new ItemStack(GaiaItem.Shard, 1, 4);
		case 2:
			return new ItemStack(GaiaItem.MiscGigaGear);
		case 3:
			return new ItemStack(Items.blaze_powder);
		case 4:
			return new ItemStack(Items.saddle);
		case 5:
			return new ItemStack(Items.name_tag);
		case 6:
			return new ItemStack(GaiaItem.Shard, 1, 4);
		case 7:
			return new ItemStack(GaiaItem.Shard, 1, 4);
		default:
			return itemstack;
		}
	}

	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("gaia:" + this.texture);
	}
}
