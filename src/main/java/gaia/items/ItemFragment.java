package gaia.items;

import gaia.Gaia;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemFragment extends Item {
	String texture;

	public ItemFragment(String texture) {
		this.texture = texture;
		this.setUnlocalizedName("GrimoireOfGaia.Fragment");
		this.setCreativeTab(Gaia.tabGaia);
	}

	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("gaia:" + this.texture);
	}
}
