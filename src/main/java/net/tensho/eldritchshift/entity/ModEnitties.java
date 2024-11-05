package net.tensho.eldritchshift.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tensho.eldritchshift.EldritchShift;
import net.tensho.eldritchshift.entity.custom.DragonoidEntity;

public class ModEnitties {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EldritchShift.MOD_ID);

    public static final RegistryObject<EntityType<DragonoidEntity>> DRAGONOID =
            ENTITY_TYPES.register("dragonoid", () -> EntityType.Builder.of(DragonoidEntity::new, MobCategory.CREATURE)
                    .sized(2.5f,2.5f).build("dragonoid"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
