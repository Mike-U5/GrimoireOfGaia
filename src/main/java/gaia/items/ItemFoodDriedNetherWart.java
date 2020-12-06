package gaia.items;

import gaia.Gaia;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;

public class ItemFoodDriedNetherWart extends ItemFood {
	String texture;

	public ItemFoodDriedNetherWart(int par2, float par3, boolean par4, String texture) {
		super(par2, par3, par4);
		this.texture = texture;
		this.setUnlocalizedName("GrimoireOfGaia.FoodDriedNetherWart");
		this.setCreativeTab(Gaia.tabGaia);
	}

	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("gaia:" + this.texture);
	}
}
