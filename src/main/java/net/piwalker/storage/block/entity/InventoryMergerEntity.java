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

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class InventoryMergerEntity extends LockableContainerBlockEntity implements OpenableBlockEntityV2 {

    ArrayList<LockableContainerBlockEntity> inventories;
    boolean initialized = false;

    public InventoryMergerEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.INVENTORY_MERGER_ENTITY, pos, state);
        inventories = new ArrayList<>();
    }

    public void testForInventory(BlockPos pos){
        BlockEntity entity = world.getBlockEntity(pos);
        if(entity != null && entity instanceof LockableContainerBlockEntity){
            inventories.add((LockableContainerBlockEntity) entity);
        }
    }

    public void tick(World world, BlockPos pos){
        if(!initialized){
            initialized = true;
            update(world, pos);
        }
    }

    public void update(World world, BlockPos pos)  {
        inventories = new ArrayList<>();
        testForInventory(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()));
        testForInventory(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()));
        testForInventory(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()));
        testForInventory(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()));
        testForInventory(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1));
        testForInventory(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1));
    }

    @Override
    protected Text getContainerName() {
        return Text.literal("Inventory Merger");
    }



    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for(LockableContainerBlockEntity inventory : inventories){
            size += inventory.size();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        for(LockableContainerBlockEntity inventory : inventories){
            if(!inventory.isEmpty()){
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getStack(int slot) {
        for(LockableContainerBlockEntity inventory : inventories){
            if(slot < inventory.size()){
                return inventory.getStack(slot);
            }else{
                slot -= inventory.size();
            }
        }
        return null;
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        for(LockableContainerBlockEntity inventory : inventories){
            if(slot < inventory.size()){
                return inventory.removeStack(slot, amount);
            }else{
                slot -= inventory.size();
            }
        }
        return null;
    }

    @Override
    public ItemStack removeStack(int slot) {
        for(LockableContainerBlockEntity inventory : inventories){
            if(slot < inventory.size()){
                return inventory.removeStack(slot);
            }else{
                slot -= inventory.size();
            }
        }
        return null;
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        for(LockableContainerBlockEntity inventory : inventories){
            if(slot < inventory.size()){
                inventory.setStack(slot, stack);
                return;
            }else{
                slot -= inventory.size();
            }
        }
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }

    @Override
    public void clear() {
        for(LockableContainerBlockEntity inventory : inventories){
            inventory.clear();
        }
    }



}
