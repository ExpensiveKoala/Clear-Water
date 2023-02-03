package koala.clearwater;

import com.mojang.blaze3d.shaders.FogShape;

public class Config {
    // Water
    public boolean enableWater = true;

    public float fogNearPlaneWater = 8.0f;

    public float fogFarPlaneWater = 250.0f;

    public boolean fadeInWater = true;

    public FogShape fogShapeWater = FogShape.CYLINDER;

    // Lava
    public boolean enableLava = true;

    public float fogNearPlaneLava = 0.25f;

    public float fogFarPlaneLava = 10.0f;

    public FogShape fogShapeLava = FogShape.SPHERE;

    // Powdered Snow
    public boolean enablePowderedSnow = true;

    public float fogNearPlaneSnow = 0.0f;

    public float fogFarPlaneSnow = 6.0f;

    public FogShape fogShapeSnow = FogShape.SPHERE;
}
