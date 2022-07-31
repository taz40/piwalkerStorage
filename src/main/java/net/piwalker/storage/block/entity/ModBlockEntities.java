package net.piwalker.storage.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.piwalker.storage.PiWalkerStorage;
import net.piwalker.storage.block.ModBlocks;

public class ModBlockEntities {

    public static BlockEntityType<InventoryMergerEntity> INVENTORY_MERGER_ENTITY;

    public static void registerModBlockEntities(){
        PiWalkerStorage.LOGGER.info("Registering block entities for " + PiWalkerStorage.MOD_ID);

        INVENTORY_MERGER_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(PiWalkerStorage.MOD_ID, "inventory_merger"),
                FabricBlockEntityTypeBuilder.create(InventoryMergerEntity::new, ModBlocks.INVENTORY_MERGER).build(null));

    }

}
