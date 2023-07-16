package com.github.largeessentiagenerator.proxy;

import com.github.largeessentiagenerator.client.Textures;
import com.github.largeessentiagenerator.common.gregtech.CommonBlocks;
import com.github.largeessentiagenerator.common.gregtech.EGMetaBlocks;
import com.github.largeessentiagenerator.common.item.itemUpgrade;
import com.github.largeessentiagenerator.util.libs.Refstrings;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    public void preInit( FMLPreInitializationEvent event ) {
        super.preInit(event);
        Textures.preInit();
    }

    public void init( FMLInitializationEvent event ) {
        super.init(event);
    }

    public void onModelRegister() {
        EGMetaBlocks.registerItemModels();
        CommonBlocks.registerItemModels();
        for (int i = 0; i < itemUpgrade.ListUpgrade.length; i++)
            ModelLoader.setCustomModelResourceLocation(Upgrades, i, new ModelResourceLocation(Refstrings.MODID + ":" + itemUpgrade.ListUpgrade[i] + "_upgrade", "inventory"));
    }
}