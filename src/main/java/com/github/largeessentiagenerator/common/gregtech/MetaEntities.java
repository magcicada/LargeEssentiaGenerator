package com.github.largeessentiagenerator.common.gregtech;

import com.github.largeessentiagenerator.common.gregtech.metatileentity.MetaTileEntityEssentiaGenerator;
import com.github.largeessentiagenerator.util.libs.Refstrings;
import net.minecraft.util.ResourceLocation;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

public class MetaEntities {

    public static MetaTileEntityEssentiaGenerator ESSENTIA_GENERATOR;

    public static void register() {
        ESSENTIA_GENERATOR = registerMetaTileEntity(11001, new MetaTileEntityEssentiaGenerator(new ResourceLocation(Refstrings.MODID, "essentia_generator")));
    }

}
