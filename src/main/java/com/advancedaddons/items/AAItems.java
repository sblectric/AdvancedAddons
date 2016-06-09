package com.advancedaddons.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.init.Enchantments;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.advancedaddons.blocks.AABlocks;
import com.advancedaddons.config.AAConfig;
import com.advancedaddons.ref.RefStrings;
import com.advancedaddons.registry.IRegistryItem;
import com.advancedswords.blocks.ASBlocks;
import com.advancedswords.creativetabs.ASCreativeTabs;
import com.advancedswords.util.JointList;

/** Advanced Addons items */
public class AAItems {

	private static JointList<IRegistryItem> items;
	public static JointList<ItemUpgrade> upgrades;

	public static void mainRegistry() {
		items = new JointList();
		addMaterials();
		addItems();
		registerItems();
	}
	
	// armor materials
	public static ArmorMaterial wood;
	public static ArmorMaterial stone;
	public static ArmorMaterial nether;
	public static ArmorMaterial obsidian;
	
	/** add the needed materials */
	private static void addMaterials() {
		wood = EnumHelper.addArmorMaterial("Wood Log", RefStrings.MODID + ":wood", 6, new int[]{1, 3, 4, 1}, 5, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0);
		stone = EnumHelper.addArmorMaterial("Stone", RefStrings.MODID + ":stone", 11, new int[]{2, 4, 5, 2}, 8, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0);
		nether = EnumHelper.addArmorMaterial("Nether", RefStrings.MODID + ":nether", 33, new int[]{3, 5, 7, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.5F);
		obsidian = EnumHelper.addArmorMaterial("Obsidian", RefStrings.MODID + ":obsidian", 88, new int[]{3, 6, 8, 4}, 8, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4);
		stone.customCraftingMaterial = Item.getItemFromBlock(ASBlocks.advancedStone);
		nether.customCraftingMaterial = Item.getItemFromBlock(AABlocks.netherFortressBlock);
		obsidian.customCraftingMaterial = Item.getItemFromBlock(AABlocks.reinforcedObsidian);
	}

	// the upgrades
	public static ItemUpgrade protectionUpgrade;
	public static ItemUpgrade fireProtectionUpgrade;
	public static ItemUpgrade blastProtectionUpgrade;
	public static ItemUpgrade projectileProtectionUpgrade;
	public static ItemUpgrade featherFallingUpgrade;
	public static ItemUpgrade respirationUpgrade;
	public static ItemUpgrade aquaAffinityUpgrade;
	public static ItemUpgrade thornsUpgrade;
	public static ItemUpgrade depthStriderUpgrade;
	public static ItemUpgrade frostWalkerUpgrade;
	public static ItemUpgrade efficiencyUpgrade;
	public static ItemUpgrade silkTouchUpgrade;
	public static ItemUpgrade fortuneUpgrade;
	public static ItemUpgrade powerUpgrade;
	public static ItemUpgrade punchUpgrade;
	public static ItemUpgrade flameUpgrade;
	public static ItemUpgrade infinityUpgrade;
	public static ItemUpgrade lotsUpgrade;
	public static ItemUpgrade lureUpgrade;
	
	// items
	public static ItemBowAdvanced advancedBow;
	public static ItemShieldAdvanced advancedShield;
	
	// armor
	public static ItemArmorAdvanced woodenHelm;
	public static ItemArmorAdvanced woodenChest;
	public static ItemArmorAdvanced woodenLegs;
	public static ItemArmorAdvanced woodenBoots;
	
	public static ItemArmorAdvanced stoneHelm;
	public static ItemArmorAdvanced stoneChest;
	public static ItemArmorAdvanced stoneLegs;
	public static ItemArmorAdvanced stoneBoots;
	
	public static ItemArmorAdvanced netherHelm;
	public static ItemArmorAdvanced netherChest;
	public static ItemArmorAdvanced netherLegs;
	public static ItemArmorAdvanced netherBoots;
	
	public static ItemArmorAdvanced obsidianHelm;
	public static ItemArmorAdvanced obsidianChest;
	public static ItemArmorAdvanced obsidianLegs;
	public static ItemArmorAdvanced obsidianBoots;

	/** Add items to the game */
	private static void addItems() {
		
		// add the upgrades
		if(AAConfig.enableEnchantmentUpgrades && AAConfig.enableExtraUpgrades) items.join(
			protectionUpgrade = (ItemUpgrade)new ItemUpgrade(Enchantments.PROTECTION).setUnlocalizedName("protectionUpgrade"),
			fireProtectionUpgrade = (ItemUpgrade)new ItemUpgrade(Enchantments.FIRE_PROTECTION).setUnlocalizedName("fireProtectionUpgrade"),
			blastProtectionUpgrade = (ItemUpgrade)new ItemUpgrade(Enchantments.BLAST_PROTECTION).setUnlocalizedName("blastProtectionUpgrade"),
			projectileProtectionUpgrade = (ItemUpgrade)new ItemUpgrade(Enchantments.PROJECTILE_PROTECTION).setUnlocalizedName("projectileProtectionUpgrade"),
			featherFallingUpgrade = (ItemUpgrade)new ItemUpgrade(Enchantments.FEATHER_FALLING).setUnlocalizedName("featherFallingUpgrade"),
			respirationUpgrade = (ItemUpgrade)new ItemSingleUpgrade(Enchantments.RESPIRATION).setUnlocalizedName("respirationUpgrade"),
			aquaAffinityUpgrade = (ItemUpgrade)new ItemSingleUpgrade(Enchantments.AQUA_AFFINITY).setUnlocalizedName("aquaAffinityUpgrade"),
			thornsUpgrade = (ItemUpgrade)new ItemUpgrade(Enchantments.THORNS).setUnlocalizedName("thornsUpgrade"),
			depthStriderUpgrade = (ItemUpgrade)new ItemSingleUpgrade(Enchantments.DEPTH_STRIDER).setUnlocalizedName("depthStriderUpgrade"),
			frostWalkerUpgrade = (ItemUpgrade)new ItemUpgrade(Enchantments.FROST_WALKER).setUnlocalizedName("frostWalkerUpgrade"),
			efficiencyUpgrade = (ItemUpgrade)new ItemUpgrade(Enchantments.EFFICIENCY).setUnlocalizedName("efficiencyUpgrade"),
			silkTouchUpgrade = (ItemUpgrade)new ItemSingleUpgrade(Enchantments.SILK_TOUCH).setUnlocalizedName("silkTouchUpgrade"),
			fortuneUpgrade = (ItemUpgrade)new ItemUpgrade(Enchantments.FORTUNE).setUnlocalizedName("fortuneUpgrade"),
			powerUpgrade = (ItemUpgrade)new ItemUpgrade(Enchantments.POWER).setUnlocalizedName("powerUpgrade"),
			punchUpgrade = (ItemUpgrade)new ItemUpgrade(Enchantments.PUNCH).setUnlocalizedName("punchUpgrade"),
			flameUpgrade = (ItemUpgrade)new ItemSingleUpgrade(Enchantments.FLAME).setUnlocalizedName("flameUpgrade"),
			infinityUpgrade = (ItemUpgrade)new ItemSingleUpgrade(Enchantments.INFINITY).setUnlocalizedName("infinityUpgrade"),
			lotsUpgrade = (ItemUpgrade)new ItemUpgrade(Enchantments.LUCK_OF_THE_SEA).setUnlocalizedName("lotsUpgrade"),
			lureUpgrade = (ItemUpgrade)new ItemUpgrade(Enchantments.LURE).setUnlocalizedName("lureUpgrade")
		);
		upgrades = new JointList().join(items);
		
		// add the other items
		items.join(
			// tools and such
			advancedBow = (ItemBowAdvanced)new ItemBowAdvanced().setUnlocalizedName("advancedBow"),
			advancedShield = (ItemShieldAdvanced)new ItemShieldAdvanced().setUnlocalizedName("advancedShield"),
			
			// wooden armor
			woodenHelm = (ItemArmorAdvanced)new ItemArmorWood(EntityEquipmentSlot.HEAD).setUnlocalizedName("woodenHelm"),
			woodenChest = (ItemArmorAdvanced)new ItemArmorWood(EntityEquipmentSlot.CHEST).setUnlocalizedName("woodenChest"),
			woodenLegs = (ItemArmorAdvanced)new ItemArmorWood(EntityEquipmentSlot.LEGS).setUnlocalizedName("woodenLegs"),
			woodenBoots = (ItemArmorAdvanced)new ItemArmorWood(EntityEquipmentSlot.FEET).setUnlocalizedName("woodenBoots"),
			
			// stone armor
			stoneHelm = (ItemArmorAdvanced)new ItemArmorStone(EntityEquipmentSlot.HEAD).setUnlocalizedName("stoneHelm"),
			stoneChest = (ItemArmorAdvanced)new ItemArmorStone(EntityEquipmentSlot.CHEST).setUnlocalizedName("stoneChest"),
			stoneLegs = (ItemArmorAdvanced)new ItemArmorStone(EntityEquipmentSlot.LEGS).setUnlocalizedName("stoneLegs"),
			stoneBoots = (ItemArmorAdvanced)new ItemArmorStone(EntityEquipmentSlot.FEET).setUnlocalizedName("stoneBoots"),
			
			// nether fortress armor
			netherHelm = (ItemArmorAdvanced)new ItemArmorNether(EntityEquipmentSlot.HEAD).setUnlocalizedName("netherHelm"),
			netherChest = (ItemArmorAdvanced)new ItemArmorNether(EntityEquipmentSlot.CHEST).setUnlocalizedName("netherChest"),
			netherLegs = (ItemArmorAdvanced)new ItemArmorNether(EntityEquipmentSlot.LEGS).setUnlocalizedName("netherLegs"),
			netherBoots = (ItemArmorAdvanced)new ItemArmorNether(EntityEquipmentSlot.FEET).setUnlocalizedName("netherBoots"),
			
			// obsidian armor
			obsidianHelm = (ItemArmorAdvanced)new ItemArmorObsidian(EntityEquipmentSlot.HEAD).setUnlocalizedName("obsidianHelm"),
			obsidianChest = (ItemArmorAdvanced)new ItemArmorObsidian(EntityEquipmentSlot.CHEST).setUnlocalizedName("obsidianChest"),
			obsidianLegs = (ItemArmorAdvanced)new ItemArmorObsidian(EntityEquipmentSlot.LEGS).setUnlocalizedName("obsidianLegs"),
			obsidianBoots = (ItemArmorAdvanced)new ItemArmorObsidian(EntityEquipmentSlot.FEET).setUnlocalizedName("obsidianBoots")			
		);
		
		if(!AAConfig.enableAdvancedBow) items.remove(advancedBow);
		if(!AAConfig.enableAdvancedShield) items.remove(advancedShield);
		if(!AAConfig.enableWoodenArmor) items.removeAll(new JointList().join(woodenHelm, woodenChest, woodenLegs, woodenBoots));
		if(!AAConfig.enableStoneArmor) items.removeAll(new JointList().join(stoneHelm, stoneChest, stoneLegs, stoneBoots));
		if(!AAConfig.enableNetherArmor) items.removeAll(new JointList().join(netherHelm, netherChest, netherLegs, netherBoots));
		if(!AAConfig.enableObsidianArmor) items.removeAll(new JointList().join(obsidianHelm, obsidianChest, obsidianLegs, obsidianBoots));
	}

	/** Register the items */
	private static void registerItems() {
		// iterate through them
		for(IRegistryItem item : items) {
			((Item)item).setCreativeTab(ASCreativeTabs.main);
			GameRegistry.registerItem((Item)item, item.getShorthandName());
		}
	}

	/** Register the renderers */
	@SideOnly(Side.CLIENT)
	public static void registerRendering() {
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();

		// iterate through them
		for(IRegistryItem item : items) {
			item.registerRender(mesher);
		}
	}

}
