package com.jaquadro.minecraft.storagedrawers.inventory;

import net.minecraft.entity.player.InventoryPlayer;

import com.jaquadro.minecraft.storagedrawers.block.tile.TileEntityDrawers;

public class ContainerDrawers1 extends ContainerDrawers {

    private static final int[][] slotCoordinates = new int[][] { { 80, 36 } };

    public ContainerDrawers1(InventoryPlayer playerInventory, TileEntityDrawers tileEntity) {
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
