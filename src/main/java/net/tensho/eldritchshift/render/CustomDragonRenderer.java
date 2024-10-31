package net.tensho.eldritchshift.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.PigModel;
import net.minecraft.client.model.PiglinModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EnderDragonRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.tensho.eldritchshift.entities.CustomDragon;
import net.tensho.eldritchshift.models.HumanoidModel;

public class CustomDragonRenderer extends EntityRenderer<CustomDragon> {
    private final PiglinModel dragonModel;
    private final HumanoidModel humanoidModel;

    public CustomDragonRenderer(EntityRendererProvider.Context context, HumanoidModel humanoidModel) {
        super(context);
        this.dragonModel = new PiglinModel(context.bakeLayer(HumanoidModel.LAYER_LOCATION));
        this.humanoidModel = new HumanoidModel(context.bakeLayer(HumanoidModel.LAYER_LOCATION));
    }

    @Override
    public void render(CustomDragon entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();
        if (entity.isHumanoid()) {
            // Renderiza el modelo especial
            humanoidModel.renderToBuffer(poseStack, bufferSource.getBuffer(humanoidModel.renderType(getTextureLocation(entity))), packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 0.5F, 0.5F, 1.0F);
        } else {
            // Renderiza el modelo normal
            dragonModel.renderToBuffer(poseStack, bufferSource.getBuffer(dragonModel.renderType(getTextureLocation(entity))), packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        }
        poseStack.popPose();
    }



    @Override
    public ResourceLocation getTextureLocation(CustomDragon customDragon) {
        return null;
    }
}
