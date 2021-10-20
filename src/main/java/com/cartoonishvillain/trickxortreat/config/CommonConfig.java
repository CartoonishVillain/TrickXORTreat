package com.cartoonishvillain.trickxortreat.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CommonConfig {
    public static final String CATEGORY = "Magical Properties";

    public ConfigHelper.ConfigValueListener<Integer> baseTrickChance;
    public ConfigHelper.ConfigValueListener<Integer> baseTreatChance;
    public ConfigHelper.ConfigValueListener<Boolean> trickOrTreatCompat;

    public CommonConfig(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber){
        builder.comment("Modify the rules for the enchantments").push(CATEGORY);

        baseTrickChance = subscriber.subscribe(builder.comment("Changes the base chance of the effects of trick happening. Multiplied by 2 and 3 for higher tiers of the enchantment.").defineInRange("baseTrickChance", 5, 1, 100));
        baseTreatChance = subscriber.subscribe(builder.comment("Changes the base chance of the effects of treat happening. Multiplied by 2 and 3 for higher tiers of the enchantment.").defineInRange("baseTreatChance", 5, 1, 100));
        trickOrTreatCompat = subscriber.subscribe(builder.comment("Enables or disables mobs dropping candy from the other SpookyJam Trick Or Treat mod with the Treat enchantment when installed.").define("trickOrTreatCompat", true));
    }
}
