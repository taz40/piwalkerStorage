package net.piwalker.storage.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.piwalker.storage.PiWalkerStorage;

public class ModItemGroups {

    public static final ItemGroup PIWALKER_STORAGE = FabricItemGroupBuilder.build(new Identifier(PiWalkerStorage.MOD_ID, "piwalker_storage"),  () -> new ItemStack(Items.IRON_AXE));

}
