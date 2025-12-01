package com.drd.mysticaladaptations.config;

import com.drd.mysticaladaptations.MysticalAdaptations;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;

@EventBusSubscriber(modid = MysticalAdaptations.MOD_ID)
public class ConfigHolder {

    //Mystical Agradditions
    public static int insaniumArmorAugments;
    public static int insaniumToolsAugments;

    //Vampirism Compat
    public static boolean thirstlessAugment;
    public static boolean daywalkerAugment;

    //Mob Drops
    public static boolean witherInsanium;
    public static boolean dragonInsanium;

    public static void updateConfigs(){
        witherInsanium = com.drd.mysticaladaptations.config.ModConfig.witherInsanium.get();
        dragonInsanium = com.drd.mysticaladaptations.config.ModConfig.dragonInsanium.get();
    }

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfigEvent event) {
        final ModConfig config = event.getConfig();

        if (config.getSpec() == com.drd.mysticaladaptations.config.ModConfig.spec) {
            updateConfigs();
        }
    }

}
