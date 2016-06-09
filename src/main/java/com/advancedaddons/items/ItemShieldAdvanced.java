package com.advancedaddons.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import com.advancedaddons.registry.IRegistryItem;
import com.advancedswords.creativetabs.ASCreativeTabs;

/** Still glitchy, but it works */
public class ItemShieldAdvanced extends ItemShield implements IRegistryItem {
	
	public ItemShieldAdvanced() {
		super();
		this.setMaxDamage(1536);
	}
	
	// damage it
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		stack.damageItem(1, entityLiving);
		return stack;
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		return "Advanced " + super.getItemStackDisplayName(stack);
	}
	
    @SideOnly(Side.CLIENT)
    @Override
    public CreativeTabs getCreativeTab() {
        return ASCreativeTabs.main;
    }
	
	@Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Item.getItemFromBlock(Blocks.IRON_BLOCK);
    }

}
