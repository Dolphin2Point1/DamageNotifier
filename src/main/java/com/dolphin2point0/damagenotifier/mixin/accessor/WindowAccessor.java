package com.dolphin2point0.damagenotifier.mixin.accessor;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.util.Window;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Environment(EnvType.CLIENT)
@Mixin(Window.class)
public interface WindowAccessor {
    @Accessor("handle")
    long getHandle();
}
