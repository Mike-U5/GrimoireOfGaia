package gaia.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class ModelGaiaHunter extends ModelBase {
	ModelRenderer head;
	ModelRenderer headaccessory;
	ModelRenderer hair;
	ModelRenderer bodytop;
	ModelRenderer bodymiddle;
	ModelRenderer bodymiddlebutton;
	ModelRenderer bodybottom;
	ModelRenderer waist01;
	ModelRenderer waist02;
	public static ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightpauldron;
	ModelRenderer leftpauldron;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer leftfoot;

	public ModelGaiaHunter() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, 1F, 0F);
		this.head.setTextureSize(64, 32);
		this.head.mirror = true;
		this.setRotation(head, 0F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, 1F, 0F);
		this.headaccessory.setTextureSize(64, 32);
		this.headaccessory.mirror = true;
		this.setRotation(headaccessory, 0F, 0F, 0F);
		this.hair = new ModelRenderer(this, 36, 14);
		this.hair.addBox(-2.5F, -8F, 1.5F, 5, 5, 5);
		this.hair.setRotationPoint(0F, 1F, 0F);
		this.hair.setTextureSize(64, 32);
		this.hair.mirror = true;
		this.setRotation(hair, 0F, 0F, 0F);
		this.bodytop = new ModelRenderer(this, 0, 12);
		this.bodytop.addBox(-2.5F, 0F, -1.5F, 5, 5, 3);
		this.bodytop.setRotationPoint(0F, 1F, 0F);
		this.bodytop.setTextureSize(64, 32);
		this.bodytop.mirror = true;
		this.setRotation(bodytop, -0.0872665F, 0F, 0F);
		this.bodymiddle = new ModelRenderer(this, 0, 20);
		this.bodymiddle.addBox(-2F, 4.5F, -1.5F, 4, 3, 2);
		this.bodymiddle.setRotationPoint(0F, 1F, 0F);
		this.bodymiddle.setTextureSize(64, 32);
		this.bodymiddle.mirror = true;
		this.setRotation(bodymiddle, 0F, 0F, 0F);
		this.bodymiddlebutton = new ModelRenderer(this, 0, 20);
		this.bodymiddlebutton.addBox(-0.5F, 5F, -1.6F, 1, 2, 0);
		this.bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		this.bodymiddlebutton.setTextureSize(64, 32);
		this.bodymiddlebutton.mirror = true;
		this.setRotation(bodymiddlebutton, 0F, 0F, 0F);
		this.bodybottom = new ModelRenderer(this, 0, 25);
		this.bodybottom.addBox(-2.5F, 7F, -2.5F, 5, 3, 3);
		this.bodybottom.setRotationPoint(0F, 1F, 0F);
		this.bodybottom.setTextureSize(64, 32);
		this.bodybottom.mirror = true;
		this.setRotation(bodybottom, 0.0872665F, 0F, 0F);
		this.waist01 = new ModelRenderer(this, 64, 6);
		this.waist01.addBox(-3F, 8F, -2F, 6, 6, 4);
		this.waist01.setRotationPoint(0F, 1F, 0F);
		this.waist01.setTextureSize(64, 32);
		this.waist01.mirror = true;
		this.setRotation(waist01, 0F, 0F, 0F);
		this.waist02 = new ModelRenderer(this, 64, 16);
		this.waist02.addBox(-3.5F, 11F, -1.5F, 7, 6, 4);
		this.waist02.setRotationPoint(0F, 1F, 0F);
		this.waist02.setTextureSize(64, 32);
		this.waist02.mirror = true;
		this.setRotation(waist02, 0F, 0F, 0F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 10, 2);
		this.rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarm.setTextureSize(64, 32);
		this.rightarm.mirror = true;
		this.setRotation(rightarm, 0F, 0F, 0.0872665F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 10, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarm.setTextureSize(64, 32);
		this.leftarm.mirror = true;
		this.setRotation(leftarm, 0F, 0F, -0.0872665F);
		this.rightpauldron = new ModelRenderer(this, 64, 0);
		this.rightpauldron.addBox(-3F, -2F, -1.5F, 3, 3, 3);
		this.rightpauldron.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightpauldron.setTextureSize(64, 32);
		this.rightpauldron.mirror = true;
		this.setRotation(rightpauldron, 0F, 0F, -0.1745329F);
		this.leftpauldron = new ModelRenderer(this, 76, 0);
		this.leftpauldron.addBox(0F, -2F, -1.5F, 3, 3, 3);
		this.leftpauldron.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftpauldron.setTextureSize(64, 32);
		this.leftpauldron.mirror = true;
		this.setRotation(leftpauldron, 0F, 0F, 0.1745329F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1F, 0F, -1F, 2, 13, 2);
		this.rightleg.setRotationPoint(-1.5F, 11F, 0F);
		this.rightleg.setTextureSize(64, 32);
		this.rightleg.mirror = true;
		this.setRotation(rightleg, 0F, 0F, 0.0349066F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.addBox(-1F, 0F, -1F, 2, 13, 2);
		this.leftleg.setRotationPoint(1.5F, 11F, 0F);
		this.leftleg.setTextureSize(64, 32);
		this.leftleg.mirror = true;
		this.setRotation(leftleg, 0F, 0F, -0.0349066F);
		this.leftfoot = new ModelRenderer(this, 64, 26);
		this.leftfoot.addBox(-1.5F, 8F, -1.5F, 3, 3, 3);
		this.leftfoot.setRotationPoint(1.5F, 11F, 0F);
		this.leftfoot.setTextureSize(64, 32);
		this.leftfoot.mirror = true;
		this.setRotation(leftfoot, 0F, 0F, -0.0349066F);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
		this.headaccessory.render(par7);
		this.hair.render(par7);
		this.bodytop.render(par7);
		this.bodymiddle.render(par7);
		this.bodymiddlebutton.render(par7);
		this.bodybottom.render(par7);
		this.waist01.render(par7);
		this.waist02.render(par7);
		this.rightarm.render(par7);
		this.leftarm.render(par7);
		this.rightpauldron.render(par7);
		this.leftpauldron.render(par7);
		this.rightleg.render(par7);
		this.leftleg.render(par7);
		this.leftfoot.render(par7);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {
		this.head.rotateAngleY = par4 / 57.295776F;
		this.head.rotateAngleX = par5 / 57.295776F;
		this.headaccessory.rotateAngleY = this.head.rotateAngleY;
		this.headaccessory.rotateAngleX = this.head.rotateAngleX;
		this.hair.rotateAngleY = this.head.rotateAngleY;
		this.hair.rotateAngleX = this.head.rotateAngleX;
		this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2 * 0.5F;
		this.rightpauldron.rotateAngleX = this.rightarm.rotateAngleX;
		this.leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2 * 0.5F;
		this.leftpauldron.rotateAngleX = this.leftarm.rotateAngleX;
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.5F * par2;
		this.leftfoot.rotateAngleX = this.leftleg.rotateAngleX;
	}
}
