package com.mrmelon54.MiniF3.fabric;

import com.mrmelon54.MiniF3.fabriclike.MiniF3FabricLike;
import net.fabricmc.api.ModInitializer;

public class MiniF3Fabric implements ModInitializer {
    @Override
    public void onInitialize() {
        MiniF3FabricLike.init();
    }
}
