package com.jaquadro.minecraft.storagedrawers.api.render;

import net.minecraft.tileentity.TileEntity;

import com.jaquadro.minecraft.storagedrawers.api.storage.IDrawerGroup;

public interface IRenderLabel {

    void render(TileEntity tileEntity, IDrawerGroup drawerGroup, int slot, float brightness, float partialTickTime);
}
