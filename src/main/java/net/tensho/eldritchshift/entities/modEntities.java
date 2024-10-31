package net.tensho.eldritchshift.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistry;
import net.tensho.eldritchshift.EldritchShift;

public class modEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EldritchShift.MOD_ID);

    public static final RegistryObject<EntityType<CustomDragon>> CUSTOM_DRAGON = ENTITIES.register("custom_dragon",
            () -> EntityType.Builder.of(CustomDragon::new, MobCategory.CREATURE)
                    .sized(0.9F, 0.9F) // Tamaño del cerdo
                    .build("custom_pig"));

    @SubscribeEvent
    public static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(CUSTOM_DRAGON.get(), CustomDragon.createAttributes().build());
    }

}