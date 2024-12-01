package koala.clearwater.forge;

import com.teamresourceful.resourcefulconfig.api.types.ResourcefulConfig;
import com.teamresourceful.resourcefulconfig.client.ConfigScreen;
import koala.clearwater.ClearWater;
import koala.clearwater.ClearWaterConfig;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

public class ClearWaterForgeConfig {
    public static void register() {
        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class,
          () -> (client, parent) -> {
              ResourcefulConfig config = ClearWater.CONFIGURATOR.getConfig(ClearWaterConfig.class);
              return config == null ? null : new ConfigScreen(null, config);
          }
        );
    }
}
