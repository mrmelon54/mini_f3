package com.mrmelon54.MiniF3.forge;

import dev.architectury.platform.forge.EventBuses;
import com.mrmelon54.MiniF3.MiniF3;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MiniF3.MOD_ID)
public class MiniF3Forge {
    public MiniF3Forge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(MiniF3.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        MiniF3.init();
    }
}
