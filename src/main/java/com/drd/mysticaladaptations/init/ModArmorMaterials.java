package com.drd.mysticaladaptations.init;

import com.drd.mysticaladaptations.MysticalAdaptations;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

public final class ModArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> REGISTRY = DeferredRegister.create(Registries.ARMOR_MATERIAL, MysticalAdaptations.MOD_ID);

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> INSANIUM = REGISTRY.register("supremium", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 8);
                map.put(ArmorItem.Type.LEGGINGS, 12);
                map.put(ArmorItem.Type.CHESTPLATE, 14);
                map.put(ArmorItem.Type.HELMET, 10);
            }),
            20, SoundEvents.ARMOR_EQUIP_GOLD,
            () -> Ingredient.of(com.blakebr0.mysticalagradditions.init.ModItems.INSANIUM_INGOT.get()),
            List.of(
                    new ArmorMaterial.Layer(MysticalAdaptations.resource("insanium"), "", false)
            ),
            3.0F, 0.0F
    ));
}
