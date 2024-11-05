package net.tensho.eldritchshift.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.tensho.eldritchshift.EldritchShift;
import net.tensho.eldritchshift.entity.custom.DragonoidEntity;

public class DragonoidRenderer  extends MobRenderer<DragonoidEntity,DragonoidModel<DragonoidEntity>> {
    public DragonoidRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new DragonoidModel<>(pContext.bakeLayer(ModModelLayers.DRAGONOID_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(DragonoidEntity dragonoidEntity) {
        return new ResourceLocation(EldritchShift.MOD_ID, "textures/entity/dragonoid.png");
    }

    @Override
    public void render(DragonoidEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()){
            pMatrixStack.scale(0.5f,0.5f,0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
