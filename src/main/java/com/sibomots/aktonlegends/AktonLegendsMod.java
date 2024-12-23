package com.sibomots.aktonlegends;

import com.sibomots.aktonlegends.block.ModBlocks;
import com.sibomots.aktonlegends.creat.ModCreatModeTab;
import com.sibomots.aktonlegends.item.ModItems;
import net.neoforged.fml.loading.FMLEnvironment;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(AktonLegendsMod.MODID)
public class AktonLegendsMod
{
    public static final String MODID = "aktonlegends";
    private static final Logger LOGGER = LogUtils.getLogger();

    private void foo()
    {
        if (FMLEnvironment.dist == Dist.CLIENT)
        {
            LOGGER.info("On the Client... Enjoy");
        }
        else if (FMLEnvironment.dist == Dist.DEDICATED_SERVER)
        {
            LOGGER.info("On the Server... Enjoy");
        }
    }

    // The constructor for the mod class is the first code that 
    // is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or 
    // ModContainer and pass them in automatically.
    public AktonLegendsMod(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreatModeTab.register(modEventBus);
        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        foo();
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        //if (Config.logDirtBlock)
        //    LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
        //LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);
        // Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.BLOOMERY_BLOCK);
            event.accept(ModBlocks.SILVERLIGHT_ORE_BLOCK);
            event.accept(ModBlocks.VITREOUS_SILVERLIGHT_ORE_BLOCK);
        }

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.SILVERLIGHT_ORE_ITEMBLOCK);
            event.accept(ModItems.SILVERLIGHT_VITREOUS_ORE_ITEMBLOCK);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        // LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all 
    // static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            //LOGGER.info("HELLO FROM CLIENT SETUP");
            //LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
