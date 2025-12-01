package com.drd.mysticaladaptations.lib;

import com.blakebr0.mysticalagriculture.MysticalAgriculture;
import com.blakebr0.mysticalagriculture.api.registry.IAugmentRegistry;
import com.blakebr0.mysticalagriculture.api.tinkering.Augment;
import com.blakebr0.mysticalagriculture.augment.*;
import com.drd.mysticaladaptations.augment.DaywalkerAugment;
import com.drd.mysticaladaptations.augment.HungerlessAugment;
import com.drd.mysticaladaptations.augment.ThirstlessAugment;
import com.drd.mysticaladaptations.augment.WoodcutterAugment;
import net.neoforged.fml.ModList;

public class ModAugments {
    public static final Augment HUNGERLESS = new HungerlessAugment(MysticalAgriculture.resource("hungerless"));
    public static final Augment WOODCUTTER = new WoodcutterAugment(MysticalAgriculture.resource("woodcutter"));
    public static final Augment MINING_AOE_V = new MiningAOEAugment(MysticalAgriculture.resource("mining_aoe_v"), 6, 5);
    public static final Augment STRENGTH_IV = new StrengthAugment(MysticalAgriculture.resource("strength_iv"), 6, 5);
    public static final Augment ABSORPTION_VI = new AbsorptionAugment(MysticalAgriculture.resource("absorption_vi"), 6, 5);
    public static final Augment HEALTH_BOOST_VI = new HealthBoostAugment(MysticalAgriculture.resource("health_boost_vi"), 6, 6);
    public static final Augment ATTACK_AOE_IV = new AttackAOEAugment(MysticalAgriculture.resource("attack_aoe_iv"), 6, 4);
    public static final Augment TILLING_AOE_V = new TillingAOEAugment(MysticalAgriculture.resource("tilling_aoe_v"), 6, 5);

    public static Augment DAYWALKER;
    public static Augment THIRSTLESS;

    public static void onRegisterAugments(IAugmentRegistry registry) {
        registry.register(HUNGERLESS);
        registry.register(WOODCUTTER);
        registry.register(MINING_AOE_V);
        registry.register(STRENGTH_IV);
        registry.register(ABSORPTION_VI);
        registry.register(HEALTH_BOOST_VI);
        registry.register(ATTACK_AOE_IV);
        registry.register(TILLING_AOE_V);

        if(ModList.get().isLoaded("vampirism")) {
            DAYWALKER = new DaywalkerAugment(MysticalAgriculture.resource("daywalker"));
            THIRSTLESS = new ThirstlessAugment(MysticalAgriculture.resource("thirstless"));
            registry.register(DAYWALKER);
            registry.register(THIRSTLESS);
        }
    }
}