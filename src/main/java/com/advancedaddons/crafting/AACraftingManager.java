package com.advancedaddons.crafting;

import java.util.Iterator;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;

import com.advancedaddons.blocks.AABlocks;
import com.advancedaddons.config.AAConfig;
import com.advancedaddons.items.AAItems;
import com.advancedaddons.items.ItemSingleUpgrade;
import com.advancedaddons.ref.RefStrings;
import com.advancedswords.blocks.ASBlocks;
import com.advancedswords.crafting.ASCraftingManager;
import com.advancedswords.crafting.RecipeEnchantmentUpgrade;
import com.advancedswords.crafting.RecipeHelper;
import com.advancedswords.items.ItemEnchantmentUpgrade;
import com.advancedswords.util.JointList;
import com.advancedswords.util.StackHelper;

/** Crafting recipes and such */
public class AACraftingManager extends ASCraftingManager {
	
	public static void mainRegistry() {
		addCraftingRecipes();
	}
	
	/** Add the crafting recipes */
	private static void addCraftingRecipes() {
		
		// advanced nether brick
		RecipeHelper.addShapedOreRecipe(new ItemStack(AABlocks.netherFortressBlock), "IXI","XIX","IXI", 'X',Blocks.IRON_BARS, 'I',Blocks.NETHER_BRICK);
		RecipeHelper.addShapedOreRecipe(new ItemStack(AABlocks.reinforcedObsidian), "IXI","XIX","IXI", 'X',ASBlocks.advancedStone, 'I',Blocks.OBSIDIAN);
		
		// advanced bow
		if(AAConfig.enableAdvancedBow) RecipeHelper.addShapedOreRecipe(new ItemStack(AAItems.advancedBow), "XIX","XAX","XIX", 
				'X',"logWood", 'I',"blockIron", 'A',Items.BOW);
		
		// advanced shield
		if(AAConfig.enableAdvancedShield) RecipeHelper.addShapedOreRecipe(new ItemStack(AAItems.advancedShield), "XIX","XAX","XIX", 
				'X',"logWood", 'I',"blockIron", 'A',Items.SHIELD);
		
		// tracking dispenser
		if(AAConfig.enableTrackingDispenser) RecipeHelper.addShapedOreRecipe(new ItemStack(AABlocks.trackingDispenser), "XCX","RAR","XBX", 
				'X',Blocks.TRIPWIRE_HOOK, 'C',Items.COMPARATOR, 'R',"dustRedstone", 'B',"blockRedstone", 'A',Blocks.DISPENSER);
		
		// wooden armor
		if(AAConfig.enableWoodenArmor) {
			RecipeHelper.addShapedOreRecipe(new ItemStack(AAItems.woodenHelm), "XXX","X X", 'X',"logWood");
			RecipeHelper.addShapedOreRecipe(new ItemStack(AAItems.woodenChest), "X X","XXX","XXX", 'X',"logWood");
			RecipeHelper.addShapedOreRecipe(new ItemStack(AAItems.woodenLegs), "XXX","X X","X X", 'X',"logWood");
			RecipeHelper.addShapedOreRecipe(new ItemStack(AAItems.woodenBoots), "X X","X X", 'X',"logWood");
		}
		
		// stone armor
		if(AAConfig.enableStoneArmor) {
			RecipeHelper.addShapedOreRecipe(new ItemStack(AAItems.stoneHelm), "AXA","X X", 'X',"stone", 'A',ASBlocks.advancedStone);
			RecipeHelper.addShapedOreRecipe(new ItemStack(AAItems.stoneChest), "X X","XAX","XAX", 'X',"stone", 'A',ASBlocks.advancedStone);
			RecipeHelper.addShapedOreRecipe(new ItemStack(AAItems.stoneLegs), "AXA","X X","X X", 'X',"stone", 'A',ASBlocks.advancedStone);
			RecipeHelper.addShapedOreRecipe(new ItemStack(AAItems.stoneBoots), "A A","X X", 'X',"stone", 'A',ASBlocks.advancedStone);
		}
		
		// nether fortress armor
		if(AAConfig.enableNetherArmor) {
			RecipeHelper.addShapedOreRecipe(new ItemStack(AAItems.netherHelm),
					"AXA","F F", 'X',Blocks.NETHER_BRICK, 'A',AABlocks.netherFortressBlock, 'F',Blocks.NETHER_BRICK_FENCE);
			RecipeHelper.addShapedOreRecipe(new ItemStack(AAItems.netherChest),
					"F F","XAX","XAX", 'X',Blocks.NETHER_BRICK, 'A',AABlocks.netherFortressBlock, 'F',Blocks.NETHER_BRICK_FENCE);
			RecipeHelper.addShapedOreRecipe(new ItemStack(AAItems.netherLegs), "AXA","X X","F F", 
					'X',Blocks.NETHER_BRICK, 'A',AABlocks.netherFortressBlock, 'F',Blocks.NETHER_BRICK_FENCE);
			RecipeHelper.addShapedOreRecipe(new ItemStack(AAItems.netherBoots), "A A","F F", 
					'A',AABlocks.netherFortressBlock, 'F',Blocks.NETHER_BRICK_FENCE);
		}
		
		// obsidian armor
		if(AAConfig.enableObsidianArmor) {
			RecipeHelper.addShapedOreRecipe(new ItemStack(AAItems.obsidianHelm), "AXA","X X", 'X',Blocks.OBSIDIAN, 'A',AABlocks.reinforcedObsidian);
			RecipeHelper.addShapedOreRecipe(new ItemStack(AAItems.obsidianChest), "X X","XAX","XAX", 'X',Blocks.OBSIDIAN, 'A',AABlocks.reinforcedObsidian);
			RecipeHelper.addShapedOreRecipe(new ItemStack(AAItems.obsidianLegs), "AXA","X X","X X", 'X',Blocks.OBSIDIAN, 'A',AABlocks.reinforcedObsidian);
			RecipeHelper.addShapedOreRecipe(new ItemStack(AAItems.obsidianBoots), "A A","X X", 'X',Blocks.OBSIDIAN, 'A',AABlocks.reinforcedObsidian);
		}
		
		// enchantment upgrades
		if(AAConfig.enableEnchantmentUpgrades && AAConfig.enableExtraUpgrades) {
			
			// Tier 1
			addTier1Recipe(AAItems.protectionUpgrade, 
					"IXI","XAX","IXI", 'X',Items.LEATHER_CHESTPLATE, 'A',Items.SHIELD);
			addTier1Recipe(AAItems.fireProtectionUpgrade, 
					"IXI","XAX","IXI", 'X',Items.NETHERBRICK, 'A',Items.FLINT_AND_STEEL);
			addTier1Recipe(AAItems.blastProtectionUpgrade, 
					"IXI","XAX","IXI", 'X',Blocks.OBSIDIAN, 'A',Blocks.TNT);
			addTier1Recipe(AAItems.projectileProtectionUpgrade, 
					"IXI","XAX","IXI", 'X',Items.ARROW, 'A',Items.BOW);
			addTier1Recipe(AAItems.featherFallingUpgrade, 
					"IXI","XAX","IXI", 'X',Items.FEATHER, 'A',Blocks.HAY_BLOCK);
			addTier1Recipe(AAItems.respirationUpgrade, 
					"IXI","XAX","IXI", 'X',new ItemStack(Items.FISH, 1, 3), 'A',Items.GLASS_BOTTLE);
			addTier1Recipe(AAItems.aquaAffinityUpgrade, 
					"IXI","XAX","IXI", 'X',new ItemStack(Items.FISH, 1, 3), 'A',Items.IRON_PICKAXE);
			addTier1Recipe(AAItems.thornsUpgrade, 
					"IXI","XAX","IXI", 'X',Blocks.CACTUS, 'A',Items.FLINT);
			addTier1Recipe(AAItems.depthStriderUpgrade, 
					"IXI","XAX","IXI", 'X',Items.LEATHER_BOOTS, 'A',Items.WATER_BUCKET);
			addTier1Recipe(AAItems.frostWalkerUpgrade, 
					"IXI","XAX","IXI", 'X',Items.GOLDEN_BOOTS, 'A',Blocks.ICE);
			addTier1Recipe(AAItems.efficiencyUpgrade, 
					"IXI","XAX","IXI", 'X',"dustRedstone", 'A',Items.DIAMOND_PICKAXE);
			addTier1Recipe(AAItems.silkTouchUpgrade, 
					"IXI","XAX","IXI", 'X',Items.STRING, 'A',Items.GOLDEN_PICKAXE);
			addTier1Recipe(AAItems.fortuneUpgrade, 
					"IXI","XAX","IXI", 'X',"gemDiamond", 'A',"blockGold");
			addTier1Recipe(AAItems.powerUpgrade, 
					"IXI","XAX","IXI", 'X',Items.ARROW, 'A',Items.FLINT);
			addTier1Recipe(AAItems.punchUpgrade, 
					"IXI","XAX","IXI", 'X',Items.ARROW, 'A',Blocks.PISTON);
			addTier1Recipe(AAItems.flameUpgrade, 
					"IXI","XAX","IXI", 'X',Items.BLAZE_ROD, 'A',"blockCoal");
			addTier1Recipe(AAItems.infinityUpgrade, 
					"IXI","XAX","IXI", 'X',Items.BOW, 'A',Items.GOLDEN_APPLE);
			addTier1Recipe(AAItems.lotsUpgrade, 
					"IXI","XAX","IXI", 'X',Items.FISHING_ROD, 'A',Items.RABBIT_FOOT);
			addTier1Recipe(AAItems.lureUpgrade, 
					"IXI","XAX","IXI", 'X',Items.FISHING_ROD, 'A',new ItemStack(Items.FISH, 1, OreDictionary.WILDCARD_VALUE));
			
			// Tier 2
			addTier2Recipe(AAItems.protectionUpgrade, 
					"IXI","XAX","IXI", 'X',Items.DIAMOND_CHESTPLATE, 'I',Blocks.OBSIDIAN);
			addTier2Recipe(AAItems.fireProtectionUpgrade, 
					"IXI","XAX","IXI", 'X',Items.FIRE_CHARGE, 'I',Blocks.OBSIDIAN);
			addTier2Recipe(AAItems.blastProtectionUpgrade, 
					"IXI","XAX","IXI", 'X',Blocks.TNT, 'I',new ItemStack(Items.SKULL, 1, 4));
			addTier2Recipe(AAItems.projectileProtectionUpgrade, 
					"IXI","XAX","IXI", 'X',Items.BOW, 'I',Blocks.OBSIDIAN);
			addTier2Recipe(AAItems.featherFallingUpgrade, 
					"IXI","XAX","IXI", 'X',Blocks.HAY_BLOCK, 'I',Items.BED);
			addTier2Recipe(AAItems.thornsUpgrade, 
					"IXI","XAX","IXI", 'X',Blocks.IRON_BARS, 'I',Blocks.CACTUS);
			addTier2Recipe(AAItems.frostWalkerUpgrade, 
					"IXI","XAX","IXI", 'X',Items.DIAMOND_BOOTS, 'I',Blocks.PACKED_ICE);
			addTier2Recipe(AAItems.efficiencyUpgrade, 
					"IXI","XAX","IXI", 'X',"blockRedstone", 'I',"blockDiamond");
			addTier2Recipe(AAItems.fortuneUpgrade, 
					"IXI","XAX","IXI", 'X',"blockGold", 'I',"blockDiamond");
			addTier2Recipe(AAItems.powerUpgrade, 
					"IXI","XAX","IXI", 'X',Items.ARROW, 'I',"blockIron");
			addTier2Recipe(AAItems.punchUpgrade, 
					"IXI","XAX","IXI", 'X',Blocks.PISTON, 'I',"blockSlime");
			addTier2Recipe(AAItems.lotsUpgrade, 
					"IXI","XAX","IXI", 'X',Items.RABBIT_FOOT, 'I',"gemEmerald");
			addTier2Recipe(AAItems.lureUpgrade, 
					"IXI","XAX","IXI", 'X',new ItemStack(Items.FISH, 1, OreDictionary.WILDCARD_VALUE), 'I',Items.POISONOUS_POTATO);
			
			// remove all existing recipes and replace them with flexible versions
			RecipeSorter.register(RefStrings.MODID + ":FlexibleUpgrade", RecipeFlexibleUpgrade.class, Category.SHAPELESS, "after:minecraft:shapeless");
			JointList<Item> items = new JointList();
			Iterator<RecipeEnchantmentUpgrade> i = RecipeEnchantmentUpgrade.getAllUpgrades().iterator();
			while(i.hasNext()) {
				RecipeEnchantmentUpgrade next = i.next();
				items.add(next.getUpgrade().getItem());
				i.remove();
			}
			for(Item m : items) {
				addFlexibleUpgradeRecipe(m);
			}
			
			// add all of the new recipe types
			for(Item upgrade : AAItems.upgrades) addFlexibleUpgradeRecipe(upgrade);
			
		}
	}
	
	/** Adds a tier 1 recipe with 'I' set to paper */
	private static void addTier1Recipe(Item result, Object... recipe) {
		JointList rec = new JointList().join(recipe).join('I', Items.PAPER);
		RecipeHelper.addShapedOreRecipe(new ItemStack(result, 1, TIER_1), rec.toArray(new Object[recipe.length]));
	}
	
	/** Adds a tier 2 recipe with 'A' set to the tier 1 result */
	private static void addTier2Recipe(Item result, Object... recipe) {
		JointList rec = new JointList().join(recipe).join('A', new ItemStack(result, 1, TIER_1));
		RecipeHelper.addShapedOreRecipe(new ItemStack(result, 1, TIER_2), rec.toArray(new Object[recipe.length]));
	}
	
	/** Registers the tier 1 and tier 2 enchantment upgrade recipes for the specified item */
	private static void addFlexibleUpgradeRecipe(Item upgrade) {
		for(int i = 0; i < (((ItemEnchantmentUpgrade)upgrade).getEnchantment().getMaxLevel() == 1 || 
				upgrade instanceof ItemSingleUpgrade ? 1 : ItemEnchantmentUpgrade.TIER_COUNT); i++) {
			GameRegistry.addRecipe(new RecipeFlexibleUpgrade(new ItemStack(upgrade, 1, i)));
		}
	}

}
