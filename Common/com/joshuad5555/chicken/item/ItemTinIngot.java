package com.joshuad5555.chicken.item;

import com.joshuad5555.chicken.Chicken;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemTinIngot extends Item {

	public ItemTinIngot(int par1) {
		super(par1);
		this.setUnlocalizedName("ingotTin");
		this.setCreativeTab(Chicken.tabChickenItems);
		
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon(Chicken.modid + ":" + "ingotTin");
	}

}
