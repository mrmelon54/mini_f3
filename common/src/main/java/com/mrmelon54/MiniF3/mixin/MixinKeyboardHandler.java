package com.mrmelon54.MiniF3.mixin;

import com.mrmelon54.MiniF3.MiniF3;
import net.minecraft.Util;
import net.minecraft.client.KeyboardHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(KeyboardHandler.class)
public abstract class MixinKeyboardHandler {
    @Shadow
    private long debugCrashKeyTime;

    @Inject(method = "handleDebugKeys", at = @At("HEAD"), cancellable = true)
    private void injectedHandleDebugKeys(int key, CallbackInfoReturnable<Boolean> cir) {
        if (debugCrashKeyTime > 0L && debugCrashKeyTime < Util.getMillis() - 100L)
            cir.setReturnValue(true);
        else if (key == 72) {
            MiniF3.setShowRotationData(!MiniF3.isShowRotationData());
            cir.setReturnValue(true);
        }
    }
}
