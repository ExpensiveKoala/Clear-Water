package koala.clearwater.fabric;

import koala.clearwater.ClearWater;
import net.fabricmc.api.ModInitializer;

public class ClearWaterFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        ClearWater.init();
    }
}