package gaia.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gaia.model.ModelGaiaSuccubus;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderGaiaSuccubus extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Succubus.png");

	public RenderGaiaSuccubus() {
		super(new ModelGaiaSuccubus(), 0.5F);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
