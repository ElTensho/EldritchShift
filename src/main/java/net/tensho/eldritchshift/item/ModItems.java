package net.tensho.eldritchshift.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tensho.eldritchshift.EldritchShift;
import net.tensho.eldritchshift.item.custom.diamondResonatorItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EldritchShift.MOD_ID);

    public static final RegistryObject<Item> eldritchhearth = ITEMS.register("eldritch_hearth", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> irondetector = ITEMS.register("iron_detector", () -> new diamondResonatorItem(new Item.Properties().durability(100)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
