package com.drd.mysticaladaptations.item;

import com.blakebr0.cucumber.lib.Tooltips;
import com.blakebr0.cucumber.util.Formatting;
import com.blakebr0.mysticalagriculture.api.machine.MachineUpgradeTier;
import com.blakebr0.mysticalagriculture.item.MachineUpgradeItem;
import com.blakebr0.mysticalagriculture.lib.ModTooltips;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class InsaniumUpgradeItem extends MachineUpgradeItem {
    public InsaniumUpgradeItem() {
        super(MachineUpgradeTier.AWAKENED_SUPREMIUM);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context,
                                List<Component> tooltip, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            MutableComponent speed = Formatting.number(200.0).withStyle(ChatFormatting.DARK_PURPLE);
            MutableComponent fuelRate = Formatting.number(96.0).withStyle(ChatFormatting.DARK_PURPLE);
            MutableComponent fuelCapacity = Formatting.number(7.0).withStyle(ChatFormatting.DARK_PURPLE);
            MutableComponent area = Formatting.number(6).withStyle(ChatFormatting.DARK_PURPLE);

            tooltip.add(ModTooltips.UPGRADE_SPEED.args(speed).build());
            tooltip.add(ModTooltips.UPGRADE_FUEL_RATE.args(fuelRate).build());
            tooltip.add(ModTooltips.UPGRADE_FUEL_CAPACITY.args(fuelCapacity).build());
            tooltip.add(ModTooltips.UPGRADE_AREA.args(area).build());
        } else {
            tooltip.add(Tooltips.HOLD_SHIFT_FOR_INFO.build());
        }
    }
}
