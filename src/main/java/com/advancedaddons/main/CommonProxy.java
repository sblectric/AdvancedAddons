package com.advancedaddons.main;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.advancedaddons.blocks.AABlocks;
import com.advancedaddons.config.AAConfig;
import com.advancedaddons.crafting.AACraftingManager;
import com.advancedaddons.creativetabs.CreativeTabRenamer;
import com.advancedaddons.events.ArmorHandler;
import com.advancedaddons.events.CustomShieldHandler;
import com.advancedaddons.events.InformationHandler;
import com.advancedaddons.items.AAItems;

/** The common proxy */
public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {
		AAConfig.mainRegistry(event.getSuggestedConfigurationFile());
	}
	
	public void onInit(FMLInitializationEvent event) {
		AABlocks.mainRegistry();
		AAItems.mainRegistry();
	}
	
	public void postInit(FMLPostInitializationEvent event) {
		AACraftingManager.mainRegistry();
		MinecraftForge.EVENT_BUS.register(new ArmorHandler());
		MinecraftForge.EVENT_BUS.register(new CustomShieldHandler());
		MinecraftForge.EVENT_BUS.register(new InformationHandler());
		CreativeTabRenamer.renameASTab();
	}

}
