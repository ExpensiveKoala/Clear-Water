package koala.clearwater;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author ExpensiveKoala
 */
@Mod(modid = "clearwater", version = "1.1", name = "Clear Water")
public class ClearWater {

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onRenderFog(EntityViewRenderEvent.FogDensity event) {
        if(Configs.enableWater && event.getState().getMaterial() == Material.WATER) {
            GlStateManager.setFog(GlStateManager.FogMode.EXP);
            event.setDensity((float)Configs.fogDensityWater);
            event.setCanceled(true);
        } else if(Configs.enableLava && event.getState().getMaterial() == Material.LAVA) {
            GlStateManager.setFog(GlStateManager.FogMode.EXP);
            event.setDensity((float)Configs.fogDensityLava);
            //event.setDensity(2.0f);
            event.setCanceled(true);
        }
        System.out.println(event.getDensity());
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if(event.getModID().equals("clearwater")) {
            ConfigManager.sync("clearwater", Config.Type.INSTANCE);
        }
    }
}
