package koala.clearwater.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import koala.clearwater.ClearWater;
import koala.clearwater.Config;
import net.minecraft.client.Camera;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.world.level.material.FogType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FogRenderer.class)
public abstract class FogRendererMixin {
    @Inject(method = "setupFog", at = @At("HEAD"), cancellable = true)
    private static void clearwater_setupFog(Camera camera, FogRenderer.FogMode fogMode, float farPlaneDistance, boolean bl, float f, CallbackInfo ci) {
        if (ClearWater.CONFIG.enableWater && camera.getFluidInCamera() == FogType.WATER) {
            float waterVision = 1.0f;
            if(camera.getEntity() instanceof LocalPlayer) {
                waterVision = Math.max(0.25f, ((LocalPlayer)camera.getEntity()).getWaterVision());
            }
            RenderSystem.setShaderFogStart(ClearWater.CONFIG.fogNearPlaneWater);
            RenderSystem.setShaderFogEnd(ClearWater.CONFIG.fogFarPlaneWater * waterVision);
            RenderSystem.setShaderFogShape(ClearWater.CONFIG.fogShapeWater);
            ci.cancel();
        } else if (ClearWater.CONFIG.enableLava && camera.getFluidInCamera() == FogType.LAVA) {
            RenderSystem.setShaderFogStart(ClearWater.CONFIG.fogNearPlaneLava);
            RenderSystem.setShaderFogEnd(ClearWater.CONFIG.fogFarPlaneLava);
            RenderSystem.setShaderFogShape(ClearWater.CONFIG.fogShapeLava);
            ci.cancel();
        } else if (ClearWater.CONFIG.enablePowderedSnow && camera.getFluidInCamera() == FogType.POWDER_SNOW) {
            RenderSystem.setShaderFogStart(ClearWater.CONFIG.fogNearPlaneSnow);
            RenderSystem.setShaderFogEnd(ClearWater.CONFIG.fogFarPlaneSnow);
            RenderSystem.setShaderFogShape(ClearWater.CONFIG.fogShapeSnow);
            ci.cancel();
        }
    }
}
