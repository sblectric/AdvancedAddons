package com.advancedaddons.items;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

import com.advancedaddons.registry.IRegistryItem;

/** Superclass for armors */
public abstract class ItemArmorAdvanced extends ItemArmor implements IRegistryItem {
	
	public ItemArmorAdvanced(ArmorMaterial mat, EntityEquipmentSlot armorType) {
		super(mat, mat.ordinal(), armorType);
	}

}
