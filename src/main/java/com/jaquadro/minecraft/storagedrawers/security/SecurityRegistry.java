package com.jaquadro.minecraft.storagedrawers.security;

import java.util.HashMap;
import java.util.Map;

import com.jaquadro.minecraft.storagedrawers.api.security.ISecurityProvider;

public class SecurityRegistry {

    private Map<String, ISecurityProvider> registry = new HashMap<String, ISecurityProvider>();

    public void registerProvider(ISecurityProvider provider) {
        registry.put(provider.getProviderID(), provider);
    }

    public ISecurityProvider getProvider(String name) {
        return registry.get(name);
    }
}
