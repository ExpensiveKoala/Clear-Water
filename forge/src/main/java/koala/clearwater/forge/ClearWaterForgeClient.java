package koala.clearwater.forge;

import koala.clearwater.ClearWater;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.common.MinecraftForge;

public class ClearWaterForgeClient {
    public static void init() {
        ClearWaterForgeConfig.register();
        MinecraftForge.EVENT_BUS.addListener(ClearWaterForgeClient::onRenderFog);
    }
    
    public static void onRenderFog(ViewportEvent.RenderFog event) {
        if (ClearWater.handleFog(event.getCamera(), event::setNearPlaneDistance, event::setFarPlaneDistance, event::setFogShape)) {
            event.setCanceled(true);
        }
    }
}
