package koala.clearwater;

import com.mojang.blaze3d.systems.RenderSystem;
import com.teamresourceful.resourcefulconfig.common.config.Configurator;
import net.minecraft.client.Camera;
import net.minecraft.client.player.LocalPlayer;

public class ClearWater {
    public static final String MOD_ID = "clearwater";
    public static final Configurator CONFIGURATOR = new Configurator();
    

    public static void init() {
        CONFIGURATOR.registerConfig(ClearWaterConfig.class);
    }
    
    public static boolean handleFog(Camera camera) {
        return switch (camera.getFluidInCamera()) {
            case WATER -> {
                if (ClearWaterConfig.WaterConfig.enableWater) {
                    float waterVision = camera.getEntity() instanceof LocalPlayer player ? Math.max(0.25f, player.getWaterVision()) : 1.0f;
                    RenderSystem.setShaderFogStart(ClearWaterConfig.WaterConfig.fogNearPlaneWater);
                    RenderSystem.setShaderFogEnd(ClearWaterConfig.WaterConfig.fogFarPlaneWater * waterVision);
                    RenderSystem.setShaderFogShape(ClearWaterConfig.WaterConfig.fogShapeWater);
                    yield true;
                }
                yield false;
            }
            case LAVA -> {
                if (ClearWaterConfig.LavaConfig.enableLava) {
                    RenderSystem.setShaderFogStart(ClearWaterConfig.LavaConfig.fogNearPlaneLava);
                    RenderSystem.setShaderFogEnd(ClearWaterConfig.LavaConfig.fogFarPlaneLava);
                    RenderSystem.setShaderFogShape(ClearWaterConfig.LavaConfig.fogShapeLava);
                    yield true;
                }
                yield false;
            }
            case POWDER_SNOW -> {
                if (ClearWaterConfig.PowderedSnowConfig.enablePowderedSnow) {
                    RenderSystem.setShaderFogStart(ClearWaterConfig.PowderedSnowConfig.fogNearPlaneSnow);
                    RenderSystem.setShaderFogEnd(ClearWaterConfig.PowderedSnowConfig.fogFarPlaneSnow);
                    RenderSystem.setShaderFogShape(ClearWaterConfig.PowderedSnowConfig.fogShapeSnow);
                    yield true;
                }
                yield false;
            }
            case NONE -> false;
        };
    }
}