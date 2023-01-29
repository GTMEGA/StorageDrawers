package com.jaquadro.minecraft.storagedrawers.inventory;

import net.minecraft.entity.player.InventoryPlayer;

import com.jaquadro.minecraft.storagedrawers.block.tile.TileEntityDrawers;

public class ContainerDrawers2 extends ContainerDrawers {

    private static final int[][] slotCoordinates = new int[][] { { 80, 23 }, { 80, 49 } };

    public ContainerDrawers2(InventoryPlayer playerInventory, TileEntityDrawers tileEntity) {
        super(playerInventory, tileEntity);
    }

    @Override
    protected int getStorageSlotX(int slot) {
        return slotCoordinates[slot][0];
    }

    @Override
    protected int getStorageSlotY(int slot) {
        return slotCoordinates[slot][1];
    }
}
