package koala.clearwater;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

/**
 * @author ExpensiveKoala
 */

public class Configs {
	
	public static class Client {
		
		public final ForgeConfigSpec.BooleanValue enableWater;
		
		public final ForgeConfigSpec.DoubleValue fogDensityWater;
		
		public final ForgeConfigSpec.BooleanValue enableLava;
		
		public final ForgeConfigSpec.DoubleValue fogDensityLava;
		
		Client(ForgeConfigSpec.Builder builder) {
			builder.comment("Client Settings")
			  .push("client");
			
			enableWater = builder
			  .comment("Enables modifications of fog under water")
			  .translation("")
			  .define("enableWater", true);
			
			fogDensityWater = builder
			  .comment("Value for fog density (0-5) Vanilla is 0.5 - water brightness")
			  .translation("")
			  .defineInRange("fogDensityWater", 0.0025, 0, 5);
			
			enableLava = builder
			  .comment("Enables modifications of fog under lava")
			  .translation("")
			  .define("enableLava", true);
			
			fogDensityLava = builder
			  .comment("Value for fog density (0-5) Vanilla is 2.0")
			  .translation("")
			  .defineInRange("fogDensityLava", 0.5, 0, 5);
			
			builder.pop();
		}
		
	}
	
	static final ForgeConfigSpec clientSpec;
	public static final Client CLIENT;
	
	static {
		final Pair<Client, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Client::new);
		clientSpec = specPair.getRight();
		CLIENT = specPair.getLeft();
	}
}
