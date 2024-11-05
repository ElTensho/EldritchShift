package net.tensho.eldritchshift.event;


import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tensho.eldritchshift.EldritchShift;
import net.tensho.eldritchshift.entity.client.DragonoidModel;
import net.tensho.eldritchshift.entity.client.ModModelLayers;

@Mod.EventBusSubscriber(modid = EldritchShift.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.DRAGONOID_LAYER, DragonoidModel::createBodyLayer);

    }
}
