package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaSphinx extends ModelGaia {
	ModelRenderer head;
    ModelRenderer headeyes;
	ModelRenderer headaccessory;
	ModelRenderer neck;
	ModelRenderer body1;
	ModelRenderer rightchest;
	ModelRenderer leftchest;
	ModelRenderer rightarm1;
	ModelRenderer leftarm1;
	ModelRenderer rightear;
	ModelRenderer leftear;
	ModelRenderer hair;
	ModelRenderer crown;
	ModelRenderer rightarm2;
	ModelRenderer leftarm2;
	ModelRenderer rightarm3;
	ModelRenderer leftarm3;
	ModelRenderer rightarmbracelet;
	ModelRenderer leftarmbracelet;
	ModelRenderer body2;
	ModelRenderer body3;
	ModelRenderer tail;
	ModelRenderer rightbackleg1;
	ModelRenderer leftbackleg1;
	ModelRenderer rightbackleg2;
	ModelRenderer leftbackleg2;
	ModelRenderer rightbackleg3;
	ModelRenderer leftbackleg3;
	ModelRenderer rightbacklegbracelet;
	ModelRenderer leftbacklegbracelet;
	ModelRenderer rightbackleg4;
	ModelRenderer leftbackleg4;
	ModelRenderer rightwing;
	ModelRenderer leftwing;

	public ModelGaiaSphinx() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6.5F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, 8F, -7.5F);
		this.head.setTextureSize(64, 32);
		this.setRotation(head, 0F, 0F, 0F);
		this.headeyes = new ModelRenderer(this, 24, 0);
		this.headeyes.addBox(-3F, -6.5F, -3.1F, 6, 6, 0);
		this.headeyes.setRotationPoint(0F, 8F, -7.5F);
		this.headeyes.setTextureSize(64, 32);
		this.setRotation(headeyes, 0F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -7F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, 8F, -7.5F);
		this.headaccessory.setTextureSize(64, 32);
		this.setRotation(headaccessory, 0F, 0F, 0F);
		this.neck = new ModelRenderer(this, 0, 12);
		this.neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.neck.setRotationPoint(0F, 8F, -7.5F);
		this.neck.setTextureSize(64, 32);
		this.setRotation(neck, 0.5235988F, 0F, 0F);
		this.body1 = new ModelRenderer(this, 0, 16);
		this.body1.addBox(-2.5F, 0F, -2F, 5, 6, 3);
		this.body1.setRotationPoint(0F, 8F, -7F);
		this.body1.setTextureSize(64, 32);
		this.setRotation(body1, 0.6981317F, 0F, 0F);
		this.rightchest = new ModelRenderer(this, 0, 25);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.3F, 11F, -7F);
		this.rightchest.setTextureSize(64, 32);
		this.setRotation(rightchest, 1.48353F, 0.1745329F, 0.0872665F);
		this.leftchest = new ModelRenderer(this, 0, 25);
		this.leftchest.mirror = true;
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.3F, 11F, -7F);
		this.leftchest.setTextureSize(64, 32);
		this.setRotation(leftchest, 1.48353F, -0.1745329F, -0.0872665F);
		this.rightarm1 = new ModelRenderer(this, 18, 12);
		this.rightarm1.addBox(-2F, 0F, -1.5F, 2, 8, 2);
		this.rightarm1.setRotationPoint(-2.5F, 8F, -6F);
		this.rightarm1.setTextureSize(64, 32);
		this.setRotation(rightarm1, 0.1745329F, 0F, -0.0349066F);
		this.leftarm1 = new ModelRenderer(this, 18, 12);
		this.leftarm1.addBox(-0.5F, 0F, -1.5F, 2, 8, 2);
		this.leftarm1.setRotationPoint(3F, 8F, -6F);
		this.leftarm1.setTextureSize(64, 32);
		this.setRotation(leftarm1, 0.1745329F, 0F, 0.0349066F);
		this.rightear = new ModelRenderer(this, 36, 14);
		this.rightear.addBox(-4.5F, -10.5F, -1.5F, 3, 4, 3);
		this.rightear.setRotationPoint(0F, 8F, -7.5F);
		this.rightear.setTextureSize(64, 32);
		this.setRotation(rightear, 0F, 0F, 0F);
		this.leftear = new ModelRenderer(this, 48, 14);
		this.leftear.addBox(1.5F, -10.5F, -1.5F, 3, 4, 3);
		this.leftear.setRotationPoint(0F, 8F, -7.5F);
		this.leftear.setTextureSize(64, 32);
		this.setRotation(leftear, 0F, 0F, 0F);
		this.hair = new ModelRenderer(this, 36, 21);
		this.hair.addBox(-4F, -5.5F, -2F, 8, 6, 6);
		this.hair.setRotationPoint(0F, 8F, -7.5F);
		this.hair.setTextureSize(64, 32);
		this.setRotation(hair, 0F, 0F, 0F);
		this.crown = new ModelRenderer(this, 36, 33);
		this.crown.addBox(-1F, -8F, -4.6F, 2, 3, 1);
		this.crown.setRotationPoint(0F, 8F, -7.5F);
		this.crown.setTextureSize(64, 32);
		this.setRotation(crown, 0F, 0F, 0F);
		this.rightarm2 = new ModelRenderer(this, 18, 22);
		this.rightarm2.addBox(-2F, 7F, 1F, 2, 7, 3);
		this.rightarm2.setRotationPoint(-2.5F, 8F, -6F);
		this.rightarm2.setTextureSize(64, 32);
		this.setRotation(rightarm2, -0.1745329F, 0F, -0.0349066F);
		this.leftarm2 = new ModelRenderer(this, 18, 22);
		this.leftarm2.addBox(-0.5F, 7F, 1F, 2, 7, 3);
		this.leftarm2.setRotationPoint(3F, 8F, -6F);
		this.leftarm2.setTextureSize(64, 32);
		this.setRotation(leftarm2, -0.1745329F, 0F, 0.0349066F);
		this.rightarm3 = new ModelRenderer(this, 18, 32);
		this.rightarm3.addBox(-2.5F, 11F, -10F, 3, 2, 3);
		this.rightarm3.setRotationPoint(-2.5F, 8F, -6F);
		this.rightarm3.setTextureSize(64, 32);
		this.setRotation(rightarm3, 0.5235988F, 0F, -0.0349066F);
		this.leftarm3 = new ModelRenderer(this, 18, 32);
		this.leftarm3.addBox(-1F, 11F, -10F, 3, 2, 3);
		this.leftarm3.setRotationPoint(3F, 8F, -6F);
		this.leftarm3.setTextureSize(64, 32);
		this.setRotation(leftarm3, 0.5235988F, 0F, 0.0349066F);
		this.rightarmbracelet = new ModelRenderer(this, 36, 37);
		this.rightarmbracelet.addBox(-3F, 11F, 0.5F, 4, 2, 4);
		this.rightarmbracelet.setRotationPoint(-2.5F, 8F, -6F);
		this.rightarmbracelet.setTextureSize(64, 32);
		this.setRotation(rightarmbracelet, -0.1745329F, 0F, -0.0349066F);
		this.leftarmbracelet = new ModelRenderer(this, 36, 37);
		this.leftarmbracelet.addBox(-1.5F, 11F, 0.5F, 4, 2, 4);
		this.leftarmbracelet.setRotationPoint(3F, 8F, -6F);
		this.leftarmbracelet.setTextureSize(64, 32);
		this.setRotation(leftarmbracelet, -0.1745329F, 0F, 0.0349066F);
		this.body2 = new ModelRenderer(this, 66, 0);
		this.body2.addBox(-3.5F, -3F, -7.5F, 7, 7, 8);
		this.body2.setRotationPoint(0F, 8F, -1F);
		this.body2.setTextureSize(64, 32);
		this.setRotation(body2, 1.396263F, 0F, 0F);
		this.body3 = new ModelRenderer(this, 66, 15);
		this.body3.addBox(-3F, 3F, -8F, 6, 10, 7);
		this.body3.setRotationPoint(0F, 8F, -3F);
		this.body3.setTextureSize(64, 32);
		this.setRotation(body3, 1.745329F, 0F, 0F);
		this.tail = new ModelRenderer(this, 66, 32);
		this.tail.addBox(-0.5F, 0F, -0.5F, 1, 12, 1);
		this.tail.setRotationPoint(0F, 8F, 10F);
		this.tail.setTextureSize(64, 32);
		this.setRotation(tail, 0.6108652F, 0F, 0F);
		this.rightbackleg1 = new ModelRenderer(this, 96, 0);
		this.rightbackleg1.addBox(-1.5F, 0F, -3F, 3, 8, 6);
		this.rightbackleg1.setRotationPoint(-3F, 8F, 9F);
		this.rightbackleg1.setTextureSize(64, 32);
		this.setRotation(rightbackleg1, -0.296706F, 0F, 0.0349066F);
		this.leftbackleg1 = new ModelRenderer(this, 96, 0);
		this.leftbackleg1.addBox(-1.5F, 0F, -3F, 3, 8, 6);
		this.leftbackleg1.setRotationPoint(3F, 8F, 9F);
		this.leftbackleg1.setTextureSize(64, 32);
		this.setRotation(leftbackleg1, -0.296706F, 0F, -0.0349066F);
		this.rightbackleg2 = new ModelRenderer(this, 96, 14);
		this.rightbackleg2.addBox(-1F, 5.5F, 2F, 2, 3, 6);
		this.rightbackleg2.setRotationPoint(-3F, 8F, 9F);
		this.rightbackleg2.setTextureSize(64, 32);
		this.setRotation(rightbackleg2, -0.8726646F, 0F, 0.0349066F);
		this.leftbackleg2 = new ModelRenderer(this, 96, 14);
		this.leftbackleg2.addBox(-1F, 5.5F, 2F, 2, 3, 6);
		this.leftbackleg2.setRotationPoint(3F, 8F, 9F);
		this.leftbackleg2.setTextureSize(64, 32);
		this.setRotation(leftbackleg2, -0.8726646F, 0F, -0.0349066F);
		this.rightbackleg3 = new ModelRenderer(this, 96, 23);
		this.rightbackleg3.addBox(-1F, 9F, 1F, 2, 6, 3);
		this.rightbackleg3.setRotationPoint(-3F, 8F, 9F);
		this.rightbackleg3.setTextureSize(64, 32);
		this.setRotation(rightbackleg3, -0.2617994F, 0F, 0.0349066F);
		this.leftbackleg3 = new ModelRenderer(this, 96, 23);
		this.leftbackleg3.addBox(-1F, 9F, 1F, 2, 6, 3);
		this.leftbackleg3.setRotationPoint(3F, 8F, 9F);
		this.leftbackleg3.setTextureSize(64, 32);
		this.setRotation(leftbackleg3, -0.2617994F, 0F, -0.0349066F);
		this.rightbacklegbracelet = new ModelRenderer(this, 36, 37);
		this.rightbacklegbracelet.addBox(-2F, 12F, 0.5F, 4, 2, 4);
		this.rightbacklegbracelet.setRotationPoint(-3F, 8F, 9F);
		this.rightbacklegbracelet.setTextureSize(64, 32);
		this.setRotation(rightbacklegbracelet, -0.2617994F, 0F, 0.0349066F);
		this.leftbacklegbracelet = new ModelRenderer(this, 36, 37);
		this.leftbacklegbracelet.addBox(-2F, 12F, 0.5F, 4, 2, 4);
		this.leftbacklegbracelet.setRotationPoint(3F, 8F, 9F);
		this.leftbacklegbracelet.setTextureSize(64, 32);
		this.setRotation(leftbacklegbracelet, -0.2617994F, 0F, -0.0349066F);
		this.rightbackleg4 = new ModelRenderer(this, 96, 32);
		this.rightbackleg4.addBox(-1.5F, 14F, -5F, 3, 2, 3);
		this.rightbackleg4.setRotationPoint(-3F, 8F, 9F);
		this.rightbackleg4.setTextureSize(64, 32);
		this.setRotation(rightbackleg4, 0.0872665F, 0F, 0.0349066F);
		this.leftbackleg4 = new ModelRenderer(this, 96, 32);
		this.leftbackleg4.addBox(-1.5F, 14F, -5F, 3, 2, 3);
		this.leftbackleg4.setRotationPoint(3F, 8F, 9F);
		this.leftbackleg4.setTextureSize(64, 32);
		this.setRotation(leftbackleg4, 0.0872665F, 0F, -0.0349066F);
		this.rightwing = new ModelRenderer(this, 92, 36);
		this.rightwing.addBox(0F, -1F, -1F, 0, 16, 12);
		this.rightwing.setRotationPoint(-4F, 8F, -4F);
		this.rightwing.setTextureSize(64, 32);
		this.setRotation(rightwing, 1.22173F, -0.5235988F, 0.2617994F);
		this.leftwing = new ModelRenderer(this, 104, 36);
		this.leftwing.addBox(0F, -1F, -1F, 0, 16, 12);
		this.leftwing.setRotationPoint(4F, 8F, -4F);
		this.leftwing.setTextureSize(64, 32);
		this.setRotation(leftwing, 1.22173F, 0.5235988F, -0.2617994F);
		
		this.convertToChild(head, rightear);
		this.convertToChild(head, leftear);
		this.convertToChild(head, hair);
		this.convertToChild(head, crown);
		this.convertToChild(rightarm3, rightarm1);
		this.convertToChild(rightarm3, rightarm2);
		this.convertToChild(rightarm3, rightarmbracelet);
		this.convertToChild(leftarm3, leftarm1);
		this.convertToChild(leftarm3, leftarm2);
		this.convertToChild(leftarm3, leftarmbracelet);
		this.convertToChild(rightbackleg1, rightbackleg2);
		this.convertToChild(rightbackleg1, rightbackleg3);
		this.convertToChild(rightbackleg1, rightbacklegbracelet);
		this.convertToChild(rightbackleg1, rightbackleg4);
		this.convertToChild(leftbackleg1, leftbackleg2);
		this.convertToChild(leftbackleg1, leftbackleg3);
		this.convertToChild(leftbackleg1, leftbacklegbracelet);
		this.convertToChild(leftbackleg1, leftbackleg4);
	}

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		this.head.render(scale);
		this.headaccessory.render(scale);
		this.neck.render(scale);
		this.body1.render(scale);
		this.rightchest.render(scale);
		this.leftchest.render(scale);
//		this.rightarm1.render(scale);
//		this.leftarm1.render(scale);
//		this.rightear.render(scale);
//		this.leftear.render(scale);
//		this.hair.render(scale);
//		this.crown.render(scale);
//		this.rightarm2.render(scale);
//		this.leftarm2.render(scale);
		this.rightarm3.render(scale);
		this.leftarm3.render(scale);
//		this.rightarmbracelet.render(scale);
//		this.leftarmbracelet.render(scale);
		this.body2.render(scale);
		this.body3.render(scale);
		this.tail.render(scale);
		this.rightbackleg1.render(scale);
		this.leftbackleg1.render(scale);
//		this.rightbackleg2.render(scale);
//		this.leftbackleg2.render(scale);
//		this.rightbackleg3.render(scale);
//		this.leftbackleg3.render(scale);
//		this.rightbacklegbracelet.render(scale);
//		this.leftbacklegbracelet.render(scale);
//		this.rightbackleg4.render(scale);
//		this.leftbackleg4.render(scale);
		this.rightwing.render(scale);
		this.leftwing.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			this.headeyes.render(scale);
		}
	}
    
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		//head
		this.head.rotateAngleY = netHeadYaw / 57.295776F;
		this.head.rotateAngleX = headPitch / 57.295776F;
		this.headeyes.rotateAngleY = this.head.rotateAngleY;
		this.headeyes.rotateAngleX = this.head.rotateAngleX;
		this.headaccessory.rotateAngleY = this.head.rotateAngleY;
		this.headaccessory.rotateAngleX = this.head.rotateAngleX;
		
		//arms
		this.rightarm3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		this.leftarm3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.8F * limbSwingAmount;
		
		this.rightarm3.rotateAngleX += 0.5235988F;
		this.leftarm3.rotateAngleX += 0.5235988F;
		
		//body
		this.rightwing.rotateAngleY = MathHelper.cos(ageInTicks * 0.6662F + (float)Math.PI) * 1.0F * limbSwingAmount * 0.5F;
		this.leftwing.rotateAngleY = MathHelper.cos(ageInTicks * 0.6662F) * 1.0F * limbSwingAmount * 0.5F;
		this.rightwing.rotateAngleY -= 0.5235988F;
		this.leftwing.rotateAngleY += 0.5235988F;
		
		this.tail.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		
		//legs
		this.rightbackleg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.8F * limbSwingAmount;
		this.leftbackleg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		this.rightbackleg1.rotateAngleX -= 0.296706F;
		this.leftbackleg1.rotateAngleX -= 0.296706F;
	}
}
