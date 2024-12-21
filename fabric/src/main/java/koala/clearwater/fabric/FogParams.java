package koala.clearwater.fabric;

import com.mojang.blaze3d.shaders.FogShape;

public class FogParams {
    private float farPlaneDistance;
    private float nearPlaneDistance;
    private FogShape fogShape;
    
    public FogParams() {
        this(Float.MAX_VALUE, 0.0f, FogShape.SPHERE);
    }
    
    public FogParams(float farPlaneDistance, float nearPlaneDistance, FogShape fogShape) {
        this.farPlaneDistance = farPlaneDistance;
        this.nearPlaneDistance = nearPlaneDistance;
        this.fogShape = fogShape;
    }
    
    public float getFarPlaneDistance() {
        return farPlaneDistance;
    }
    
    public void setFarPlaneDistance(float farPlaneDistance) {
        this.farPlaneDistance = farPlaneDistance;
    }
    
    public float getNearPlaneDistance() {
        return nearPlaneDistance;
    }
    
    public void setNearPlaneDistance(float nearPlaneDistance) {
        this.nearPlaneDistance = nearPlaneDistance;
    }
    
    public FogShape getFogShape() {
        return fogShape;
    }
    
    public void setFogShape(FogShape fogShape) {
        this.fogShape = fogShape;
    }
}
