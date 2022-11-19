package koala.clearwater.forge;

import com.mojang.blaze3d.shaders.FogShape;
import koala.clearwater.ClearWater;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import org.apache.commons.lang3.tuple.Pair;

/**
 * @author ExpensiveKoala
 */

public class ConfigImpl {


    public static class Client {

        // Water
        public final ForgeConfigSpec.BooleanValue enableWater;

        public final ForgeConfigSpec.DoubleValue fogNearPlaneWater;

        public final ForgeConfigSpec.DoubleValue fogFarPlaneWater;

        public final ForgeConfigSpec.BooleanValue fadeInWater;

        public final ForgeConfigSpec.EnumValue<FogShape> fogShapeWater;

        // Lava
        public final ForgeConfigSpec.BooleanValue enableLava;

        public final ForgeConfigSpec.DoubleValue fogNearPlaneLava;

        public final ForgeConfigSpec.DoubleValue fogFarPlaneLava;

        public final ForgeConfigSpec.EnumValue<FogShape> fogShapeLava;

        // Powdered Snow
        public final ForgeConfigSpec.BooleanValue enablePowderedSnow;

        public final ForgeConfigSpec.DoubleValue fogNearPlaneSnow;

        public final ForgeConfigSpec.DoubleValue fogFarPlaneSnow;

        public final ForgeConfigSpec.EnumValue<FogShape> fogShapeSnow;

        Client(ForgeConfigSpec.Builder builder) {
            builder.comment("Client Settings")
                    .push("client");

            enableWater = builder
                    .comment("Enables modifications of fog under water")
                    .translation("")
                    .define("enableWater", true);

            fogNearPlaneWater = builder
                    .comment("Value for where fog starts. Vanilla is -8.0")
                    .translation("")
                    .defineInRange("fogNearPlaneWater", -8.0, -100, 500);

            fogFarPlaneWater = builder
                    .comment("Value for where fog ends. Vanilla is 96.0")
                    .translation("")
                    .defineInRange("fogFarPlaneWater", 250.0, -100, 500);

            fadeInWater = builder
                    .comment("When enabled, makes vision fade in like vanilla behavior")
                    .translation("")
                    .define("fadeInWater", true);

            fogShapeWater = builder
                    .comment("The shape of the fog around the player.")
                    .translation("")
                    .defineEnum("fogShapeWater", FogShape.CYLINDER);

            enableLava = builder
                    .comment("Enables modifications of fog under lava")
                    .translation("")
                    .define("enableLava", true);

            fogNearPlaneLava = builder
                    .comment("Value for where fog starts. Vanilla is 0.25")
                    .translation("")
                    .defineInRange("fogNearPlaneLava", 0.0, -100, 500);

            fogFarPlaneLava = builder
                    .comment("Value for where fog ends. Vanilla is 1.0")
                    .translation("")
                    .defineInRange("fogFarPlaneLava", 10.0, -100, 500);

            fogShapeLava = builder
                    .comment("The shape of the fog around the player.")
                    .translation("")
                    .defineEnum("fogShapeLava", FogShape.SPHERE);

            enablePowderedSnow = builder
                    .comment("Enables modifications of fog under powdered snow")
                    .translation("")
                    .define("enablePowderedSnow", true);

            fogNearPlaneSnow = builder
                    .comment("Value for where fog starts. Vanilla is 0.0")
                    .translation("")
                    .defineInRange("fogNearPlaneSnow", 0.0, -100, 500);

            fogFarPlaneSnow = builder
                    .comment("Value for where fog ends. Vanilla is 2.0")
                    .translation("")
                    .defineInRange("fogFarPlaneSnow", 6.0, -100, 500);

            fogShapeSnow = builder
                    .comment("The shape of the fog around the player.")
                    .translation("")
                    .defineEnum("fogShapeSnow", FogShape.SPHERE);

            builder.pop();
        }
    }

    static final ForgeConfigSpec clientSpec;
    public static final Client CLIENT;

    static {
        final Pair<Client, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Client::new);
        clientSpec = specPair.getRight();
        CLIENT = specPair.getLeft();
    }

    public static void updateConfig() {
        ClearWater.CONFIG.enableWater = CLIENT.enableWater.get();
        ClearWater.CONFIG.fogNearPlaneWater = CLIENT.fogNearPlaneWater.get().floatValue();
        ClearWater.CONFIG.fogFarPlaneWater = CLIENT.fogFarPlaneWater.get().floatValue();
        ClearWater.CONFIG.fadeInWater = CLIENT.fadeInWater.get();
        ClearWater.CONFIG.fogShapeWater = CLIENT.fogShapeWater.get();
        ClearWater.CONFIG.enableLava = CLIENT.enableLava.get();
        ClearWater.CONFIG.fogNearPlaneLava = CLIENT.fogNearPlaneLava.get().floatValue();
        ClearWater.CONFIG.fogFarPlaneLava = CLIENT.fogFarPlaneLava.get().floatValue();
        ClearWater.CONFIG.fogShapeLava = CLIENT.fogShapeLava.get();
        ClearWater.CONFIG.enablePowderedSnow = CLIENT.enablePowderedSnow.get();
        ClearWater.CONFIG.fogNearPlaneSnow = CLIENT.fogNearPlaneSnow.get().floatValue();
        ClearWater.CONFIG.fogFarPlaneSnow = CLIENT.fogFarPlaneSnow.get().floatValue();
        ClearWater.CONFIG.fogShapeSnow = CLIENT.fogShapeSnow.get();
    }

    public static void onLoad(ModConfigEvent.Loading event) {
        if (event.getConfig().getSpec().self() == ConfigImpl.clientSpec) {
            updateConfig();
        }
    }

    public static void onReload(ModConfigEvent.Reloading event) {
        if (event.getConfig().getSpec().self() == ConfigImpl.clientSpec) {
            updateConfig();
        }
    }
}