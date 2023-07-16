package com.github.largeessentiagenerator.common.gregtech.predicate;

import com.github.largeessentiagenerator.common.gregtech.EGMetaBlocks;
import com.github.largeessentiagenerator.common.gregtech.metablock.EGMetaCasing;
import com.github.largeessentiagenerator.common.gregtech.metablock.EGMetaCell;
import gregtech.api.pattern.PatternStringError;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.BlockInfo;
import net.minecraft.block.state.IBlockState;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class EssentiaCellPredicate {

    public static TraceabilityPredicate ESSENTIA_CELLS = new TraceabilityPredicate(blockWorldState -> {
        IBlockState blockState = blockWorldState.getBlockState();
        if (EGMetaBlocks.isEssentiaCell(blockState)) {
            int tier = EGMetaBlocks.getCellTier(blockState);
            Object currentCell = blockWorldState.getMatchContext().getOrPut("ESS_CELL", tier);
            if (!currentCell.equals(tier)) {
                blockWorldState.setError(new PatternStringError("leg.multiblock.pattern.error.essentia"));
                return false;
            }
            blockWorldState.getMatchContext().getOrPut("VABlock", new LinkedList<>()).add(blockWorldState.getPos());
            return true;
        }
        return false;
    }, () -> Arrays.stream(EGMetaCell.MetaCellType.values())
            .sorted(Comparator.comparing(EGMetaCell.MetaCellType::getName))
            .map(type -> new BlockInfo(EGMetaBlocks.EG_ESSENTIA_CELL.getState(type), null))
            .toArray(BlockInfo[]::new))
            .addTooltips("leg.multiblock.pattern.error.essentia");

  //  () -> Arrays.stream(BlockCrucible.CrucibleType.values())
    //        .sorted(Comparator.comparingInt(BlockCrucible.CrucibleType::getTemperature))
   //         .map(type -> new BlockInfo(GCYSMetaBlocks.CRUCIBLE.getState(type), null))
      //      .toArray(BlockInfo[]::new));

}
