package koala.clearwater.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import koala.clearwater.ClearWater;
import koala.clearwater.ClearWaterConfig;
import koala.clearwater.fabric.FogParams;
import net.minecraft.client.Camera;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.FogParameters;
import net.minecraft.client.renderer.FogRenderer;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FogRenderer.class)
public abstract class FogRendererMixin {
    
    @Inject(method = "setupFog", at = @At(value = "RETURN", ordinal = 1), cancellable = true)
    private static void clearwater_setupFog(Camera camera, FogRenderer.FogMode fogMode, Vector4f fogColor, float renderDistance, boolean isFoggy, float partialTick, CallbackInfoReturnable<FogParameters> cir) {
        FogParams params = new FogParams();
        if (ClearWater.handleFog(camera, params::setNearPlaneDistance, params::setFarPlaneDistance, params::setFogShape)) {
            cir.setReturnValue(new FogParameters(params.getNearPlaneDistance(), params.getFarPlaneDistance(), params.getFogShape(), fogColor.x, fogColor.y, fogColor.z, fogColor.w));
        }
    }
}
