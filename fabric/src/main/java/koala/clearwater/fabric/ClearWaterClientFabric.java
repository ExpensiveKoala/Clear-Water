package koala.clearwater.fabric;

import dev.isxander.yacl.config.ConfigInstance;
import dev.isxander.yacl.config.GsonConfigInstance;
import koala.clearwater.ClearWater;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class ClearWaterClientFabric implements ClientModInitializer {
    private static GsonConfigInstance<FabricConfig> config;

    public void onInitializeClient() {
        config = new GsonConfigInstance<>(FabricConfig.class, FabricLoader.getInstance().getConfigDir().resolve(ClearWater.MOD_ID + "-client.json"));
        config.load();
        config.save();
        ConfigImpl.updateConfig();
    }

    public static ConfigInstance<FabricConfig> getConfig() {
        return config;
    }
}
