package com.jaquadro.minecraft.storagedrawers.integration.refinedrelocation;

import net.minecraft.item.ItemStack;

import com.dynious.refinedrelocation.api.filter.IFilter;
import com.jaquadro.minecraft.storagedrawers.api.storage.IDrawer;
import com.jaquadro.minecraft.storagedrawers.api.storage.IDrawerGroup;

public class DrawerFilter implements IFilter {

    private IDrawerGroup group;

    public DrawerFilter(IDrawerGroup group) {
        this.group = group;
    }

    @Override
    public boolean passesFilter(ItemStack itemStack) {
        for (int i = 0; i < group.getDrawerCount(); i++) {
            if (!group.isDrawerEnabled(i)) continue;

            IDrawer drawer = group.getDrawer(i);
            if (!drawer.isEmpty() && drawer.canItemBeStored(itemStack)) return true;
        }

        return false;
    }
}
