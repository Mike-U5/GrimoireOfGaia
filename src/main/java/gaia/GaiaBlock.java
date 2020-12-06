package gaia;

import cpw.mods.fml.common.registry.GameRegistry;
import gaia.block.BlockBustSphinx;
import gaia.block.BlockBustValkyrie;
import gaia.block.BlockBustVampire;
import gaia.block.BlockDollCreeperGirl;
import gaia.block.BlockDollEnderGirl;
import gaia.block.BlockDollMaid;
import gaia.block.BlockDollSlimeGirl;
import gaia.tileentity.TileEntityBustSphinx;
import gaia.tileentity.TileEntityBustValkyrie;
import gaia.tileentity.TileEntityBustVampire;
import gaia.tileentity.TileEntityDollCreeperGirl;
import gaia.tileentity.TileEntityDollEnderGirl;
import gaia.tileentity.TileEntityDollMaid;
import gaia.tileentity.TileEntityDollSlimeGirl;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GaiaBlock {
	public static final String modid = "GrimoireOfGaia";
	public static Block BustSphinx;
	public static Block BustValkyrie;
	public static Block BustVampire;
	public static Block DollCreeperGirl;
	public static Block DollEnderGirl;
	public static Block DollSlimeGirl;
	public static Block DollMaid;

	public static void init() {
		addBlocks();
		prepareBlocks();
		registerTileEntities();
	}

	public static void addBlocks() {
		BustSphinx = (new BlockBustSphinx(Material.rock)).setBlockTextureName("Gaia:Icon_Bust");
		BustValkyrie = (new BlockBustValkyrie(Material.rock)).setBlockTextureName("Gaia:Icon_Bust");
		BustVampire = (new BlockBustVampire(Material.rock)).setBlockTextureName("Gaia:Icon_Bust");
		DollCreeperGirl = (new BlockDollCreeperGirl(Material.cloth)).setBlockTextureName("Gaia:Icon_Doll");
		DollEnderGirl = (new BlockDollEnderGirl(Material.cloth)).setBlockTextureName("Gaia:Icon_Doll");
		DollSlimeGirl = (new BlockDollSlimeGirl(Material.cloth)).setBlockTextureName("Gaia:Icon_Doll");
		DollMaid = (new BlockDollMaid(Material.cloth)).setBlockTextureName("Gaia:Icon_Doll");
	}

//	public static void addRecipes() {}

	public static void prepareBlocks() {
		registerBlocks(BustSphinx, "The Sphinx");
		registerBlocks(BustValkyrie, "The Valkyrie");
		registerBlocks(BustVampire, "The Vampire");
		registerBlocks(DollCreeperGirl, "Creeper Girl Doll");
		registerBlocks(DollEnderGirl, "Ender Girl Doll");
		registerBlocks(DollSlimeGirl, "Slime Girl Doll");
		registerBlocks(DollMaid, "Maid Doll");
	}

	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityBustSphinx.class, "BustSphinx");
		GameRegistry.registerTileEntity(TileEntityBustValkyrie.class, "BustValkyrie");
		GameRegistry.registerTileEntity(TileEntityBustVampire.class, "BustVampire");
		GameRegistry.registerTileEntity(TileEntityDollCreeperGirl.class, "DollCreeperGirl");
		GameRegistry.registerTileEntity(TileEntityDollEnderGirl.class, "DollEnderGirl");
		GameRegistry.registerTileEntity(TileEntityDollSlimeGirl.class, "DollSlimeGirl");
		GameRegistry.registerTileEntity(TileEntityDollMaid.class, "DollMaid");
	}

	public static void registerBlocks(Block block, String name) {
		GameRegistry.registerBlock(block, name);
//		LanguageRegistry.addName(block, name);
	}
}
