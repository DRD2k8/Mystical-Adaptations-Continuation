package com.drd.mysticaladaptations.handlers;

import com.blakebr0.mysticalagriculture.MysticalAgriculture;
import com.blakebr0.mysticalagriculture.api.crop.CropTier;
import com.blakebr0.mysticalagriculture.lib.ModTooltips;
import com.drd.mysticaladaptations.MysticalAdaptations;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

public class TooltipHandlers {
    @SubscribeEvent
    public void tooltipEvent(ItemTooltipEvent event){
        ResourceLocation rl = BuiltInRegistries.ITEM.getKey(event.getItemStack().getItem());
        if(rl == null) return;
        String modid = rl.getNamespace();

        if(modid.equals(MysticalAdaptations.MOD_ID) || modid.equals(MysticalAgriculture.MOD_ID)) {
            int index = -1;
            for(Component text : event.getToolTip()){
                if(text.equals(ModTooltips.getTooltipForTier(6))){
                    index = event.getToolTip().indexOf(text);
                }
            }
            if(index != -1){
                event.getToolTip().set(index, Component.literal(ChatFormatting.GRAY + String.format(Component.translatable("tooltip.mysticalagriculture.tier").getString(), getColorFromTier(6) + "6")));
            }
        }
    }

    public static ChatFormatting getColorFromTier(int tier) {
        return switch (tier) {
            case 1 -> CropTier.ONE.getTextColor();
            case 2 -> CropTier.TWO.getTextColor();
            case 3 -> CropTier.THREE.getTextColor();
            case 4 -> CropTier.FOUR.getTextColor();
            case 5 -> CropTier.FIVE.getTextColor();
            case 6 -> ChatFormatting.DARK_PURPLE;
            default -> ChatFormatting.GRAY;
        };
    }
}
