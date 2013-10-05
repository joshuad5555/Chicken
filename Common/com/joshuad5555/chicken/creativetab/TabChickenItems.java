package com.joshuad5555.chicken.creativetab;

import com.joshuad5555.chicken.Chicken;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

public class TabChickenItems extends CreativeTabs {

	public TabChickenItems(int par1, String par2Str) {
		super(par1, par2Str);
		
	}
	
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex() {
		return Chicken.ingotCopper.itemID;
	}
	
	public String getTranslatedTabLabel() {
		return "Chicken's Mod Items";
	}

}
