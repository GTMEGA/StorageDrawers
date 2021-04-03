package com.jaquadro.minecraft.storagedrawers.item;

import com.jaquadro.minecraft.storagedrawers.core.ModCreativeTabs;
import net.minecraft.item.Item;

public class ItemUpgradeDowngrade extends Item {

    public ItemUpgradeDowngrade(String name) {
        setUnlocalizedName(name);
        setHasSubtypes(true);
        setCreativeTab(ModCreativeTabs.tabStorageDrawers);
        setMaxDamage(0);
    }
}
