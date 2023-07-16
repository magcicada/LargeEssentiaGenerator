package com.github.largeessentiagenerator;

import com.github.largeessentiagenerator.common.gregtech.materials.EGMaterial;
import com.github.largeessentiagenerator.util.libs.Refstrings;
import gregtech.api.unification.material.event.MaterialEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Refstrings.MODID)
public class GTMEventHandler {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onMaterialsInit(MaterialEvent event) {
        EGMaterial.register();
    }

}
