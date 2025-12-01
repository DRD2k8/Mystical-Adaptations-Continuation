package com.drd.mysticaladaptations.compat.vampirism;

import de.teamlapen.vampirism.api.entity.player.vampire.IDrinkBloodContext;
import de.teamlapen.vampirism.core.ModEffects;
import de.teamlapen.vampirism.entity.player.vampire.VampirePlayer;
import de.teamlapen.vampirism.entity.vampire.DrinkBloodContext;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.Optional;

public class CompatVampirism {
    public static void fillThirst(Player player, Level world) {
        if(!world.isClientSide) {
            IDrinkBloodContext ctx = DrinkBloodContext.none();
            Optional<VampirePlayer> optVampire = VampirePlayer.getOpt(player);
            optVampire.ifPresent(vampire -> vampire.drinkBlood(vampire.getBloodStats().getMaxBlood(), 0, ctx));
        }
    }

    public static void applySunscreen(Player player, Level world) {
        MobEffectInstance effect = new MobEffectInstance((Holder<MobEffect>) ModEffects.SUNSCREEN.get(), 20, 5, false, false);
        player.addEffect(effect);
    }
}
