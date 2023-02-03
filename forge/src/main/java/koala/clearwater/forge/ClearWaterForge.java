package koala.clearwater.forge;

import koala.clearwater.ClearWater;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ClearWater.MOD_ID)
public class ClearWaterForge {
    public ClearWaterForge() {
        ClearWater.init();
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClearWaterForgeClient::init);
    }
}