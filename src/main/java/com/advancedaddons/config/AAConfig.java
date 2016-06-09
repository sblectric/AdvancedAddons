package com.advancedaddons.config;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import net.minecraftforge.common.config.Configuration;

import com.advancedswords.config.ASConfig;

/** The mod configuration */
public class AAConfig extends ASConfig {

	// config file
	private static Configuration config;

	public static void mainRegistry(File f) {
		config = new Configuration(f);
		getConfig();
	}

	public static boolean durabilityTooltips;
	public static List<String> tooltipModBL;
	public static boolean enableExtraUpgrades;
	public static boolean enableAdvancedBow;
	public static boolean enableAdvancedShield;
	public static boolean enableWoodenArmor;
	public static boolean enableStoneArmor;
	public static boolean enableNetherArmor;
	public static boolean enableObsidianArmor;
	public static boolean enableTrackingDispenser;
	public static int trackingDispenserRange;

	/** Do it up */
	private static void getConfig() {
		final String OPTIONS = config.CATEGORY_GENERAL;
		config.load();

		durabilityTooltips = config.getBoolean("Better Durability Tooltips", OPTIONS, true,
				"Always show the durability of an item in its tooltip (regular or advanced tooltip mode), and in a more aesthetic manner than vanilla.");
		tooltipModBL = Arrays.asList(config.getStringList("Tooltip Mod Blacklist", OPTIONS, new String[]{"tconstruct"}, 
				"Mods (by mod ID) that should not show better durability on their items."));
		enableExtraUpgrades = config.getBoolean("Enable Extra Upgrades", OPTIONS, true, 
				"Note: Extra upgrades only work when enchantment upgrades are enabled in the Advanced Swords config file.");
		enableAdvancedBow = config.getBoolean("Advanced Bow", OPTIONS, true, "");
		enableAdvancedShield = config.getBoolean("Advanced Shield", OPTIONS, true, "");
		enableWoodenArmor = config.getBoolean("Wooden Armor", OPTIONS, true, "");
		enableStoneArmor = config.getBoolean("Stone Armor", OPTIONS, true, "");
		enableNetherArmor = config.getBoolean("Nether Fortress Armor", OPTIONS, true, "");
		enableObsidianArmor = config.getBoolean("Obsidian Armor", OPTIONS, true, "");
		enableTrackingDispenser = config.getBoolean("Tracking Dispenser", OPTIONS, true, "");
		trackingDispenserRange = config.getInt("Tracking Dispenser Range", OPTIONS, 32, 8, 128, "");

		if(config.hasChanged()) config.save();
	}

}
