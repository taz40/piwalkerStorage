package net.piwalker.storage.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.piwalker.storage.PiWalkerStorage;
import net.piwalker.storage.item.ModItemGroups;

public class ModBlocks {

    public static Block INVENTORY_MERGER = registerBlock("inventory_merger", new InventoryMerger(FabricBlockSettings.of(Material.STONE)), ModItemGroups.PIWALKER_STORAGE);

    private static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(PiWalkerStorage.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        return Registry.register(Registry.ITEM, new Identifier(PiWalkerStorage.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerBlocks(){
        PiWalkerStorage.LOGGER.info("Registering blocks for " + PiWalkerStorage.MOD_ID);
    }

}
