package com.joshuad5555.chicken.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

import com.joshuad5555.chicken.Chicken;
import com.joshuad5555.chicken.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSilverOre extends Block {

	public BlockSilverOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setUnlocalizedName("oreSilver");
		this.setCreativeTab(Chicken.tabChickenBlocks);
		this.setStepSound(soundStoneFootstep);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		this.blockIcon = ir.registerIcon(Chicken.modid + ":" + "oreSilver");
	}

}
