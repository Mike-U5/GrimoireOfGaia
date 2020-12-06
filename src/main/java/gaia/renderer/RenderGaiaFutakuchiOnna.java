package gaia.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gaia.model.ModelGaiaFutakuchiOnna;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderGaiaFutakuchiOnna extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Futakuchi_Onna.png");

	public RenderGaiaFutakuchiOnna() {
		super(new ModelGaiaFutakuchiOnna(), 0.5F);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
