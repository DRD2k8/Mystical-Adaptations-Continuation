package com.drd.mysticaladaptations.api;

import com.blakebr0.mysticalagriculture.api.MysticalAgricultureAPI;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class MysticalAdaptationsTags {
    public interface Blocks {
        TagKey<Block> CROPS = BlockTags.create(MysticalAgricultureAPI.resource("crops"));

        TagKey<Block> INCORRECT_FOR_INSANIUM_TOOL = BlockTags.create(MysticalAgricultureAPI.resource("incorrect_for_supremium_tool"));
    }

    public interface Items {
        TagKey<Item> ESSENCES = ItemTags.create(MysticalAgricultureAPI.resource("essences"));
        TagKey<Item> SEEDS = ItemTags.create(MysticalAgricultureAPI.resource("seeds"));

        TagKey<Item> MYSTICAL_ENLIGHTENMENT_ENCHANTABLE = ItemTags.create(MysticalAgricultureAPI.resource("enchantable/mystical_enlightenment"));
        TagKey<Item> SOUL_SIPHONER_ENCHANTABLE = ItemTags.create(MysticalAgricultureAPI.resource("enchantable/soul_siphoner"));
    }
}
