package com.jaquadro.minecraft.storagedrawers.client.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

import com.jaquadro.minecraft.storagedrawers.StorageDrawers;
import com.jaquadro.minecraft.storagedrawers.block.BlockController;
import com.jaquadro.minecraft.storagedrawers.block.tile.TileEntityController;
import com.jaquadro.minecraft.storagedrawers.util.RenderHelper;
import com.jaquadro.minecraft.storagedrawers.util.RenderHelperState;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class ControllerRenderer implements ISimpleBlockRenderingHandler {

    private static final double unit = .0625f;
    private ModularBoxRenderer boxRenderer = new ModularBoxRenderer();

    private RenderHelper renderHelper = RenderHelper.instances.get();

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        if (!(block instanceof BlockController)) return;

        renderInventoryBlock((BlockController) block, metadata, modelId, renderer);
    }

    private void renderInventoryBlock(BlockController block, int metadata, int modelId, RenderBlocks renderer) {
        int side = 4;

        boxRenderer.setUnit(unit);
        boxRenderer.setColor(ModularBoxRenderer.COLOR_WHITE);
        for (int i = 0; i < 6; i++) boxRenderer.setIcon(block.getIcon(i, metadata), i);

        GL11.glRotatef(90, 0, 1, 0);
        GL11.glTranslatef(-.5f, -.5f, -.5f);

        renderHelper.state
                .setUVRotation(RenderHelper.YPOS, RenderHelperState.ROTATION_BY_FACE_FACE[RenderHelper.ZNEG][side]);

        renderExterior(block, 0, 0, 0, side, renderer);

        boxRenderer.setUnit(0);
        boxRenderer.setInteriorIcon(block.getIcon(side, metadata), ForgeDirection.OPPOSITES[side]);

        renderInterior(block, 0, 0, 0, side, renderer);

        renderHelper.state.clearUVRotation(RenderHelper.YPOS);

        GL11.glTranslatef(.5f, .5f, .5f);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
            RenderBlocks renderer) {
        if (!(block instanceof BlockController)) return false;

        return renderWorldBlock(world, x, y, z, (BlockController) block, modelId, renderer);
    }

    private boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, BlockController block, int modelId,
            RenderBlocks renderer) {
        TileEntityController tile = block.getTileEntity(world, x, y, z);
        if (tile == null) return false;

        int side = tile.getDirection();

        renderHelper.state
                .setUVRotation(RenderHelper.YPOS, RenderHelperState.ROTATION_BY_FACE_FACE[RenderHelper.ZNEG][side]);

        boxRenderer.setUnit(unit);
        boxRenderer.setColor(ModularBoxRenderer.COLOR_WHITE);
        for (int i = 0; i < 6; i++) boxRenderer.setExteriorIcon(block.getIcon(world, x, y, z, i), i);

        boxRenderer.setCutIcon(block.getIconTrim(0));
        boxRenderer.setInteriorIcon(block.getIconTrim(0));

        renderExterior(block, x, y, z, side, renderer);

        boxRenderer.setUnit(0);
        boxRenderer.setInteriorIcon(block.getIcon(world, x, y, z, side), ForgeDirection.OPPOSITES[side]);

        renderInterior(block, x, y, z, side, renderer);

        renderHelper.state.clearUVRotation(RenderHelper.YPOS);

        return true;
    }

    private void renderExterior(BlockController block, int x, int y, int z, int side, RenderBlocks renderer) {
        double depth = 1;
        double xMin = 0, xMax = 0, zMin = 0, zMax = 0;

        switch (side) {
            case 2:
                xMin = 0;
                xMax = 1;
                zMin = 1 - depth;
                zMax = 1;
                break;
            case 3:
                xMin = 0;
                xMax = 1;
                zMin = 0;
                zMax = depth;
                break;
            case 4:
                xMin = 1 - depth;
                xMax = 1;
                zMin = 0;
                zMax = 1;
                break;
            case 5:
                xMin = 0;
                xMax = depth;
                zMin = 0;
                zMax = 1;
                break;
        }

        boxRenderer.renderExterior(
                renderer.blockAccess,
                block,
                x,
                y,
                z,
                xMin,
                0,
                zMin,
                xMax,
                1,
                zMax,
                0,
                ModularBoxRenderer.sideCut[side]);
    }

    private void renderInterior(BlockController block, int x, int y, int z, int side, RenderBlocks renderer) {
        double unit = .0625;
        double depth = 1;
        double xMin = 0, xMax = 0, zMin = 0, zMax = 0;

        switch (side) {
            case 2:
                xMin = unit;
                xMax = 1 - unit;
                zMin = 1 - depth;
                zMax = 1 - depth + unit;
                break;
            case 3:
                xMin = unit;
                xMax = 1 - unit;
                zMin = depth - unit;
                zMax = depth;
                break;
            case 4:
                xMin = 1 - depth;
                xMax = 1 - depth + unit;
                zMin = unit;
                zMax = 1 - unit;
                break;
            case 5:
                xMin = depth - unit;
                xMax = depth;
                zMin = unit;
                zMax = 1 - unit;
                break;
        }

        boxRenderer.renderInterior(
                renderer.blockAccess,
                block,
                x,
                y,
                z,
                xMin,
                unit,
                zMin,
                xMax,
                1 - unit,
                zMax,
                0,
                ModularBoxRenderer.sideCut[side]);
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    @Override
    public int getRenderId() {
        return StorageDrawers.proxy.controllerRenderID;
    }
}
