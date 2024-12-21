package koala.clearwater;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import com.teamresourceful.resourcefulconfig.api.loader.Configurator;
import com.teamresourceful.resourcefulconfig.common.config.Configurations;
import net.minecraft.client.Camera;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.material.FogType;

import java.util.Arrays;
import java.util.function.Consumer;

public class ClearWater {
    public static final String MOD_ID = "clearwater";
    public static final Configurator CONFIGURATOR = new Configurator(MOD_ID);
    

    public static void init() {
        CONFIGURATOR.register(ClearWaterConfig.class);
    }
    
    public static boolean handleFog(Camera camera, Consumer<Float> fogStartConsumer, Consumer<Float> fogEndConsumer, Consumer<FogShape> fogShapeConsumer) {
        return switch (camera.getFluidInCamera()) {
            case WATER -> {
                if (ClearWaterConfig.WaterConfig.enableWater) {
                    float waterVision = camera.getEntity() instanceof LocalPlayer player && ClearWaterConfig.WaterConfig.fadeInWater ? Math.max(0.25f, player.getWaterVision()) : 1.0f;
                    float farPlane = Math.max(ClearWaterConfig.WaterConfig.fogNearPlaneWater, ClearWaterConfig.WaterConfig.fogFarPlaneWater * waterVision);
                    if (camera.getEntity() instanceof LocalPlayer player && player.level().getBiome(player.blockPosition()).is(BiomeTags.HAS_CLOSER_WATER_FOG)) {
                        farPlane *= 0.85F;
                    }
                    fogStartConsumer.accept(ClearWaterConfig.WaterConfig.fogNearPlaneWater);
                    fogEndConsumer.accept(farPlane);
                    fogShapeConsumer.accept(ClearWaterConfig.WaterConfig.fogShapeWater);
                    yield true;
                }
                yield false;
            }
            case LAVA -> {
                if (ClearWaterConfig.LavaConfig.enableLava) {
                    fogStartConsumer.accept(ClearWaterConfig.LavaConfig.fogNearPlaneLava);
                    fogEndConsumer.accept(ClearWaterConfig.LavaConfig.fogFarPlaneLava);
                    fogShapeConsumer.accept(ClearWaterConfig.LavaConfig.fogShapeLava);
                    yield true;
                }
                yield false;
            }
            case POWDER_SNOW -> {
                if (ClearWaterConfig.PowderedSnowConfig.enablePowderedSnow) {
                    fogStartConsumer.accept(ClearWaterConfig.PowderedSnowConfig.fogNearPlaneSnow);
                    fogEndConsumer.accept(ClearWaterConfig.PowderedSnowConfig.fogFarPlaneSnow);
                    fogShapeConsumer.accept(ClearWaterConfig.PowderedSnowConfig.fogShapeSnow);
                    yield true;
                }
                yield false;
            }
            case NONE -> false;
        };
    }
}