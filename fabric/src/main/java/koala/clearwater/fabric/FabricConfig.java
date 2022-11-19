package koala.clearwater.fabric;

import com.mojang.blaze3d.shaders.FogShape;
import dev.isxander.yacl.config.ConfigEntry;

public class FabricConfig {
    // Water
    @ConfigEntry
    public boolean enableWater = true;

    @ConfigEntry
    public float fogNearPlaneWater = 8.0f;

    @ConfigEntry
    public float fogFarPlaneWater = 250.0f;

    @ConfigEntry
    public boolean fadeInWater = true;

    @ConfigEntry
    public FogShape fogShapeWater = FogShape.CYLINDER;

    // Lava
    @ConfigEntry
    public boolean enableLava = true;

    @ConfigEntry
    public float fogNearPlaneLava = 0.25f;

    @ConfigEntry
    public float fogFarPlaneLava = 10.0f;

    @ConfigEntry
    public FogShape fogShapeLava = FogShape.SPHERE;

    // Powdered Snow
    @ConfigEntry
    public boolean enablePowderedSnow = true;

    @ConfigEntry
    public float fogNearPlaneSnow = 0.0f;

    @ConfigEntry
    public float fogFarPlaneSnow = 6.0f;

    @ConfigEntry
    public FogShape fogShapeSnow = FogShape.SPHERE;
}
