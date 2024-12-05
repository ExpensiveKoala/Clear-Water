package koala.clearwater;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ViewportEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(value = ClearWater.MOD_ID, dist = Dist.CLIENT)
public class ClearWaterNeoForgeClient {
    
    public ClearWaterNeoForgeClient(ModContainer container) {
        ClearWater.init();
//        container.registerExtensionPoint(IConfigScreenFactory.class,
//          (client, parent) -> ResourcefulConfigScreen.getFactory(ClearWater.MOD_ID).apply(parent)
//        );
        NeoForge.EVENT_BUS.addListener(ClearWaterNeoForgeClient::onRenderFog);
    }
    
    public static void onRenderFog(ViewportEvent.RenderFog event) {
        if (ClearWater.handleFog(event.getCamera(), event::setNearPlaneDistance, event::setFarPlaneDistance, event::setFogShape)) {
            event.setCanceled(true);
        }
    }
}
