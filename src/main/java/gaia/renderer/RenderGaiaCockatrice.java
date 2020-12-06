package gaia.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gaia.model.ModelGaiaCockatrice;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderGaiaCockatrice extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Cockatrice.png");

	public RenderGaiaCockatrice() {
		super(new ModelGaiaCockatrice(), 0.5F);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
