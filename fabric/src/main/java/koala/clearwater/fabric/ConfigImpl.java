package koala.clearwater.fabric;

import com.google.gson.GsonBuilder;
import com.mojang.blaze3d.shaders.FogShape;
import dev.isxander.yacl.api.ButtonOption;
import dev.isxander.yacl.api.ConfigCategory;
import dev.isxander.yacl.api.Option;
import dev.isxander.yacl.api.YetAnotherConfigLib;
import dev.isxander.yacl.config.GsonConfigInstance;
import dev.isxander.yacl.gui.controllers.ActionController;
import dev.isxander.yacl.gui.controllers.BooleanController;
import dev.isxander.yacl.gui.controllers.cycling.EnumController;
import dev.isxander.yacl.gui.controllers.slider.FloatSliderController;
import koala.clearwater.ClearWater;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/**
 * @author AlexNijjar
 */

public class ConfigImpl {
    private static GsonConfigInstance<FabricConfig> config;

    public static void init() {
        config = new GsonConfigInstance<>(FabricConfig.class, FabricLoader.getInstance().getConfigDir().resolve(ClearWater.MOD_ID + "-client.json"), GsonBuilder::setPrettyPrinting);
        config.load();
        config.save();
        ConfigImpl.updateConfig();
    }

    public static Screen getModConfigScreenFactory(Screen parent) {
        return config.buildConfig((config, builder) -> builder
                        .title(Component.literal("Clear Water Config"))
                        .category(ConfigCategory.createBuilder()
                                .name(Component.literal("Clear Water Config"))
                                .option(ButtonOption.createBuilder()
                                        .name(Component.literal("Config"))
                                        .controller(ActionController::new)
                                        .action((screen, opt) -> Minecraft.getInstance().setScreen(create(parent)))
                                        .build())
                                .build())
                )
                .generateScreen(parent);
    }

    private static Screen create(Screen parent) {
        return YetAnotherConfigLib.createBuilder()
                .title(Component.literal("Client Settings"))
                .category(ConfigCategory.createBuilder()
                        .name(Component.literal("Water"))
                        .option(Option.createBuilder(boolean.class)
                                .name(Component.literal("Enabled"))
                                .tooltip(Component.literal("Enables modifications of fog under water"))
                                .binding(
                                        config.getDefaults().enableWater,
                                        () -> config.getConfig().enableWater,
                                        newValue -> config.getConfig().enableWater = newValue
                                )
                                .controller(BooleanController::new)
                                .build())
                        .option(Option.createBuilder(float.class)
                                .name(Component.literal("Fog Near Plane"))
                                .tooltip(Component.literal("Value for where fog starts. Vanilla is -8.0"))
                                .binding(
                                        config.getDefaults().fogNearPlaneWater,
                                        () -> config.getConfig().fogNearPlaneWater,
                                        newValue -> config.getConfig().fogNearPlaneWater = newValue
                                )
                                .controller(opt -> new FloatSliderController(opt, -100.0f, 500.0f, 0.05f))
                                .build())
                        .option(Option.createBuilder(float.class)
                                .name(Component.literal("Fog Far Plane"))
                                .tooltip(Component.literal("Value for where fog ends. Vanilla is 96.0"))
                                .binding(
                                        config.getDefaults().fogFarPlaneWater,
                                        () -> config.getConfig().fogFarPlaneWater,
                                        newValue -> config.getConfig().fogFarPlaneWater = newValue
                                )
                                .controller(opt -> new FloatSliderController(opt, -100.0f, 500.0f, 0.05f))
                                .build())
                        .option(Option.createBuilder(boolean.class)
                                .name(Component.literal("Fade in"))
                                .tooltip(Component.literal("When enabled, makes vision fade in like vanilla behavior"))
                                .binding(
                                        config.getDefaults().fadeInWater,
                                        () -> config.getConfig().fadeInWater,
                                        newValue -> config.getConfig().fadeInWater = newValue
                                )
                                .controller(BooleanController::new)
                                .build())
                        .option(Option.createBuilder(FogShape.class)
                                .name(Component.literal("Fog Shape"))
                                .tooltip(Component.literal("The shape of the fog around the player."))
                                .binding(
                                        config.getDefaults().fogShapeWater,
                                        () -> config.getConfig().fogShapeWater,
                                        newValue -> config.getConfig().fogShapeWater = newValue
                                )
                                .controller(EnumController::new)
                                .build())
                        .build())
                .category(ConfigCategory.createBuilder()
                        .name(Component.literal("Lava"))
                        .option(Option.createBuilder(boolean.class)
                                .name(Component.literal("Enabled"))
                                .tooltip(Component.literal("Enables modifications of fog under lava"))
                                .binding(
                                        config.getDefaults().enableLava,
                                        () -> config.getConfig().enableLava,
                                        newValue -> config.getConfig().enableLava = newValue
                                )
                                .controller(BooleanController::new)
                                .build())
                        .option(Option.createBuilder(float.class)
                                .name(Component.literal("Fog Near Plane"))
                                .tooltip(Component.literal("Value for where fog starts. Vanilla is 0.25"))
                                .binding(
                                        config.getDefaults().fogNearPlaneLava,
                                        () -> config.getConfig().fogNearPlaneLava,
                                        newValue -> config.getConfig().fogNearPlaneLava = newValue
                                )
                                .controller(opt -> new FloatSliderController(opt, -100.0f, 500.0f, 0.05f))
                                .build())
                        .option(Option.createBuilder(float.class)
                                .name(Component.literal("Fog Far Plane"))
                                .tooltip(Component.literal("Value for where fog ends. Vanilla is 1.0"))
                                .binding(
                                        config.getDefaults().fogFarPlaneLava,
                                        () -> config.getConfig().fogFarPlaneLava,
                                        newValue -> config.getConfig().fogFarPlaneLava = newValue
                                )
                                .controller(opt -> new FloatSliderController(opt, -100.0f, 500.0f, 0.05f))
                                .build())
                        .option(Option.createBuilder(FogShape.class)
                                .name(Component.literal("Fog Shape"))
                                .tooltip(Component.literal("The shape of the fog around the player."))
                                .binding(
                                        config.getDefaults().fogShapeLava,
                                        () -> config.getConfig().fogShapeLava,
                                        newValue -> config.getConfig().fogShapeLava = newValue
                                )
                                .controller(EnumController::new)
                                .build())
                        .build())
                .category(ConfigCategory.createBuilder()
                        .name(Component.literal("Powdered Snow"))
                        .option(Option.createBuilder(boolean.class)
                                .name(Component.literal("Enabled"))
                                .tooltip(Component.literal("Enables modifications of fog under powdered snow"))
                                .binding(
                                        config.getDefaults().enablePowderedSnow,
                                        () -> config.getConfig().enablePowderedSnow,
                                        newValue -> config.getConfig().enablePowderedSnow = newValue
                                )
                                .controller(BooleanController::new)
                                .build())
                        .option(Option.createBuilder(float.class)
                                .name(Component.literal("Fog Near Plane"))
                                .tooltip(Component.literal("Value for where fog starts. Vanilla is 0.0"))
                                .binding(
                                        config.getDefaults().fogNearPlaneSnow,
                                        () -> config.getConfig().fogNearPlaneSnow,
                                        newValue -> config.getConfig().fogNearPlaneSnow = newValue
                                )
                                .controller(opt -> new FloatSliderController(opt, -100.0f, 500.0f, 0.05f))
                                .build())
                        .option(Option.createBuilder(float.class)
                                .name(Component.literal("Fog Far Plane"))
                                .tooltip(Component.literal("Value for where fog ends. Vanilla is 2.0"))
                                .binding(
                                        config.getDefaults().fogFarPlaneSnow,
                                        () -> config.getConfig().fogFarPlaneSnow,
                                        newValue -> config.getConfig().fogFarPlaneSnow = newValue
                                )
                                .controller(opt -> new FloatSliderController(opt, -100.0f, 500.0f, 0.05f))
                                .build())
                        .option(Option.createBuilder(FogShape.class)
                                .name(Component.literal("Fog Shape"))
                                .tooltip(Component.literal("The shape of the fog around the player."))
                                .binding(
                                        config.getDefaults().fogShapeSnow,
                                        () -> config.getConfig().fogShapeSnow,
                                        newValue -> config.getConfig().fogShapeSnow = newValue
                                )
                                .controller(EnumController::new)
                                .build())
                        .build())
                .save(() -> {
                    config.save();
                    updateConfig();
                })
                .build()
                .generateScreen(parent);
    }

    public static void updateConfig() {
        ClearWater.CONFIG.enableWater = config.getConfig().enableWater;
        ClearWater.CONFIG.fogNearPlaneWater = config.getConfig().fogNearPlaneWater;
        ClearWater.CONFIG.fogFarPlaneWater = config.getConfig().fogFarPlaneWater;
        ClearWater.CONFIG.fadeInWater = config.getConfig().fadeInWater;
        ClearWater.CONFIG.fogShapeWater = config.getConfig().fogShapeWater;
        ClearWater.CONFIG.enableLava = config.getConfig().enableLava;
        ClearWater.CONFIG.fogNearPlaneLava = config.getConfig().fogNearPlaneLava;
        ClearWater.CONFIG.fogFarPlaneLava = config.getConfig().fogFarPlaneLava;
        ClearWater.CONFIG.fogShapeLava = config.getConfig().fogShapeLava;
        ClearWater.CONFIG.enablePowderedSnow = config.getConfig().enablePowderedSnow;
        ClearWater.CONFIG.fogNearPlaneSnow = config.getConfig().fogNearPlaneSnow;
        ClearWater.CONFIG.fogFarPlaneSnow = config.getConfig().fogFarPlaneSnow;
        ClearWater.CONFIG.fogShapeSnow = config.getConfig().fogShapeSnow;
    }
}
