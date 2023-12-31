package com.jaquadro.minecraft.storagedrawers.item.pack;

import net.minecraft.block.Block;

import com.jaquadro.minecraft.storagedrawers.block.pack.BlockDrawersPack;
import com.jaquadro.minecraft.storagedrawers.item.ItemBasicDrawers;

public class ItemDrawersPack extends ItemBasicDrawers {

    public ItemDrawersPack(Block block) {
        super(block, getUnlocalizedNames(block));
    }

    protected ItemDrawersPack(Block block, String[] unlocalizedNames) {
        super(block, unlocalizedNames);
    }

    private static String[] getUnlocalizedNames(Block block) {
        if (block instanceof BlockDrawersPack) return ((BlockDrawersPack) block).getUnlocalizedNames();
        else return new String[16];
    }
}
