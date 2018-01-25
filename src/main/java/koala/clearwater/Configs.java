package koala.clearwater;

import net.minecraftforge.common.config.Config;

/**
 * @author ExpensiveKoala
 */
@Config(modid = "clearwater")
public class Configs {
    @Config.Comment("Enables modifications of fog under water")
    public static boolean enableWater = true;

    @Config.RangeDouble(min = 0, max = 5)
    @Config.Comment("Value for fog density (0-5) Vanilla is 0.1")
    public static double fogDensityWater = 0.0f;

    @Config.Comment("Enables modifications of fog under lava")
    public static boolean enableLava = true;

    @Config.RangeDouble(min = 0, max = 5)
    @Config.Comment("Value for fog density (0-5) Vanilla is 2.0")
    public static double fogDensityLava = 0.2f;
}
