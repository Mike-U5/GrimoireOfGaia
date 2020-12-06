package gaia.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class ModelGaiaSuccubus extends ModelBase {
	ModelRenderer head;
	ModelRenderer headaccessory;
	ModelRenderer horns;
    ModelRenderer hair1;
    ModelRenderer hair2;
	ModelRenderer bodytop;
	ModelRenderer bodymiddle;
	ModelRenderer bodymiddlebutton;
	ModelRenderer bodybottom;
	ModelRenderer rightwing;
	ModelRenderer leftwing;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightpauldron;
	ModelRenderer leftpauldron;
	ModelRenderer rightchest;
	ModelRenderer leftchest;
	ModelRenderer tail;
	ModelRenderer waist;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer rightleglower;
	ModelRenderer leftleglower;
	ModelRenderer rightfoot;
	ModelRenderer leftfoot;

	public ModelGaiaSuccubus() {
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
		this.horns = new ModelRenderer(this, 36, 14);
		this.horns.addBox(-4F, -7F, -4F, 8, 4, 8);
		this.horns.setRotationPoint(0F, 1F, 0F);
		this.horns.setTextureSize(64, 32);
		this.horns.mirror = true;
		this.setRotation(horns, 0F, 0F, 0F);
		this.hair1 = new ModelRenderer(this, 36, 26);
		this.hair1.addBox(-4F, -6F, 1F, 8, 8, 3);
		this.hair1.setRotationPoint(0F, 1F, 0F);
		this.hair1.setTextureSize(64, 32);
		this.hair1.mirror = true;
		this.setRotation(hair1, 0F, 0F, 0F);
		this.hair2 = new ModelRenderer(this, 36, 37);
		this.hair2.addBox(-4.5F, -1F, 1.5F, 9, 9, 3);
		this.hair2.setRotationPoint(0F, 1F, 0F);
		this.hair2.setTextureSize(64, 32);
		this.hair2.mirror = true;
		this.setRotation(hair2, 0F, 0F, 0F);
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
		this.rightwing = new ModelRenderer(this, 104, 42);
		this.rightwing.addBox(0F, -1F, 0F, 0, 14, 8);
		this.rightwing.setRotationPoint(-1.5F, 2F, 2F);
		this.rightwing.setTextureSize(64, 32);
		this.rightwing.mirror = true;
		this.setRotation(rightwing, 0.5235988F, -0.7853982F, 0F);
		this.leftwing = new ModelRenderer(this, 112, 42);
		this.leftwing.addBox(0F, -1F, 0F, 0, 14, 8);
		this.leftwing.setRotationPoint(1.5F, 2F, 2F);
		this.leftwing.setTextureSize(64, 32);
		this.leftwing.mirror = true;
		this.setRotation(leftwing, 0.5235988F, 0.7853982F, 0F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 10, 2);
		this.rightarm.setRotationPoint(-2.5F, 2.5F, -0.5F);
		this.rightarm.setTextureSize(64, 32);
		this.rightarm.mirror = true;
		this.setRotation(rightarm, 0.0872665F, 0F, 0.0872665F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 10, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, -0.5F);
		this.leftarm.setTextureSize(64, 32);
		this.leftarm.mirror = true;
		this.setRotation(leftarm, 0.0872665F, 0F, -0.0872665F);
		this.rightpauldron = new ModelRenderer(this, 68, 0);
		this.rightpauldron.addBox(-2.5F, -1F, -1.5F, 3, 3, 3);
		this.rightpauldron.setRotationPoint(-2.5F, 2.5F, -0.5F);
		this.rightpauldron.setTextureSize(64, 32);
		this.rightpauldron.mirror = true;
		this.setRotation(rightpauldron, 0.0872665F, 0F, 0.0872665F);
		this.leftpauldron = new ModelRenderer(this, 80, 0);
		this.leftpauldron.addBox(-0.5F, -1F, -1.5F, 3, 3, 3);
		this.leftpauldron.setRotationPoint(2.5F, 2.5F, -0.5F);
		this.leftpauldron.setTextureSize(64, 32);
		this.leftpauldron.mirror = true;
		this.setRotation(leftpauldron, 0.0872665F, 0F, -0.0872665F);
		this.rightchest = new ModelRenderer(this, 0, 31);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.3F, 3F, -2F);
		this.rightchest.setTextureSize(64, 32);
		this.rightchest.mirror = true;
		this.setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		this.leftchest = new ModelRenderer(this, 8, 31);
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.3F, 3F, -2F);
		this.leftchest.setTextureSize(64, 32);
		this.leftchest.mirror = true;
		this.setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		this.tail = new ModelRenderer(this, 68, 6);
		this.tail.addBox(-1F, 0F, -0.5F, 2, 9, 0);
		this.tail.setRotationPoint(0F, 9F, 2F);
		this.tail.setTextureSize(64, 32);
		this.tail.mirror = true;
		this.setRotation(tail, 0.3490659F, 0F, 0F);
		this.waist = new ModelRenderer(this, 68, 15);
		this.waist.addBox(-3F, 9F, -2F, 6, 4, 4);
		this.waist.setRotationPoint(0F, 1F, 0F);
		this.waist.setTextureSize(64, 32);
		this.waist.mirror = true;
		this.setRotation(waist, 0F, 0F, 0F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1F, 0F, -1F, 2, 6, 2);
		this.rightleg.setRotationPoint(-1.5F, 11F, 0F);
		this.rightleg.setTextureSize(64, 32);
		this.rightleg.mirror = true;
		this.setRotation(rightleg, -0.1745329F, 0F, 0F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.addBox(-1F, 0F, -1F, 2, 6, 2);
		this.leftleg.setRotationPoint(1.5F, 11F, 0F);
		this.leftleg.setTextureSize(64, 32);
		this.leftleg.mirror = true;
		this.setRotation(leftleg, -0.1745329F, 0F, 0F);
		this.rightleglower = new ModelRenderer(this, 68, 23);
		this.rightleglower.addBox(-1.5F, 4F, 1F, 3, 8, 3);
		this.rightleglower.setRotationPoint(-1.5F, 11F, 0F);
		this.rightleglower.setTextureSize(64, 32);
		this.rightleglower.mirror = true;
		this.setRotation(rightleglower, -0.2617994F, 0F, 0F);
		this.leftleglower = new ModelRenderer(this, 68, 23);
		this.leftleglower.addBox(-1.5F, 4F, 1F, 3, 8, 3);
		this.leftleglower.setRotationPoint(1.5F, 11F, 0F);
		this.leftleglower.setTextureSize(64, 32);
		this.leftleglower.mirror = true;
		this.setRotation(leftleglower, -0.2617994F, 0F, 0F);
		this.rightfoot = new ModelRenderer(this, 68, 34);
		this.rightfoot.addBox(-1.5F, 11F, -3F, 3, 2, 3);
		this.rightfoot.setRotationPoint(-1.5F, 11F, 0F);
		this.rightfoot.setTextureSize(64, 32);
		this.rightfoot.mirror = true;
		this.setRotation(rightfoot, 0F, 0F, 0F);
		this.leftfoot = new ModelRenderer(this, 68, 34);
		this.leftfoot.addBox(-1.5F, 11F, -3F, 3, 2, 3);
		this.leftfoot.setRotationPoint(1.5F, 11F, 0F);
		this.leftfoot.setTextureSize(64, 32);
		this.leftfoot.mirror = true;
		this.setRotation(leftfoot, 0F, 0F, 0F);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
		this.headaccessory.render(par7);
		this.horns.render(par7);
		this.hair1.render(par7);
		this.hair2.render(par7);
		this.bodytop.render(par7);
		this.bodymiddle.render(par7);
		this.bodymiddlebutton.render(par7);
		this.bodybottom.render(par7);
		this.rightwing.render(par7);
		this.leftwing.render(par7);
		this.rightarm.render(par7);
		this.leftarm.render(par7);
		this.rightpauldron.render(par7);
		this.leftpauldron.render(par7);
		this.rightchest.render(par7);
		this.leftchest.render(par7);
		this.tail.render(par7);
		this.waist.render(par7);
		this.rightleg.render(par7);
		this.leftleg.render(par7);
		this.rightleglower.render(par7);
		this.leftleglower.render(par7);
		this.rightfoot.render(par7);
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
		this.horns.rotateAngleY = this.head.rotateAngleY;
		this.horns.rotateAngleX = this.head.rotateAngleX;
		this.hair1.rotateAngleY = this.head.rotateAngleY;
		this.hair2.rotateAngleY = this.head.rotateAngleY;
		this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2 * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2 * 0.5F;
		this.rightpauldron.rotateAngleX = this.rightarm.rotateAngleX + 0.0872665F;
		this.leftpauldron.rotateAngleX = this.leftarm.rotateAngleX + 0.0872665F;
		this.rightarm.rotateAngleX += 0.0872665F;
		this.leftarm.rotateAngleX += 0.0872665F;
		this.rightchest.rotateAngleX = (MathHelper.cos(par1 * 0.6662F) * 0.8F * par2) + 0.7853982F;
		this.leftchest.rotateAngleX = this.rightchest.rotateAngleX;
		this.rightwing.rotateAngleY = MathHelper.cos(par3 * 0.3F + (float)Math.PI) * 1.0F * par2 * 0.5F;
		this.leftwing.rotateAngleY = MathHelper.cos(par3 * 0.3F) * 1.0F * par2 * 0.5F;
		--this.rightwing.rotateAngleY;
		++this.leftwing.rotateAngleY;
		this.tail.rotateAngleY = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2;
		this.rightleglower.rotateAngleX = this.rightleg.rotateAngleX - 0.2617994F;
		this.leftleglower.rotateAngleX = this.leftleg.rotateAngleX - 0.2617994F;
		this.rightfoot.rotateAngleX = this.rightleg.rotateAngleX;
		this.leftfoot.rotateAngleX = this.leftleg.rotateAngleX;
		this.rightleg.rotateAngleX -= 0.1745329F;
		this.leftleg.rotateAngleX -= 0.1745329F;
		
        float f6;
        float f7;

        if (this.onGround > -9990.0F)
        {
            f6 = this.onGround;
            f6 = 1.0F - this.onGround;
            f6 *= f6;
            f6 *= f6;
            f6 = 1.0F - f6;
            f7 = MathHelper.sin(f6 * (float)Math.PI);
            float f8 = MathHelper.sin(this.onGround * (float)Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
            
            this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8)) + 0.0872665F;
            this.rightpauldron.rotateAngleX = this.rightarm.rotateAngleX;
            this.rightarm.rotateAngleY += (this.bodytop.rotateAngleY * 2.0F);
            this.rightpauldron.rotateAngleY = this.rightarm.rotateAngleY;
            this.rightarm.rotateAngleZ = (MathHelper.sin(this.onGround * (float)Math.PI) * -0.4F) + 0.0872665F;
            this.rightpauldron.rotateAngleZ = this.rightarm.rotateAngleZ;
        }
	}
}
