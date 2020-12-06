package gaia.items;

import cpw.mods.fml.common.IFuelHandler;
import gaia.GaiaItem;
import net.minecraft.item.ItemStack;

public class GaiaItemHandlerFuel implements IFuelHandler {

	//20 = 1 second
	public int getBurnTime(ItemStack fuel) {
		if (fuel.getItem() == GaiaItem.FoodCoalfish) {
			return 3600;
		}
		
		if (fuel.getItem() == GaiaItem.MiscFurnaceFuel) {
			return 3600;
		}
		
		if (fuel.getItem() == GaiaItem.MiscSoulFire) {
			return 11600;
		}
		
		if (fuel.getItem() == GaiaItem.MiscSoulFiery) {
			return 20000;
		}
		
		if (fuel.getItem() == GaiaItem.MiscGigaGear) {
			return 1240000;
		}
		return 0;
	}
}
