package koala.clearwater;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.material.FogType;
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
		if (Configs.CLIENT.enableWater.get() && event.getCamera().getFluidInCamera() == FogType.WATER) {
			//RenderSystem.fogMode(GlStateManager.FogMode.EXP);
			float waterVision = 1.0f;
			if(event.getCamera().getEntity() instanceof LocalPlayer && Configs.CLIENT.fadeInWater.get()) {
				waterVision = Math.max(0.25f, ((LocalPlayer)event.getCamera().getEntity()).getWaterVision());
			}
			event.setDensity(waterVision * Configs.CLIENT.fogDensityWater.get().floatValue());
			event.setCanceled(true);
		} else if (Configs.CLIENT.enableLava.get() && event.getCamera().getFluidInCamera() == FogType.LAVA) {
			//RenderSystem.fogMode(GlStateManager.FogMode.EXP);
			event.setDensity(Configs.CLIENT.fogDensityLava.get().floatValue());
			event.setCanceled(true);
		}
	}
}
