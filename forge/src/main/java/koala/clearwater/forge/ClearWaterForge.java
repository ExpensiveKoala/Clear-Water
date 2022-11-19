package koala.clearwater.forge;

import koala.clearwater.ClearWater;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ClearWater.MOD_ID)
public class ClearWaterForge {
    public ClearWaterForge() {
        ClearWater.init();
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ConfigImpl.clientSpec);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ConfigImpl::onLoad);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ConfigImpl::onReload);
    }
}