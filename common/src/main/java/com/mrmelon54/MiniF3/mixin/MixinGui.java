package com.mrmelon54.MiniF3.mixin;

import com.mrmelon54.MiniF3.MiniHud;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.DebugScreenOverlay;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public class MixinGui {
    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Gui;renderEffects(Lnet/minecraft/client/gui/GuiGraphics;)V"))
    private void renderInjected(GuiGraphics guiGraphics, float f, CallbackInfo ci) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.options.renderDebug) MiniHud.render(guiGraphics, mc);
    }

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/components/DebugScreenOverlay;render(Lnet/minecraft/client/gui/GuiGraphics;)V"))
    private void debugHudRenderInjected(DebugScreenOverlay instance, GuiGraphics guiGraphics) {
    }

    @Redirect(method = "renderCrosshair", at = @At(value = "FIELD", target = "Lnet/minecraft/client/Options;renderDebug:Z", opcode = Opcodes.GETFIELD))
    private boolean forceRenderNormalCrosshair(Options instance) {
        return false;
    }
}
