package koala.clearwater.fabric;

import com.teamresourceful.resourcefulconfig.client.ConfigScreen;
import com.teamresourceful.resourcefulconfig.common.config.ResourcefulConfig;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import koala.clearwater.ClearWater;
import koala.clearwater.ClearWaterConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
            return screen -> {
                ResourcefulConfig config = ClearWater.CONFIGURATOR.getConfig(ClearWaterConfig.class);
                return config == null ? null : new ConfigScreen(null, config);
            };
    }
}
