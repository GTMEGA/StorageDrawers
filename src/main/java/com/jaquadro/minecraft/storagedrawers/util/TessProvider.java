package com.jaquadro.minecraft.storagedrawers.util;

import net.minecraft.client.renderer.Tessellator;

public final class TessProvider {

    public static Tessellator getTess() {
        return Tessellator.instance;
    }
}
