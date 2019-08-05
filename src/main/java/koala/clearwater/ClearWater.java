package koala.clearwater;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

/**
 * @author ExpensiveKoala
 */
@Mod("clearwater")
public class ClearWater {
	
	public ClearWater() {
		MinecraftForge.EVENT_BUS.register(this);
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Configs.clientSpec);
	}
	
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public void onRenderFog(EntityViewRenderEvent.FogDensity event) {
		if (Configs.CLIENT.enableWater.get() && event.getInfo().getFluidState().isTagged(FluidTags.WATER)) {
			GlStateManager.fogMode(GlStateManager.FogMode.EXP);
			event.setDensity(Configs.CLIENT.fogDensityWater.get().floatValue());
			event.setCanceled(true);
		} else if (Configs.CLIENT.enableLava.get() && event.getInfo().getFluidState().isTagged(FluidTags.LAVA)) {
			GlStateManager.fogMode(GlStateManager.FogMode.EXP);
			event.setDensity(Configs.CLIENT.fogDensityLava.get().floatValue());
			event.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public void onConfigChanged(ModConfig.ModConfigEvent event) {
		final ModConfig config = event.getConfig();
		if (config.getSpec() == Configs.clientSpec) {
			Configs.enableWater = Configs.CLIENT.enableWater.get();
			Configs.fogDensityWater = Configs.CLIENT.fogDensityWater.get();
			Configs.enableLava = Configs.CLIENT.enableLava.get();
			Configs.fogDensityLava = Configs.CLIENT.fogDensityLava.get();
		}
	}
}
