package com.advancedaddons.items;

import net.minecraft.enchantment.Enchantment;

import com.advancedswords.items.ItemEnchantmentUpgrade;

/** Enchantment upgrade with only a tier 1 version */
public class ItemSingleUpgrade extends ItemUpgrade {
	
	public ItemSingleUpgrade(Enchantment enchant) {
		super(enchant, true);
	}

}
