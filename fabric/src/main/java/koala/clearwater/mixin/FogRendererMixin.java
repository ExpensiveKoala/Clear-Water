package koala.clearwater.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import koala.clearwater.ClearWater;
import koala.clearwater.ClearWaterConfig;
import net.minecraft.client.Camera;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.FogRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FogRenderer.class)
public abstract class FogRendererMixin {
    @Inject(method = "setupFog", at = @At("HEAD"), cancellable = true)
    private static void clearwater_setupFog(Camera camera, FogRenderer.FogMode fogMode, float farPlaneDistance, boolean bl, float f, CallbackInfo ci) {
        if (ClearWater.handleFog(camera, RenderSystem::setShaderFogStart, RenderSystem::setShaderFogEnd, RenderSystem::setShaderFogShape)) {
            ci.cancel();
        }
    }
}
