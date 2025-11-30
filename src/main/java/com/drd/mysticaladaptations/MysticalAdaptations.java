package com.drd.mysticaladaptations;

import com.blakebr0.mysticalagriculture.item.tool.EssenceBowItem;
import com.blakebr0.mysticalagriculture.item.tool.EssenceCrossbowItem;
import com.blakebr0.mysticalagriculture.item.tool.EssenceFishingRodItem;
import com.drd.mysticaladaptations.init.ModArmorMaterials;
import com.drd.mysticaladaptations.init.ModCreativeModeTabs;
import com.drd.mysticaladaptations.init.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(MysticalAdaptations.MOD_ID)
public class MysticalAdaptations {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "mysticaladaptations";

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public MysticalAdaptations(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        modEventBus.register(new ModItems());

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (MysticalAdaptations) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        ModArmorMaterials.REGISTRY.register(modEventBus);
        ModCreativeModeTabs.REGISTRY.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @ModBus(modid = MOD_ID, bus = ModBus.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                ItemProperties.register(ModItems.INSANIUM_BOW.get(), ResourceLocation.withDefaultNamespace("pull"), EssenceBowItem.getPullPropertyGetter());
                ItemProperties.register(ModItems.INSANIUM_BOW.get(), ResourceLocation.withDefaultNamespace("pulling"), EssenceBowItem.getPullingPropertyGetter());
                ItemProperties.register(ModItems.INSANIUM_CROSSBOW.get(), ResourceLocation.withDefaultNamespace("pull"), EssenceCrossbowItem.getPullPropertyGetter());
                ItemProperties.register(ModItems.INSANIUM_CROSSBOW.get(), ResourceLocation.withDefaultNamespace("pulling"), EssenceCrossbowItem.getPullingPropertyGetter());
                ItemProperties.register(ModItems.INSANIUM_CROSSBOW.get(), ResourceLocation.withDefaultNamespace("charged"), EssenceCrossbowItem.getChargedPropertyGetter());
                ItemProperties.register(ModItems.INSANIUM_CROSSBOW.get(), ResourceLocation.withDefaultNamespace("firework"), EssenceCrossbowItem.getFireworkPropertyGetter());
                ItemProperties.register(ModItems.INSANIUM_FISHING_ROD.get(), ResourceLocation.withDefaultNamespace("cast"), EssenceFishingRodItem.getCastPropertyGetter());
            });
        }
    }

    public static ResourceLocation resource(String path) {
        return ResourceLocation.fromNamespaceAndPath("mysticaladaptations", path);
    }
}
