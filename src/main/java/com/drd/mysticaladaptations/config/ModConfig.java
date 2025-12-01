package com.drd.mysticaladaptations.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ModConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    private static final General GENERAL = new General(BUILDER);
    public static final ModConfigSpec spec = BUILDER.build();

    //Mob Drops
    public static ModConfigSpec.ConfigValue<Boolean> witherInsanium;
    public static ModConfigSpec.ConfigValue<Boolean> dragonInsanium;

    public static class General {
        public General(final ModConfigSpec.Builder builder) {
            builder.push("Mob Drops");
            witherInsanium = builder.comment("Wither drops insanium essence when killed with an Insanium weapon.").define("wither_insanium", true);
            dragonInsanium = builder.comment("Ender Dragon drops insanium essence when killed with an Insanium weapon.").define("dragon_insanium", true);
            builder.pop();
        }
    }
}
