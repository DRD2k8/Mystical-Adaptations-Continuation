package com.drd.mysticaladaptations;

import com.blakebr0.mysticalagriculture.item.tool.EssenceBowItem;
import com.blakebr0.mysticalagriculture.item.tool.EssenceCrossbowItem;
import com.blakebr0.mysticalagriculture.item.tool.EssenceFishingRodItem;
import com.drd.mysticaladaptations.handlers.MobDropsHandler;
import com.drd.mysticaladaptations.init.ModArmorMaterials;
import com.drd.mysticaladaptations.init.ModCreativeModeTabs;
import com.drd.mysticaladaptations.init.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
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
import net.neoforged.neoforge.event.server.ServerStartedEvent;
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
        modContainer.registerConfig(ModConfig.Type.COMMON, com.drd.mysticaladaptations.config.ModConfig.spec);

        NeoForge.EVENT_BUS.register(new MobDropsHandler());

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

    @SubscribeEvent
    public static void onServerStarted(ServerStartedEvent event) {
        MinecraftServer server = event.getServer();
        RecipeManager manager = server.getRecipeManager();

        Recipe<?> orniumAxe = manager.byKey(ResourceLocation.fromNamespaceAndPath("mysticalextendedtier", "gear/ornium_axe")).orElse(null).value();
        Recipe<?> orniumBoots = manager.byKey(ResourceLocation.fromNamespaceAndPath("mysticalextendedtier", "gear/ornium_boots")).orElse(null).value();
        Recipe<?> orniumChestplate = manager.byKey(ResourceLocation.fromNamespaceAndPath("mysticalextendedtier", "gear/ornium_chestplate")).orElse(null).value();
        Recipe<?> orniumHelmet = manager.byKey(ResourceLocation.fromNamespaceAndPath("mysticalextendedtier", "gear/ornium_helmet")).orElse(null).value();
        Recipe<?> orniumHoe = manager.byKey(ResourceLocation.fromNamespaceAndPath("mysticalextendedtier", "gear/ornium_hoe")).orElse(null).value();
        Recipe<?> orniumLeggings = manager.byKey(ResourceLocation.fromNamespaceAndPath("mysticalextendedtier", "gear/ornium_leggings")).orElse(null).value();
        Recipe<?> orniumPickaxe = manager.byKey(ResourceLocation.fromNamespaceAndPath("mysticalextendedtier", "gear/ornium_pickaxe")).orElse(null).value();
        Recipe<?> orniumShears = manager.byKey(ResourceLocation.fromNamespaceAndPath("mysticalextendedtier", "gear/ornium_shears")).orElse(null).value();
        Recipe<?> orniumShovel = manager.byKey(ResourceLocation.fromNamespaceAndPath("mysticalextendedtier", "gear/ornium_shovel")).orElse(null).value();
        Recipe<?> orniumSword = manager.byKey(ResourceLocation.fromNamespaceAndPath("mysticalextendedtier", "gear/ornium_sword")).orElse(null).value();
        Recipe<?> orniumWateringCan = manager.byKey(ResourceLocation.fromNamespaceAndPath("mysticalextendedtier", "gear/ornium_watering_can")).orElse(null).value();

        if (orniumAxe != null) {
        }
        if (orniumBoots != null) {
        }
        if (orniumChestplate != null) {
        }
        if (orniumHelmet != null) {
        }
        if (orniumHoe != null) {
        }
        if (orniumLeggings != null) {
        }
        if (orniumPickaxe != null) {
        }
        if (orniumShears != null) {
        }
        if (orniumShovel != null) {
        }
        if (orniumSword != null) {
        }
        if (orniumWateringCan != null) {
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
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
