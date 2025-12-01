package com.drd.mysticaladaptations.api.crop;

import com.blakebr0.mysticalagriculture.api.crop.CropTier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class ModCropTier extends CropTier {
    public static final ModCropTier SIX;

    private final ResourceLocation id;
    private final int value;
    private final int color;
    private final ChatFormatting textColor;
    private Supplier<? extends Block> farmland;
    private Supplier<? extends Item> essence;
    private MutableComponent displayName;
    private boolean fertilizable;
    private boolean secondarySeedDrop;
    private double baseSecondaryChance;

    public ModCropTier(ResourceLocation id, int value, int color, ChatFormatting textColor) {
        super(id, value, color, textColor);
        this.id = id;
        this.value = value;
        this.color = color;
        this.textColor = textColor;
        this.fertilizable = true;
        this.secondarySeedDrop = true;
        this.baseSecondaryChance = 0.1;
    }

    static {
        SIX = new ModCropTier(ResourceLocation.fromNamespaceAndPath("mysticalagradditions", "6"), 6, 6619291, ChatFormatting.DARK_PURPLE);
    }

    public int getValue() {
        return this.value;
    }
}
