package com.github.largeessentiagenerator.common.thaumcraft;

import com.github.largeessentiagenerator.common.gregtech.CommonBlocks;
import com.github.largeessentiagenerator.common.gregtech.EGMetaBlocks;
import com.github.largeessentiagenerator.proxy.CommonProxy;
import com.github.largeessentiagenerator.util.libs.Refstrings;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.builders.AssemblerRecipeBuilder;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.items.ItemsTC;

public class ThaumcraftRecipes {

    public static void initRecipes() {
        initTCRecipes();
    }

    private static void initTCRecipes() {
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(Refstrings.MODID, "generator_blank_upgrade"), new ShapedArcaneRecipe(
                new ResourceLocation(""),
                // "MACHINE_UPGRADE",
                "",
                250,
                new AspectList().add(Aspect.AIR, 2).add(Aspect.ORDER, 2).add(Aspect.FIRE, 2),
                new ItemStack(CommonProxy.Upgrades, 1, 0),
                "SBS",
                "BMB",
                "SBS",
                'S', "screwStainlessSteel",
                'B', "plateSteel",
                'M', new ItemStack(ItemsTC.mirroredGlass)));

        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(Refstrings.MODID, "generator_air_upgrade"), new CrucibleRecipe(
                // "MACHINE_UPGRADE",
                "",
                new ItemStack(CommonProxy.Upgrades, 1, 1),
                new ItemStack(CommonProxy.Upgrades, 1, 0),
                new AspectList().add(Aspect.AIR, 50)));

        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(Refstrings.MODID, "generator_thermal_upgrade"), new CrucibleRecipe(
                // "MACHINE_UPGRADE",
                "",
                new ItemStack(CommonProxy.Upgrades, 1, 2),
                new ItemStack(CommonProxy.Upgrades, 1, 0),
                new AspectList().add(Aspect.FIRE, 50)));

        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(Refstrings.MODID, "generator_unstable_upgrade"), new CrucibleRecipe(
                // "MACHINE_UPGRADE",
                "",
                new ItemStack(CommonProxy.Upgrades, 1, 3),
                new ItemStack(CommonProxy.Upgrades, 1, 0),
                new AspectList().add(Aspect.ENTROPY, 50)));

        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(Refstrings.MODID, "generator_life_upgrade"), new CrucibleRecipe(
                // "MACHINE_UPGRADE",
                "",
                new ItemStack(CommonProxy.Upgrades, 1, 4),
                new ItemStack(CommonProxy.Upgrades, 1, 0),
                new AspectList().add(Aspect.LIFE, 50)));

        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(Refstrings.MODID, "generator_taint_upgrade"), new CrucibleRecipe(
                // "MACHINE_UPGRADE",
                "",
                new ItemStack(CommonProxy.Upgrades, 1, 5),
                new ItemStack(CommonProxy.Upgrades, 1, 0),
                new AspectList().add(Aspect.FLUX, 50)));

        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(Refstrings.MODID, "generator_machine_upgrade"), new CrucibleRecipe(
                // "MACHINE_UPGRADE",
                "",
                new ItemStack(CommonProxy.Upgrades, 1, 6),
                new ItemStack(CommonProxy.Upgrades, 1, 0),
                new AspectList().add(Aspect.MECHANISM, 50)));

        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(Refstrings.MODID, "generator_spirit_upgrade"), new CrucibleRecipe(
                // "MACHINE_UPGRADE",
                "",
                new ItemStack(CommonProxy.Upgrades, 1, 7),
                new ItemStack(CommonProxy.Upgrades, 1, 0),
                new AspectList().add(Aspect.MECHANISM, 50)));

        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(Refstrings.MODID, "magic_machine_casing"), new ShapedArcaneRecipe(
                new ResourceLocation(""),
                // "LARGE_ESSENTIA_GENERATOR",
                "",
                50,
                new AspectList().add(Aspect.AIR, 2).add(Aspect.ORDER, 2).add(Aspect.FIRE, 2),
                new ItemStack(EGMetaBlocks.EG_BLOCK_CASING, 1, 0),
                "STS",
                "GMG",
                "STS",
                'S', new ItemStack(ItemsTC.salisMundus),
                'T', "plateThaumium",
                'G', new ItemStack(MetaBlocks.TRANSPARENT_CASING, 1, 2),
                'M', new ItemStack(MetaBlocks.MACHINE_CASING, 1, 3)));

        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(Refstrings.MODID, "large_essentia_generator"), new InfusionRecipe(
                // "LARGE_ESSENTIA_GENERATOR",
                "",
                new ItemStack(MetaBlocks.MACHINE, 1, 11001),
                6,
                new AspectList().add(Aspect.ENERGY, 250).add(Aspect.MOTION, 250).add(Aspect.EXCHANGE, 125).add(Aspect.MAGIC, 125),
                new ItemStack(MetaBlocks.MACHINE, 1, 1183),
                "circuitHv",
                MetaItems.SENSOR_HV.getStackForm(),
                "gemEmerald",
                new ItemStack(ItemsTC.mechanismComplex),
                new ItemStack(ItemsTC.mind, 1, 1),
                new ItemStack(MetaBlocks.WIRE_COIL, 1, 0),
                new ItemStack(BlocksTC.bellows),
                new ItemStack(BlocksTC.jarNormal)));

        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(Refstrings.MODID, "essentia_input_hatch"), new InfusionRecipe(
                // "LARGE_ESSENTIA_GENERATOR",
                "",
                new ItemStack(CommonBlocks.ESSENTIA_HATCH),
                6,
                new AspectList().add(Aspect.WATER, 250).add(Aspect.MIND, 125).add(Aspect.EXCHANGE, 125).add(Aspect.VOID, 250),
                new ItemStack(MetaBlocks.MACHINE, 1, 1183),
                MetaItems.ELECTRIC_PUMP_MV.getStackForm(),
                new ItemStack(EGMetaBlocks.EG_BLOCK_CASING),
                new ItemStack(BlocksTC.tube),
                new ItemStack(BlocksTC.jarNormal)));

        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(Refstrings.MODID, "essentis_cell_basic"), new InfusionRecipe(
                // "LARGE_ESSENTIA_GENERATOR",
                "",
                new ItemStack(EGMetaBlocks.EG_ESSENTIA_CELL),
                4,
                new AspectList().add(Aspect.WATER, 50).add(Aspect.VOID, 50).add(Aspect.EXCHANGE, 25),
                "gearAluminium",
                MetaItems.ELECTRIC_PUMP_HV.getStackForm(),
                "plateStainlessSteel",
                "plateStainlessSteel",
                "pipeSmallFluidStainlessSteel",
                new ItemStack(BlocksTC.tubeBuffer),
                new ItemStack(MetaBlocks.TRANSPARENT_CASING)));

        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(Refstrings.MODID, "essentis_cell_good"), new InfusionRecipe(
                //  "CELL_UPGRADE",
                "",
                new ItemStack(EGMetaBlocks.EG_ESSENTIA_CELL, 1, 1),
                6,
                new AspectList().add(Aspect.WATER, 125).add(Aspect.VOID, 125).add(Aspect.EXCHANGE, 75),
                new ItemStack(EGMetaBlocks.EG_ESSENTIA_CELL),
                MetaItems.ELECTRIC_PUMP_IV.getStackForm(),
                "plateIridium",
                MetaItems.QUANTUM_STAR.getStackForm(),
                new ItemStack(Blocks.PACKED_ICE),
                new ItemStack(BlocksTC.metalAlchemicalAdvanced),
                "stickPlutonium241"));

        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(Refstrings.MODID, "essentis_cell_advanced"), new InfusionRecipe(
                //  "CELL_UPGRADE",
                "",
                new ItemStack(EGMetaBlocks.EG_ESSENTIA_CELL, 1, 2),
                8,
                new AspectList().add(Aspect.WATER, 250).add(Aspect.VOID, 250).add(Aspect.EXCHANGE, 125),
                new ItemStack(EGMetaBlocks.EG_ESSENTIA_CELL, 1, 1),
                MetaItems.FIELD_GENERATOR_IV.getStackForm(),
                MetaItems.ELECTRIC_PUMP_LuV.getStackForm(),
                new ItemStack(ItemsTC.salisMundus),
                new ItemStack(BlocksTC.jarNormal),
                Ingredient.fromItem(ItemsTC.primordialPearl),
                "plateVoid"));

        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(Refstrings.MODID, "essentis_cell_elite"), new InfusionRecipe(
              //  "CELL_UPGRADE",
                "",
                new ItemStack(EGMetaBlocks.EG_ESSENTIA_CELL, 1, 3),
                12,
                new AspectList().add(Aspect.WATER, 500).add(Aspect.VOID, 500).add(Aspect.EXCHANGE, 250),
                new ItemStack(EGMetaBlocks.EG_ESSENTIA_CELL, 1, 2),
                MetaItems.EMITTER_LuV.getStackForm(),
                FluidUtil.getFilledBucket(new FluidStack(Materials.Helium.getFluid(), 1000)),
                new ItemStack(ItemsTC.curio, 1, 5),
                "blockIridium",
                "blockBorosilicateGlass",
                "plateEuropium"));

        ModHandler.removeRecipeByName(new ResourceLocation("thaumcraft:ironplate"));
        ModHandler.removeRecipeByName(new ResourceLocation("thaumcraft:brassplate"));
        ModHandler.removeRecipeByName(new ResourceLocation("thaumcraft:thaumiumplate"));
        ModHandler.removeRecipeByName(new ResourceLocation("thaumcraft:voidplate"));
        ModHandler.addShapedRecipe("thaumium_plate", new ItemStack(ItemsTC.plate, 1, 2), "h", "T", "T", 'T', "ingotThaumium");
        ModHandler.addShapedRecipe("void_plate", new ItemStack(ItemsTC.plate, 1, 3), "h", "V", "V", 'V', "ingotVoid");
        RecipeMaps.FORGE_HAMMER_RECIPES.recipeBuilder()
                .input("ingotThaumium", 3)
                .fluidInputs(new FluidStack[]{Materials.RedAlloy.getFluid(288)})
                .outputs(new ItemStack(ItemsTC.plate, 2, 2))
                .duration(560).EUt(16)
                .buildAndRegister();
        RecipeMaps.FORGE_HAMMER_RECIPES.recipeBuilder()
                .input("ingotVoid", 3)
                .outputs(new ItemStack(ItemsTC.plate, 2, 3))
                .duration(107).EUt(16)
                .buildAndRegister();
    }
}
