package com.advancedaddons.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

/** Wooden armor class */
public class ItemArmorWood extends ItemArmorAdvanced {

	public ItemArmorWood(EntityEquipmentSlot armorType) {
		super(AAItems.wood, armorType);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(TextFormatting.RED + "Flammable");
		tooltip.add(TextFormatting.GREEN + "Ecological II");
	}

	// Repairable with any log
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		List<ItemStack> ores = OreDictionary.getOres("logWood");
		return OreDictionary.containsMatch(false, ores, repair);
	}
	
	// flammability and ecological functionality
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
		if(!world.isRemote) {
			
			// flammability: 5 damage to the armor per second
			if(player.isBurning() && player.ticksExisted % 4 == 0) {
				armor.damageItem(1, player);
			}
			
			// ecological II: repair 1 damage per second when wet
			// repair 1 damage per 12 seconds when not wet
			if(armor.getItemDamage() > 0) {
				if((player.isWet() && player.ticksExisted % 20 == 0) || player.ticksExisted % 240 == 0) {
					armor.damageItem(-1, player);
				}
			}
		}
	}

}
