package koala.clearwater;

import net.minecraft.block.material.Material;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author ExpensiveKoala
 */
@Mod(modid = "clearwater", version = "1.0", name = "Clear Water")
public class ClearWater {

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onRenderFog(EntityViewRenderEvent.FogDensity event) {
        if(event.getState().getMaterial() == Material.WATER) {
            event.setDensity(0);
            event.setCanceled(true);
        }
    }
}
