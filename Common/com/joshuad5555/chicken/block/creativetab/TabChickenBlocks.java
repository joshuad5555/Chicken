package com.joshuad5555.chicken.creativetab;

import com.joshuad5555.chicken.Chicken;
import com.joshuad5555.chicken.lib.Reference;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabChickenBlocks extends CreativeTabs {

	public TabChickenBlocks(int par1, String par2Str) {
		super(par1, par2Str);
	}
	
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex() {
		return Chicken.oreCopper.blockID;
	}
	
	public String getTranslatedTabLabel() {
		return "Chicken's Mod Blocks";
	}

}
