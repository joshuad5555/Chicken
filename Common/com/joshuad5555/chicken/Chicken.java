package com.joshuad5555.chicken;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

import com.joshuad5555.chicken.block.BlockCopperOre;
import com.joshuad5555.chicken.block.BlockSilverOre;
import com.joshuad5555.chicken.block.BlockTinOre;
import com.joshuad5555.chicken.creativetab.TabChickenBlocks;
import com.joshuad5555.chicken.creativetab.TabChickenItems;
import com.joshuad5555.chicken.item.ItemCopperIngot;
import com.joshuad5555.chicken.item.ItemSilverIngot;
import com.joshuad5555.chicken.item.ItemTinIngot;
import com.joshuad5555.chicken.lib.Reference;
import com.joshuad5555.chicken.proxy.CommonProxy;
import com.joshuad5555.chicken.worldgenerator.WorldGeneratorCopperOre;
import com.joshuad5555.chicken.worldgenerator.WorldGeneratorSilverOre;
import com.joshuad5555.chicken.worldgenerator.WorldGeneratorTinOre;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Chicken's Mod
 * 
 * Main mod class for the Minecraft Mod Chicken's Mod
 * 
 * @author ChickenLover
 *
 */

@Mod(modid = Chicken.modid, name = "Chicken's Mod", version = "0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class Chicken {
	
	public static final String modid = "joshuad5555_Chicken";
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_PATH, serverSide = Reference.COMMON_PROXY_PATH)
	public static CommonProxy proxy;

	//Creative Tabs
	public static CreativeTabs tabChickenBlocks;
	public static CreativeTabs tabChickenItems;
	
	//Block Ids
	public static int oreCopperID;
	public static int oreTinID;
	public static int oreSilverID;
	
	//Item Ids
	public static int ingotCopperID;
	public static int ingotTinID;
	public static int ingotSilverID;
	
	//Blocks
	public static Block oreCopper;
	public static Block oreTin;
	public static Block oreSilver;
	
	//Items
	public static Item ingotCopper;
	public static Item ingotTin;
	public static Item ingotSilver;
	
	//Pre Initialization
	@EventHandler
	public void load(FMLPreInitializationEvent even) {
		
		Configuration config = new Configuration(new File("config/Chicken.cfg"));
		
		config.load();
			
			//Block Ids
			oreCopperID = config.get("Blocks", "Copper Ore", 500).getInt();
			oreTinID = config.get("Blocks", "Tin Ore", 501).getInt();
			oreSilverID = config.get("Blocks", "Silver Ore", 502).getInt();
			
			
			//Item Ids
			ingotCopperID = config.get("Items", "Copper Ingot", 5000).getInt();
			ingotTinID = config.get("Items", "Tin Ingot", 5001).getInt();
			ingotSilverID = config.get("Items", "Tin Silver", 5002).getInt();			
			
		config.save();
		
	}
	
	//Initialization
	@EventHandler
	public void load(FMLInitializationEvent event) {
		
		//Tabs
		tabChickenBlocks = new TabChickenBlocks(CreativeTabs.getNextID(), "TabChickenBlocks");
		tabChickenItems = new TabChickenItems(CreativeTabs.getNextID(), "TabChickenItems");
		
		//Blocks
		oreCopper = new BlockCopperOre(oreCopperID, Material.rock);
		LanguageRegistry.addName(oreCopper, "Copper Ore");
		GameRegistry.registerBlock(oreCopper);
		MinecraftForge.setBlockHarvestLevel(oreCopper, "pickaxe", 1);
		GameRegistry.registerWorldGenerator(new WorldGeneratorCopperOre());
		OreDictionary.registerOre("oreCopper", new ItemStack(oreCopper));
		
		oreTin = new BlockTinOre(oreTinID, Material.rock);
		LanguageRegistry.addName(oreTin, "Tin Ore");
		GameRegistry.registerBlock(oreTin);
		MinecraftForge.setBlockHarvestLevel(oreTin, "pickaxe", 1);
		GameRegistry.registerWorldGenerator(new WorldGeneratorTinOre());
		OreDictionary.registerOre("oreTin", new ItemStack(oreTin));
		
		oreSilver = new BlockSilverOre(oreSilverID, Material.rock);
		LanguageRegistry.addName(oreSilver, "Silver Ore");
		GameRegistry.registerBlock(oreSilver);
		MinecraftForge.setBlockHarvestLevel(oreSilver, "pickaxe", 1);
		GameRegistry.registerWorldGenerator(new WorldGeneratorSilverOre());
		OreDictionary.registerOre("oreSilver", new ItemStack(oreSilver));
		
		
		//Items
		ingotCopper = new ItemCopperIngot(ingotCopperID);
		LanguageRegistry.addName(ingotCopper, "Copper Ingot");
		GameRegistry.addSmelting(Chicken.oreCopper.blockID, new ItemStack(Chicken.ingotCopper), 0.1F);
		OreDictionary.registerOre("ingotCopper", new ItemStack(ingotCopper));
		
		ingotTin = new ItemTinIngot(ingotTinID);
		LanguageRegistry.addName(ingotTin, "Tin Ingot");
		GameRegistry.addSmelting(Chicken.oreTin.blockID, new ItemStack(Chicken.ingotTin), 0.1F);
		OreDictionary.registerOre("ingotTin", new ItemStack(ingotTin));
		
		ingotSilver = new ItemSilverIngot(ingotSilverID);
		LanguageRegistry.addName(ingotSilver, "Silver Ingot");
		GameRegistry.addSmelting(Chicken.oreSilver.blockID, new ItemStack(Chicken.ingotSilver), 0.1F);
		OreDictionary.registerOre("ingotTin", new ItemStack(ingotTin));
		
	}
	
	//Post Initialization
	@EventHandler
	public void load(FMLPostInitializationEvent event) {
		
	}
	
}
