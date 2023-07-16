package com.github.largeessentiagenerator.common.gregtech;

import com.github.largeessentiagenerator.common.gregtech.metablock.EGMetaCasing;
import com.github.largeessentiagenerator.common.gregtech.metablock.EGMetaCell;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

import static gregtech.common.blocks.MetaBlocks.statePropertiesToString;

public class EGMetaBlocks {

    public static final EGMetaCasing EG_BLOCK_CASING = new EGMetaCasing();
    public static final EGMetaCell EG_ESSENTIA_CELL = new EGMetaCell();

    public static boolean isEssentiaCell(IBlockState state) {
        if (!state.getBlock().equals(EG_ESSENTIA_CELL)) {
            return false;
        }
        if (state.equals(EG_ESSENTIA_CELL.getState(EGMetaCell.MetaCellType.ESSENTIA_CELL_T1))) {
            return true;
        } else if (state.equals(EG_ESSENTIA_CELL.getState(EGMetaCell.MetaCellType.ESSENTIA_CELL_T2))) {
            return true;
        } else if (state.equals(EG_ESSENTIA_CELL.getState(EGMetaCell.MetaCellType.ESSENTIA_CELL_T3))) {
            return true;
        } else return state.equals(EG_ESSENTIA_CELL.getState(EGMetaCell.MetaCellType.ESSENTIA_CELL_T4));
    }

    public static int getCellTier(IBlockState state) {
        if (state.equals(EG_ESSENTIA_CELL.getState(EGMetaCell.MetaCellType.ESSENTIA_CELL_T1))) {
            return 1;
        } else if (state.equals(EG_ESSENTIA_CELL.getState(EGMetaCell.MetaCellType.ESSENTIA_CELL_T2))) {
            return 2;
        } else if (state.equals(EG_ESSENTIA_CELL.getState(EGMetaCell.MetaCellType.ESSENTIA_CELL_T3))) {
            return 3;
        } else if (state.equals(EG_ESSENTIA_CELL.getState(EGMetaCell.MetaCellType.ESSENTIA_CELL_T4))) {
            return 4;
        }
        return -1;
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        registerItemModel(EG_BLOCK_CASING);
        registerItemModel(EG_ESSENTIA_CELL);
    }

    @SideOnly(Side.CLIENT)
    private static void registerItemModel(@Nonnull Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            //noinspection ConstantConditions
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(),
                            statePropertiesToString(state.getProperties())));
        }
    }

}
