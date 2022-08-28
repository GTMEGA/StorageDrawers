package com.jaquadro.minecraft.storagedrawers.api.storage.attribute;

public interface IDowngradable {

    boolean canDowngrade();

    boolean isDowngraded();

    boolean checkDowngraded();

    void setDowngraded(boolean state);
}
