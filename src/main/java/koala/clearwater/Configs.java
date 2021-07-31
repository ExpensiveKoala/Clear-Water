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
			  .comment("Value for fog density (0-500) Vanilla is 48.0 - water brightness")
			  .translation("")
			  .defineInRange("fogDensityWater", 150.0, 0, 500);
			
			enableLava = builder
			  .comment("Enables modifications of fog under lava")
			  .translation("")
			  .define("enableLava", true);
			
			fogDensityLava = builder
			  .comment("Value for fog density (0-500) Vanilla is 1.0")
			  .translation("")
			  .defineInRange("fogDensityLava", 25.0, 0, 500);
			
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
