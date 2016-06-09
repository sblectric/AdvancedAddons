package com.advancedaddons.items;

import java.util.List;

import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.advancedaddons.ref.RefStrings;
import com.advancedaddons.registry.IRegistryItem;
import com.advancedswords.items.ItemEnchantmentUpgrade;
import com.advancedswords.util.JointList;

/** Upgrade with the right texture paths */
public class ItemUpgrade extends ItemEnchantmentUpgrade implements IRegistryItem {
	
	public ItemUpgrade(Enchantment enchant) {
		super(enchant);
	}

	public ItemUpgrade(Enchantment enchant, boolean single) {
		super(enchant, single);
	}
	
	/** To put into vanilla Advanced Swords [eventually] */
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		String ench = I18n.translateToLocal(this.enchant.getName());
		return (stack.getItemDamage() > 0 ? "Elite " + ench : ench) + " Upgrade";
	}
	
	/** To put into vanilla Advanced Swords [eventually] */
	@SideOnly(Side.CLIENT)
	@Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		int tier = stack.getItemDamage();
		tooltip.add("Upgrades to " + I18n.translateToLocal(enchant.getName()));
		if(enchant.getMaxLevel() > 1) {
			tooltip.add("Tiers " + (tier * enchant.getMaxLevel() + 1) + " - " + (tier + 1) * enchant.getMaxLevel());
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerRender(ItemModelMesher mesher) {
		JointList<ResourceLocation> names = new JointList();
		if(sameIcon) {
			for(int meta = 0; meta < nSubItems; meta++) {
				names.join(new ResourceLocation(RefStrings.MODID + ":" + this.getShorthandName()));
			}
			ModelBakery.registerItemVariants(this, names.toArray(new ResourceLocation[names.size()]));
			for(int meta = 0; meta < nSubItems; meta++) {
				mesher.register(this, meta, new ModelResourceLocation(RefStrings.MODID + ":" + this.getShorthandName(), "inventory"));
			}
		} else {
			for(int meta = 0; meta < nSubItems; meta++) {
				names.join(new ResourceLocation(RefStrings.MODID + ":" + this.getShorthandName() + "_" + meta));
			}
			ModelBakery.registerItemVariants(this, names.toArray(new ResourceLocation[names.size()]));
			for(int meta = 0; meta < nSubItems; meta++) {
				mesher.register(this, meta, new ModelResourceLocation(RefStrings.MODID + ":" + this.getShorthandName() + "_" + meta, "inventory"));
			}
		}
	}
	
}
