package com.advancedaddons.items;

import java.util.List;

import com.advancedswords.blocks.ASBlocks;

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

/** Stone armor class */
public class ItemArmorStone extends ItemArmorAdvanced {

	public ItemArmorStone(EntityEquipmentSlot armorType) {
		super(AAItems.stone, armorType);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(TextFormatting.GREEN + "Ecological I");
	}

	// ecological functionality
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
		if(!world.isRemote) {

			// ecological I: repair 1 damage per 5 seconds when wet
			// repair 1 damage per 60 seconds when not wet
			if(armor.getItemDamage() > 0) {
				if((player.isWet() && player.ticksExisted % 100 == 0) || player.ticksExisted % 1200 == 0) {
					armor.damageItem(-1, player);
				}
			}
			
		}
	}

}
