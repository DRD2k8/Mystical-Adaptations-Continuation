package com.drd.mysticaladaptations.api.crop;

import com.blakebr0.mysticalagriculture.api.crop.CropTier;
import net.minecraft.ChatFormatting;
import net.minecraft.resources.ResourceLocation;

public class ModCropTier {
    public static final CropTier SIX;

    static {
        SIX = new CropTier(ResourceLocation.fromNamespaceAndPath("mysticalagradditions", "6"), 6, 6619291, ChatFormatting.DARK_PURPLE);
    }
}
