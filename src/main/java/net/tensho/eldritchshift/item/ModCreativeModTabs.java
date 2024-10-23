package net.tensho.eldritchshift.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;
import net.tensho.eldritchshift.EldritchShift;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EldritchShift.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ELDRITCH_TAB = CREATIVE_MODE_TABS.register("eldritch_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.eldritchhearth.get()))
                    .title(Component.translatable("creativetab.eldritchtab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.eldritchhearth.get());
                        output.accept(ModItems.irondetector.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
