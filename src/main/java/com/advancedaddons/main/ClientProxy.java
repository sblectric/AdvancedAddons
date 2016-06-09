package com.advancedaddons.main;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.advancedaddons.blocks.AABlocks;
import com.advancedaddons.items.AAItems;

/** The client proxy */
public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}
	
	@Override
	public void onInit(FMLInitializationEvent event) {
		super.onInit(event);
		AABlocks.registerRendering();
		AAItems.registerRendering();
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}

}
