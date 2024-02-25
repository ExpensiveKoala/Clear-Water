package koala.clearwater.forge;

import koala.clearwater.ClearWater;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(ClearWater.MOD_ID)
public class ClearWaterForge {
    public ClearWaterForge() {
        ClearWater.init();
        if(FMLEnvironment.dist == Dist.CLIENT) {
            ClearWaterForgeClient.init();
        }
    }
}