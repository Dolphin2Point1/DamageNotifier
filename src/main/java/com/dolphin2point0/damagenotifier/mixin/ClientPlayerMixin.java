package com.dolphin2point0.damagenotifier.mixin;

import com.dolphin2point0.damagenotifier.mixin.accessor.MinecraftClientAccessor;
import com.dolphin2point0.damagenotifier.mixin.accessor.WindowAccessor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.Window;
import net.minecraft.entity.damage.DamageSource;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(ClientPlayerEntity.class)
public class ClientPlayerMixin {
    @Inject(method = "damage", at = @At("HEAD"))
    public void onDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        MinecraftClient client = MinecraftClient.getInstance();
        Window window = ((MinecraftClientAccessor) client).getWindow();
        GLFW.glfwRequestWindowAttention(((WindowAccessor) (Object) window).getHandle());
    }
}
