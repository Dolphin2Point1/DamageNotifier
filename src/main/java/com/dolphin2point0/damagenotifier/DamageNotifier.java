package com.dolphin2point0.damagenotifier;

import com.dolphin2point0.damagenotifier.mixin.accessor.MinecraftClientAccessor;
import com.dolphin2point0.damagenotifier.mixin.accessor.WindowAccessor;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowFocusCallbackI;

@Environment(EnvType.CLIENT)
public class DamageNotifier implements ClientModInitializer, GLFWWindowFocusCallbackI {
    public static DamageNotifier instance;
    public boolean windowState = true;

    @Override
    public void onInitializeClient() {
        instance = this;
        MinecraftClient client = MinecraftClient.getInstance();
        Window window = ((MinecraftClientAccessor) client).getWindow();
        long handle = ((WindowAccessor) (Object) window).getHandle();
        GLFW.glfwSetWindowFocusCallback(handle, this);
    }

    @Override
    public void invoke(long window, boolean focused) {
        windowState = focused;
    }
}
