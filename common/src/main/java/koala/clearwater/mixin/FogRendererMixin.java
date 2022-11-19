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
        boolean cancel = switch (camera.getFluidInCamera()) {
            case WATER -> {
                if (ClearWater.CONFIG.enableWater) {
                    float waterVision = camera.getEntity() instanceof LocalPlayer player ? Math.max(0.25f, player.getWaterVision()) : 1.0f;
                    RenderSystem.setShaderFogStart(ClearWater.CONFIG.fogNearPlaneWater);
                    RenderSystem.setShaderFogEnd(ClearWater.CONFIG.fogFarPlaneWater * waterVision);
                    RenderSystem.setShaderFogShape(ClearWater.CONFIG.fogShapeWater);
                    yield true;
                }
                yield false;
            }
            case LAVA -> {
                if (ClearWater.CONFIG.enableLava) {
                    RenderSystem.setShaderFogStart(ClearWater.CONFIG.fogNearPlaneLava);
                    RenderSystem.setShaderFogEnd(ClearWater.CONFIG.fogFarPlaneLava);
                    RenderSystem.setShaderFogShape(ClearWater.CONFIG.fogShapeLava);
                    yield true;
                }
                yield false;
            }
            case POWDER_SNOW -> {
                if (ClearWater.CONFIG.enablePowderedSnow) {
                    RenderSystem.setShaderFogStart(ClearWater.CONFIG.fogNearPlaneSnow);
                    RenderSystem.setShaderFogEnd(ClearWater.CONFIG.fogFarPlaneSnow);
                    RenderSystem.setShaderFogShape(ClearWater.CONFIG.fogShapeSnow);
                    yield true;
                }
                yield false;
            }
            case NONE -> false;
        };
        if (cancel) {
            ci.cancel();
        }
    }
}
