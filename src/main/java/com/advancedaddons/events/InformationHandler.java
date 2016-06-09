package com.advancedaddons.events;

import java.util.Iterator;
import java.util.List;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.advancedaddons.config.AAConfig;

/** Displays useful information in various ways */
public class InformationHandler {

	/** Show item damages in their tooltips */
	@SubscribeEvent
	public void onTooltipShow(ItemTooltipEvent e) {
		if(AAConfig.durabilityTooltips && e.getItemStack() != null && e.getItemStack().getItem().isDamageable()) {
			String modid = e.getItemStack().getItem().getRegistryName().getResourceDomain();
			if(!AAConfig.tooltipModBL.contains(modid)) {
				int maxDamage = e.getItemStack().getMaxDamage();
				int currentDamage = e.getItemStack().getItemDamage();
				List<String> t = e.getToolTip();
				if(e.isShowAdvancedItemTooltips() && currentDamage > 0) { // remove the vanilla indicator
					Iterator<String> it = t.iterator();
					while(it.hasNext()) {
						String str = it.next();
						if(str.contains("Durability")) it.remove();
					}
				}
				t.add(1, TextFormatting.DARK_GRAY + "Durability: " + (maxDamage - currentDamage) + " / " + maxDamage);
			}
		}
	}

}
