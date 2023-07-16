package com.github.largeessentiagenerator.proxy;

import com.github.largeessentiagenerator.common.gregtech.MetaEntities;
import com.github.largeessentiagenerator.common.gregtech.tileentity.EssentiaHatch;
import com.github.largeessentiagenerator.common.item.itemUpgrade;
import com.github.largeessentiagenerator.common.thaumcraft.LargeEssentiaEnergyData;
import gregtech.api.block.VariantItemBlock;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Function;

import static com.github.largeessentiagenerator.common.gregtech.CommonBlocks.ESSENTIA_HATCH;
import static com.github.largeessentiagenerator.common.gregtech.EGMetaBlocks.EG_BLOCK_CASING;
import static com.github.largeessentiagenerator.common.gregtech.EGMetaBlocks.EG_ESSENTIA_CELL;

public class CommonProxy {

    public static Item Upgrades = new itemUpgrade();

    public static final CreativeTabs Tab = new CreativeTabs("largeessentiagenerator") {
        @Override
        @Nonnull
        public ItemStack createIcon() {
            return new ItemStack(Upgrades, 1, 1);
        }
    };

    public void preInit( FMLPreInitializationEvent event ) {
        MetaEntities.register();
        LargeEssentiaEnergyData.processEssentiaData();
    }

    public void init( FMLInitializationEvent event ) {
    }

    public void registerItems(RegistryEvent.Register<Item> event) {
        Upgrades.setCreativeTab(Tab);
        event.getRegistry().register(Upgrades);
        event.getRegistry().register(createItemBlock(EG_BLOCK_CASING, VariantItemBlock::new));
        event.getRegistry().register(createItemBlock(EG_ESSENTIA_CELL, VariantItemBlock::new));
        event.getRegistry().register(createItemBlock(ESSENTIA_HATCH, ItemBlock::new));
    }

    public void registerBlocks(RegistryEvent.Register<Block> event) {
        EG_BLOCK_CASING.setCreativeTab(Tab);
        ESSENTIA_HATCH.setCreativeTab(Tab);
        EG_ESSENTIA_CELL.setCreativeTab(Tab);
        event.getRegistry().register(EG_BLOCK_CASING);
        event.getRegistry().register(EG_ESSENTIA_CELL);
        event.getRegistry().register(ESSENTIA_HATCH);
        GameRegistry.registerTileEntity(EssentiaHatch.class, "essentia_hatch");
    }

    public void onModelRegister() {

    }

    private static <T extends Block> ItemBlock createItemBlock(@Nonnull T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
        return itemBlock;
    }
}
