package com.drd.mysticaladaptations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.neoforged.api.distmarker.Dist;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ModBus {
    Dist[] value() default { Dist.CLIENT, Dist.DEDICATED_SERVER };
    String modid() default "";
    ModBus.Bus bus() default ModBus.Bus.GAME;
    enum Bus {
        GAME,
        MOD;
    }
}

