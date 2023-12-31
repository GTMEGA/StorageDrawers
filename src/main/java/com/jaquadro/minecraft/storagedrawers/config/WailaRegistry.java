package com.jaquadro.minecraft.storagedrawers.config;

import java.util.ArrayList;
import java.util.List;

import com.jaquadro.minecraft.storagedrawers.api.registry.IWailaRegistry;
import com.jaquadro.minecraft.storagedrawers.api.registry.IWailaTooltipHandler;

public class WailaRegistry implements IWailaRegistry {

    private List<IWailaTooltipHandler> registry = new ArrayList<IWailaTooltipHandler>();

    @Override
    public void registerTooltipHandler(IWailaTooltipHandler handler) {
        registry.add(handler);
    }

    public List<IWailaTooltipHandler> getTooltipHandlers() {
        return registry;
    }
}
