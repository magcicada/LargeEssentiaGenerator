package com.github.largeessentiagenerator.client;

import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;

public class Textures {

    public static SimpleOverlayRenderer MAGIC_CASING;
    public static OrientedOverlayRenderer LARGE_ESSENTIA_GENERATOR;
    
    public static void preInit() {
        MAGIC_CASING = new SimpleOverlayRenderer("magic_machine_casing");
        LARGE_ESSENTIA_GENERATOR = new OrientedOverlayRenderer("multiblock/large_essentia_generator");
    }

}
