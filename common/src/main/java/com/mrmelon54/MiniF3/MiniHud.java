package com.mrmelon54.MiniF3;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.DebugScreenOverlay;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MiniHud {
    public static void render(GuiGraphics guiGraphics, Minecraft mc) {
        List<String> l = new ArrayList<>();
        Entity cameraEntity = mc.getCameraEntity();
        if (cameraEntity != null) {
            BlockPos pos = cameraEntity.getOnPos();
            String a = String.format(Locale.ROOT, "Block: %d %d %d", pos.getX(), pos.getY(), pos.getZ());
            if (MiniF3.isShowRotationData()) {
                a += String.format(Locale.ROOT, " | (%.1f / %.1f)", Mth.wrapDegrees(cameraEntity.getYRot()), Mth.wrapDegrees(cameraEntity.getXRot()));
                if (mc.level != null)
                    a += String.format(" | E: %d/%d", mc.levelRenderer.renderedEntities, mc.level.getEntityCount());
            }
            l.add(a);
        }

        new DebugScreenOverlay(mc).renderLines(guiGraphics, l, true);
    }
}
