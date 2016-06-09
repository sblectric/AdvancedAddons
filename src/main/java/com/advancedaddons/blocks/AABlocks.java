package com.advancedaddons.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.advancedaddons.config.AAConfig;
import com.advancedaddons.registry.IRegistryBlock;
import com.advancedaddons.registry.IRegistryItem;
import com.advancedswords.creativetabs.ASCreativeTabs;
import com.advancedswords.util.JointList;

/** Mod blocks */
public class AABlocks {
	
	private static JointList<IRegistryBlock> blocks;

	public static void mainRegistry() {
		blocks = new JointList();
		addBlocks();
		registerBlocks();
	}

	// the blocks
	public static BlockAdvanced netherFortressBlock;
	public static BlockAdvanced reinforcedObsidian;
	public static BlockTrackingDispenser trackingDispenser;

	/** Add items to the game */
	private static void addBlocks() {
		blocks.join(
			netherFortressBlock = (BlockAdvanced)new BlockAdvanced(5, 50).setUnlocalizedName("netherFortressBlock"),
			reinforcedObsidian = (BlockAdvanced)new BlockAdvanced(50, 15000).setUnlocalizedName("reinforcedObsidian"),
			trackingDispenser = (BlockTrackingDispenser)new BlockTrackingDispenser().setUnlocalizedName("trackingDispenser")
		);
		if(!AAConfig.enableTrackingDispenser) blocks.remove(trackingDispenser);
	}

	/** Register the items */
	private static void registerBlocks() {
		// iterate through them
		for(IRegistryBlock block : blocks) {
			((Block)block).setCreativeTab(ASCreativeTabs.main);
			GameRegistry.registerBlock((Block)block, block.getShorthandName());
		}
	}

	/** Register the renderers */
	@SideOnly(Side.CLIENT)
	public static void registerRendering() {
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();

		// iterate through them
		for(IRegistryBlock block : blocks) {
			block.registerRender(mesher);
		}
	}

}
