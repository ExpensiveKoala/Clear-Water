package koala.clearwater;


import com.teamresourceful.resourcefulconfig.common.annotations.Category;
import com.teamresourceful.resourcefulconfig.common.annotations.Comment;
import com.teamresourceful.resourcefulconfig.common.annotations.Config;
import com.mojang.blaze3d.shaders.FogShape;
import com.teamresourceful.resourcefulconfig.common.annotations.ConfigEntry;
import com.teamresourceful.resourcefulconfig.common.config.EntryType;

@Config("clearwater")
public final class ClearWaterConfig {
    
    @Category(id = "waterConfig", translation = "text.resourcefulconfig.clearwater.category.water")
    public static final class WaterConfig {
        @ConfigEntry(
          id = "enableWater",
          type = EntryType.BOOLEAN,
          translation = "text.resourcefulconfig.clearwater.option.enableWater"
        )
        @Comment(value = "Enables modifications of fog under water", translation = "text.resourcefulconfig.clearwater.option.enableWater.tooltip")
        public static boolean enableWater = true;
    
        @ConfigEntry(
          id = "fogNearPlaneWater",
          type = EntryType.FLOAT,
          translation = "text.resourcefulconfig.clearwater.option.fogNearPlaneWater"
        )
        @Comment(value = "Value for where fog starts. Vanilla is -8.0", translation = "text.resourcefulconfig.clearwater.option.fogNearPlaneWater.tooltip")
        public static float fogNearPlaneWater = -8.0f;
        
        @ConfigEntry(
          id = "fogFarPlaneWater",
          type = EntryType.FLOAT,
          translation = "text.resourcefulconfig.clearwater.option.fogFarPlaneWater"
        )
        @Comment(value = "Value for where fog ends. Vanilla is 96.0", translation = "text.resourcefulconfig.clearwater.option.fogFarPlaneWater.tooltip")
        public static float fogFarPlaneWater = 250.0f;
    
        @ConfigEntry(
          id = "fadeInWater",
          type = EntryType.BOOLEAN,
          translation = "text.resourcefulconfig.clearwater.option.fadeInWater"
        )
        @Comment(value = "When enabled, makes vision fade in like vanilla behavior", translation = "text.resourcefulconfig.clearwater.option.fadeInWater.tooltip")
        public static boolean fadeInWater = true;
        
        @ConfigEntry(
          id = "fogShapeWater",
          type = EntryType.ENUM,
          translation = "text.resourcefulconfig.clearwater.option.fogShapeWater"
        )
        @Comment(value = "The shape of the fog around the player", translation = "text.resourcefulconfig.clearwater.option.fogShapeWater.tooltip")
        public static FogShape fogShapeWater = FogShape.CYLINDER;
    }
    
    @Category(id = "lavaConfig", translation = "text.resourcefulconfig.clearwater.category.lava")
    public static final class LavaConfig {
        @ConfigEntry(
          id = "enableLava",
          type = EntryType.BOOLEAN,
          translation = "text.resourcefulconfig.clearwater.option.enableLava"
        )
        @Comment(value = "Enables modifications of fog under lava", translation = "text.resourcefulconfig.clearwater.option.enableLava.tooltip")
        public static boolean enableLava = true;
    
        @ConfigEntry(
          id = "fogNearPlaneLava",
          type = EntryType.FLOAT,
          translation = "text.resourcefulconfig.clearwater.option.fogNearPlaneLava"
        )
        @Comment(value = "Value for where fog starts. Vanilla is 0.25", translation = "text.resourcefulconfig.clearwater.option.fogNearPlaneLava.tooltip")
        public static float fogNearPlaneLava = 0.0f;
    
        @ConfigEntry(
          id = "fogFarPlaneLava",
          type = EntryType.FLOAT,
          translation = "text.resourcefulconfig.clearwater.option.fogFarPlaneLava"
        )
        @Comment(value = "Value for where fog ends. Vanilla is 1.0", translation = "text.resourcefulconfig.clearwater.option.fogFarPlaneLava.tooltip")
        public static float fogFarPlaneLava = 10.0f;
    
        @ConfigEntry(
          id = "fogShapeLava",
          type = EntryType.ENUM,
          translation = "text.resourcefulconfig.clearwater.option.fogShapeLava"
        )
        @Comment(value = "The shape of the fog around the player", translation = "text.resourcefulconfig.clearwater.option.fogShapeLava.tooltip")
        public static FogShape fogShapeLava = FogShape.SPHERE;
    }
    
    @Category(id = "powderedSnowConfig", translation = "text.resourcefulconfig.clearwater.category.powderedSnow")
    public static final class PowderedSnowConfig {
        @ConfigEntry(
          id = "enablePowderedSnow",
          type = EntryType.BOOLEAN,
          translation = "text.resourcefulconfig.clearwater.option.enablePowderedSnow"
        )
        @Comment(value = "Enables modifications of fog under powdered snow", translation = "text.resourcefulconfig.clearwater.option.enablePowderedSnow.tooltip")
        public static boolean enablePowderedSnow = true;
    
        @ConfigEntry(
          id = "fogNearPlaneSnow",
          type = EntryType.FLOAT,
          translation = "text.resourcefulconfig.clearwater.option.fogNearPlaneSnow"
        )
        @Comment(value = "Value for where fog starts. Vanilla is 0.0", translation = "text.resourcefulconfig.clearwater.option.fogNearPlaneSnow.tooltip")
        public static float fogNearPlaneSnow = 0.0f;
    
        @ConfigEntry(
          id = "fogFarPlaneSnow",
          type = EntryType.FLOAT,
          translation = "text.resourcefulconfig.clearwater.option.fogFarPlaneSnow"
        )
        @Comment(value = "Value for where fog ends. Vanilla is 2.0", translation = "text.resourcefulconfig.clearwater.option.fogFarPlaneSnow.tooltip")
        public static float fogFarPlaneSnow = 6.0f;
    
        @ConfigEntry(
          id = "fogShapeSnow",
          type = EntryType.ENUM,
          translation = "text.resourcefulconfig.clearwater.option.fogShapeSnow"
        )
        @Comment(value = "The shape of the fog around the player", translation = "text.resourcefulconfig.clearwater.option.fogShapeSnow.tooltip")
        public static FogShape fogShapeSnow = FogShape.SPHERE;
    }
}
