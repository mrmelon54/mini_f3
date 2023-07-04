package com.mrmelon54.MiniF3.quilt;

import com.mrmelon54.MiniF3.fabriclike.MiniF3FabricLike;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class MiniF3Quilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        MiniF3FabricLike.init();
    }
}
