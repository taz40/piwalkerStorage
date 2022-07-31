package net.piwalker.storage.block.entity;

import ellemes.container_library.api.v2.OpenableBlockEntityV2;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LockableContainerBlockEntity;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Nameable;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.piwalker.storage.PiWalkerStorage;

public class InventoryMergerEntity extends LockableContainerBlockEntity implements OpenableBlockEntityV2 {

    LockableContainerBlockEntity chest;

    public InventoryMergerEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.INVENTORY_MERGER_ENTITY, pos, state);
    }

    public void update(World world, BlockPos pos)  {
        BlockEntity entity = world.getBlockEntity(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()));
        if(entity != null && entity instanceof LockableContainerBlockEntity){
            chest = (LockableContainerBlockEntity) entity;
        }
    }

    @Override
    protected Text getContainerName() {
        return chest.getName();
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return null;
    }

    @Override
    public int size() {
        return chest.size();
    }

    @Override
    public boolean isEmpty() {
        return chest.isEmpty();
    }

    @Override
    public ItemStack getStack(int slot) {
        return chest.getStack(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        return chest.removeStack(slot, amount);
    }

    @Override
    public ItemStack removeStack(int slot) {
        return chest.removeStack(slot);
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        chest.setStack(slot, stack);
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return chest.canPlayerUse(player);
    }

    @Override
    public void clear() {
        chest.clear();
    }
}
