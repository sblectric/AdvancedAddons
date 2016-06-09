package com.advancedaddons.items;

import java.util.List;

import com.advancedswords.blocks.ASBlocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemArmorNether extends ItemArmorAdvanced {

	public ItemArmorNether(EntityEquipmentSlot armorType) {
		super(AAItems.nether, armorType);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(TextFormatting.GOLD + "Brick Wall");
		tooltip.add(TextFormatting.BLUE + "Blastproof I");
	}

}
