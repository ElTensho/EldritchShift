package net.tensho.eldritchshift;

//import com.github.alexthe666.iceandfire.entity.EntityDragonBase;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.tensho.eldritchshift.entity.ModEnitties;
import net.tensho.eldritchshift.entity.client.DragonoidRenderer;
import net.tensho.eldritchshift.item.ModCreativeModTabs;
import net.tensho.eldritchshift.item.ModItems;
import org.slf4j.Logger;
//import com.github.alexthe666.iceandfire.IceAndFire; // de aqui accedo al ais end faier

@Mod(EldritchShift.MOD_ID)
public class EldritchShift
{
    public static final String MOD_ID = "eldritchshift";

    private static final Logger LOGGER = LogUtils.getLogger();

    public EldritchShift(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        ModEnitties.register(modEventBus);

        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
            event.accept(ModItems.eldritchhearth);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

        LOGGER.info("HELLO from server starting");
    }
    @Mod.EventBusSubscriber(modid = EldritchShift.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public class ModEventSubscriber {

    }
    @Mod.EventBusSubscriber(modid = EldritchShift.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){
            EntityRenderers.register(ModEnitties.DRAGONOID.get(), DragonoidRenderer::new);
        }

    }

}
