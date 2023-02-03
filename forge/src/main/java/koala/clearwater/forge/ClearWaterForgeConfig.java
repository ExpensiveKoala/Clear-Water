package koala.clearwater.forge;

import com.teamresourceful.resourcefulconfig.client.ConfigScreen;
import com.teamresourceful.resourcefulconfig.common.config.ResourcefulConfig;
import koala.clearwater.ClearWater;
import koala.clearwater.ClearWaterConfig;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.fml.ModLoadingContext;

public class ClearWaterForgeConfig {
    public static void register() {
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class,
          () -> new ConfigScreenHandler.ConfigScreenFactory((client, parent) -> {
              ResourcefulConfig config = ClearWater.CONFIGURATOR.getConfig(ClearWaterConfig.class);
              return config == null ? null : new ConfigScreen(null, config);
          })
        );
    }
}
