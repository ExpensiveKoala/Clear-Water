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
	
	@SubscribeEvent
	public void onRenderFog(EntityViewRenderEvent.RenderFogEvent event) {
		if (Configs.CLIENT.enableWater.get() && event.getCamera().getFluidInCamera() == FogType.WATER) {
			float waterVision = 1.0f;
			if(Configs.CLIENT.fadeInWater.get() && event.getCamera().getEntity() instanceof LocalPlayer) {
				waterVision = Math.max(0.25f, ((LocalPlayer)event.getCamera().getEntity()).getWaterVision());
			}
			event.setNearPlaneDistance(Configs.CLIENT.fogNearPlaneWater.get().floatValue());
			event.setFarPlaneDistance(Configs.CLIENT.fogFarPlaneWater.get().floatValue() * waterVision);
			event.setCanceled(true);
		} else if (Configs.CLIENT.enableLava.get() && event.getCamera().getFluidInCamera() == FogType.LAVA) {
			event.setNearPlaneDistance(Configs.CLIENT.fogNearPlaneLava.get().floatValue());
			event.setFarPlaneDistance(Configs.CLIENT.fogFarPlaneLava.get().floatValue());
			event.setCanceled(true);
		} else if (Configs.CLIENT.enablePowderedSnow.get() && event.getCamera().getFluidInCamera() == FogType.POWDER_SNOW) {
			event.setNearPlaneDistance(Configs.CLIENT.fogNearPlaneSnow.get().floatValue());
			event.setFarPlaneDistance(Configs.CLIENT.fogFarPlaneSnow.get().floatValue());
			event.setCanceled(true);
		}
	}
}
