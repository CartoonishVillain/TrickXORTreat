package com.cartoonishvillain.trickxortreat;

import com.cartoonishvillain.trickxortreat.config.CommonConfig;
import com.cartoonishvillain.trickxortreat.config.ConfigHelper;
import com.cartoonishvillain.trickxortreat.items.Candy;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("trickxortreat")
public class TrickXORTreat
{

    public static ArrayList<SoundEvent> tricksounds = new ArrayList<SoundEvent>(Arrays.asList(SoundEvents.ZOMBIE_VILLAGER_CURE, SoundEvents.ZOMBIE_VILLAGER_AMBIENT, SoundEvents.BELL_RESONATE, SoundEvents.PARROT_IMITATE_ENDER_DRAGON, SoundEvents.PHANTOM_AMBIENT, SoundEvents.VEX_CHARGE, SoundEvents.TOTEM_USE));
    public static ArrayList<Effect> trickeffects = new ArrayList<Effect>(Arrays.asList(Effects.LEVITATION, Effects.WEAKNESS, Effects.MOVEMENT_SLOWDOWN, Effects.UNLUCK, Effects.BLINDNESS, Effects.CONFUSION));
    public static ArrayList<Item> candies;
    public static CommonConfig config;
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "trickxortreat";

    public TrickXORTreat() {
        // Register the setup method for modloading
        Register.init();
        config = ConfigHelper.register(ModConfig.Type.COMMON, CommonConfig::new);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        candies = new ArrayList<Item>(Arrays.asList(Register.CREEPERCOCHOCOLATE.get(), Register.FLAMINGDOTS.get(), Register.SUGARBONE.get(), Register.CLOUDCANDY.get(), Register.DOLPHINCRUNCH.get(), Register.HEROICBAR.get(), Register.PIGMENTCOIN.get(), Register.RABBITCANDY.get(), Register.CREEPERCOCHOCOLATE.get(), Register.FLAMINGDOTS.get(), Register.SUGARBONE.get(), Register.CLOUDCANDY.get(), Register.DOLPHINCRUNCH.get(), Register.HEROICBAR.get(), Register.PIGMENTCOIN.get(), Register.RABBITCANDY.get(), Register.PRISMATICFLESH.get()));
    }


}
