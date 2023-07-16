package com.github.largeessentiagenerator.common.gregtech.materials;

import gregtech.api.unification.Element;
import gregtech.api.unification.Elements;
import gregtech.api.unification.material.Material;
import net.minecraft.util.ResourceLocation;

import static gregtech.api.unification.Elements.add;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.DISABLE_DECOMPOSITION;
import static gregtech.api.unification.material.info.MaterialIconSet.DULL;
import static gregtech.api.unification.material.info.MaterialIconSet.SHINY;

public class EGMaterial {

    //24000-25000
    public static Material Coolant;
    public static Material SuperCoolant;
    public static Material Cryotheum;
    public static Material XPJuice;
    public static Material Spirit;
    public static Material Hollowtears;
    public static Material AtomicSeparationCatalyst;
    public static Material Magic;
    public static Material Thaumium;
    public static Material Void;

    public static final Element emptiness = add(0L, 0L, -1L, null, "Void", "§5§kV", false);

    public static void register() {
        Magic = new Material.Builder(24000, new ResourceLocation("magic"))
                .color(0xf7adde)
                .element(Elements.Ma)
                .build();

        Thaumium = new Material.Builder(24001, new ResourceLocation("thaumium"))
                .ingot(1)
                .color(0x523766).iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Iron, 1, Magic, 1)
                .build();

        Void = new Material.Builder(24002, new ResourceLocation("void"))
                .ingot(1)
                .color(0x120d1b).iconSet(DULL)
                .element(emptiness)
                .build();
    }
}
