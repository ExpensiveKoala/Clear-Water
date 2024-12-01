package koala.clearwater.fabric;

import koala.clearwater.ClearWater;
import net.fabricmc.api.ClientModInitializer;

public class ClearWaterFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClearWater.init();
    }
}