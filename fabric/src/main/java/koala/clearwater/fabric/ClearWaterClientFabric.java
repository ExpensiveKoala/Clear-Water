package koala.clearwater.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class ClearWaterClientFabric implements ClientModInitializer {
    public void onInitializeClient() {
        if (FabricLoader.getInstance().isModLoaded("yet-another-config-lib")) {
            ConfigImpl.init();
        }
    }
}
