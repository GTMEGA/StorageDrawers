package com.jaquadro.minecraft.storagedrawers.config;

import java.util.ArrayList;
import java.util.List;

import com.jaquadro.minecraft.storagedrawers.api.registry.IRenderRegistry;
import com.jaquadro.minecraft.storagedrawers.api.render.IRenderLabel;

public class RenderRegistry implements IRenderRegistry {

    private List<IRenderLabel> registry = new ArrayList<IRenderLabel>();

    @Override
    public void registerPreLabelRenderHandler(IRenderLabel renderHandler) {
        registry.add(renderHandler);
    }

    public List<IRenderLabel> getRenderHandlers() {
        return registry;
    }
}
