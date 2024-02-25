package koala.clearwater.forge;

import koala.clearwater.ClearWater;
import net.neoforged.neoforge.client.event.ViewportEvent;
import net.neoforged.neoforge.common.NeoForge;

public class ClearWaterForgeClient {
    public static void init() {
        ClearWaterForgeConfig.register();
        NeoForge.EVENT_BUS.addListener(ClearWaterForgeClient::onRenderFog);
    }
    
    public static void onRenderFog(ViewportEvent.RenderFog event) {
        if (ClearWater.handleFog(event.getCamera(), event::setNearPlaneDistance, event::setFarPlaneDistance, event::setFogShape)) {
            event.setCanceled(true);
        }
    }
}
