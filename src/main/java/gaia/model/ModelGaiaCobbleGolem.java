package gaia.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class ModelGaiaCobbleGolem extends ModelBase {
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarmupper;
	ModelRenderer rightarmlower;
	ModelRenderer leftarmupper;
	ModelRenderer leftarmlower;
	ModelRenderer bodylower;
	ModelRenderer rightlegupper;
	ModelRenderer rightleglower;
	ModelRenderer leftlegupper;
	ModelRenderer leftleglower;

	public ModelGaiaCobbleGolem() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3.0F, -2.0F, -1.0F, 6, 4, 4);
		this.head.setRotationPoint(0.0F, 3.0F, -4.0F);
		this.head.setTextureSize(64, 32);
		this.head.mirror = true;
		this.setRotation(this.head, 0.0872665F, 0.0F, 0.0F);
		this.body = new ModelRenderer(this, 0, 8);
		this.body.addBox(-7.0F, -6.0F, -4.0F, 14, 12, 8);
		this.body.setRotationPoint(0.0F, 4.0F, 2.0F);
		this.body.setTextureSize(64, 32);
		this.body.mirror = true;
		this.setRotation(this.body, 0.2617994F, 0.0F, 0.0F);
		this.rightarmupper = new ModelRenderer(this, 44, 0);
		this.rightarmupper.addBox(-6.0F, -4.0F, -3.0F, 6, 12, 6);
		this.rightarmupper.setRotationPoint(-7.0F, 2.0F, 3.0F);
		this.rightarmupper.setTextureSize(64, 32);
		this.rightarmupper.mirror = true;
		this.setRotation(this.rightarmupper, 0.0F, 0.0F, 0.0F);
		this.rightarmlower = new ModelRenderer(this, 44, 18);
		this.rightarmlower.addBox(-5.0F, 8.0F, -2.0F, 4, 14, 4);
		this.rightarmlower.setRotationPoint(-7.0F, 2.0F, 3.0F);
		this.rightarmlower.setTextureSize(64, 32);
		this.rightarmlower.mirror = true;
		this.setRotation(this.rightarmlower, 0.0F, 0.0F, 0.0F);
		this.leftarmupper = new ModelRenderer(this, 44, 0);
		this.leftarmupper.addBox(0.0F, -4.0F, -3.0F, 6, 12, 6);
		this.leftarmupper.setRotationPoint(7.0F, 2.0F, 3.0F);
		this.leftarmupper.setTextureSize(64, 32);
		this.leftarmupper.mirror = true;
		this.setRotation(this.leftarmupper, 0.0F, 0.0F, 0.0F);
		this.leftarmlower = new ModelRenderer(this, 44, 18);
		this.leftarmlower.addBox(1.0F, 8.0F, -2.0F, 4, 14, 4);
		this.leftarmlower.setRotationPoint(7.0F, 2.0F, 3.0F);
		this.leftarmlower.setTextureSize(64, 32);
		this.leftarmlower.mirror = true;
		this.setRotation(this.leftarmlower, 0.0F, 0.0F, 0.0F);
		this.bodylower = new ModelRenderer(this, 0, 28);
		this.bodylower.addBox(-1.0F, 11.0F, -3.0F, 8, 4, 6);
		this.bodylower.setRotationPoint(-3.0F, -1.0F, 3.0F);
		this.bodylower.setTextureSize(64, 32);
		this.bodylower.mirror = true;
		this.setRotation(this.bodylower, 0.0872665F, 0.0F, 0.0F);
		this.rightlegupper = new ModelRenderer(this, 44, 36);
		this.rightlegupper.addBox(-1.5F, 1.0F, -1.5F, 3, 6, 3);
		this.rightlegupper.setRotationPoint(-3.0F, 13.0F, 4.0F);
		this.rightlegupper.setTextureSize(64, 32);
		this.rightlegupper.mirror = true;
		this.setRotation(this.rightlegupper, -0.1745329F, 0.0F, 0.0F);
		this.rightleglower = new ModelRenderer(this, 44, 45);
		this.rightleglower.addBox(-2.0F, 5.0F, 0.0F, 4, 6, 4);
		this.rightleglower.setRotationPoint(-3.0F, 13.0F, 4.0F);
		this.rightleglower.setTextureSize(64, 32);
		this.rightleglower.mirror = true;
		this.setRotation(this.rightleglower, -0.1745329F, 0.0F, 0.0F);
		this.leftlegupper = new ModelRenderer(this, 44, 36);
		this.leftlegupper.addBox(-1.5F, 1.0F, -1.5F, 3, 6, 3);
		this.leftlegupper.setRotationPoint(3.0F, 13.0F, 4.0F);
		this.leftlegupper.setTextureSize(64, 32);
		this.leftlegupper.mirror = true;
		this.setRotation(this.leftlegupper, -0.1745329F, 0.0F, 0.0F);
		this.leftleglower = new ModelRenderer(this, 44, 45);
		this.leftleglower.addBox(-2.0F, 5.0F, 0.0F, 4, 6, 4);
		this.leftleglower.setRotationPoint(3.0F, 13.0F, 4.0F);
		this.leftleglower.setTextureSize(64, 32);
		this.leftleglower.mirror = true;
		this.setRotation(this.leftleglower, -0.1745329F, 0.0F, 0.0F);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
		this.body.render(par7);
		this.rightarmupper.render(par7);
		this.rightarmlower.render(par7);
		this.leftarmupper.render(par7);
		this.leftarmlower.render(par7);
		this.bodylower.render(par7);
		this.rightlegupper.render(par7);
		this.rightleglower.render(par7);
		this.leftlegupper.render(par7);
		this.leftleglower.render(par7);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {
		this.head.rotateAngleY = par4 / 57.295776F;
		this.head.rotateAngleX = par5 / 57.295776F;
		this.rightarmlower.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
		this.leftarmlower.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
		this.rightarmupper.rotateAngleX = this.rightarmlower.rotateAngleX;
		this.leftarmupper.rotateAngleX = this.leftarmlower.rotateAngleX;
		this.rightlegupper.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		this.leftlegupper.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
		this.rightleglower.rotateAngleX = this.rightlegupper.rotateAngleX - 0.1745329F;
		this.leftleglower.rotateAngleX = this.leftlegupper.rotateAngleX - 0.1745329F;
		this.rightlegupper.rotateAngleX -= 0.1745329F;
		this.leftlegupper.rotateAngleX -= 0.1745329F;
	}
}
