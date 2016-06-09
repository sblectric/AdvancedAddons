package com.advancedaddons.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import com.advancedswords.creativetabs.ASCreativeTabs;

/** Rename the Advanced Swords creative tab to Advanced Combat */
public class CreativeTabRenamer {
	
	public static void renameASTab() {
		ReflectionHelper.setPrivateValue(CreativeTabs.class, ASCreativeTabs.main, "aaMain", "tabLabel", "field_78034_o");
	}

}
