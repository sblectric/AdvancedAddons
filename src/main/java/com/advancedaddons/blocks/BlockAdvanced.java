package com.advancedaddons.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.advancedaddons.ref.RefStrings;
import com.advancedaddons.registry.IRegistryBlock;
import com.advancedswords.blocks.BlockBasic;

public class BlockAdvanced extends BlockBasic implements IRegistryBlock {

	public BlockAdvanced(float hardness, float resistance) {
		super(Material.ROCK, hardness, resistance);
	}
	
	@Override
	public String getShorthandName() {
		return ((Block)this).getUnlocalizedName().substring(5);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerRender(ItemModelMesher mesher) {
		mesher.register(Item.getItemFromBlock((Block)this), 0, new ModelResourceLocation(RefStrings.MODID + ":" + this.getShorthandName(), "inventory"));
	}

}
