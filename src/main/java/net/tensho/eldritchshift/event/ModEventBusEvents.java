package net.tensho.eldritchshift.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tensho.eldritchshift.EldritchShift;
import net.tensho.eldritchshift.entity.ModEnitties;
import net.tensho.eldritchshift.entity.custom.DragonoidEntity;

@Mod.EventBusSubscriber(modid = EldritchShift.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEnitties.DRAGONOID.get(), DragonoidEntity.createAttributes().build());
    }
}
