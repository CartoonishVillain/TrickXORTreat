package com.cartoonishvillain.trickxortreat;

import com.cartoonishvillain.trickxortreat.config.CommonConfig;
import com.cartoonishvillain.trickxortreat.config.ConfigHelper;
import com.cartoonishvillain.trickxortreat.items.Candy;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("trickxortreat")
public class TrickXORTreat
{

    public static ArrayList<SoundEvent> tricksounds = new ArrayList<SoundEvent>(List.of(SoundEvents.ZOMBIE_VILLAGER_CURE, SoundEvents.ZOMBIE_VILLAGER_AMBIENT, SoundEvents.BELL_RESONATE, SoundEvents.PARROT_IMITATE_ENDER_DRAGON, SoundEvents.PHANTOM_AMBIENT, SoundEvents.VEX_CHARGE, SoundEvents.TOTEM_USE));
    public static ArrayList<MobEffect> trickeffects = new ArrayList<MobEffect>(List.of(MobEffects.LEVITATION, MobEffects.WEAKNESS, MobEffects.MOVEMENT_SLOWDOWN, MobEffects.UNLUCK, MobEffects.BLINDNESS, MobEffects.CONFUSION));
    public static ArrayList<Item> candies;
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "trickxortreat";
    public static CommonConfig config;

    public TrickXORTreat() {
        // Register the setup method for modloading
        Register.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        config = ConfigHelper.register(ModConfig.Type.COMMON, CommonConfig::new);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        candies = new ArrayList<Item>(List.of(Register.CREEPERCOCHOCOLATE.get(), Register.FLAMINGDOTS.get(), Register.SUGARBONE.get(), Register.CLOUDCANDY.get(), Register.DOLPHINCRUNCH.get(), Register.HEROICBAR.get(), Register.PIGMENTCOIN.get(), Register.RABBITCANDY.get(), Register.CREEPERCOCHOCOLATE.get(), Register.FLAMINGDOTS.get(), Register.SUGARBONE.get(), Register.CLOUDCANDY.get(), Register.DOLPHINCRUNCH.get(), Register.HEROICBAR.get(), Register.PIGMENTCOIN.get(), Register.RABBITCANDY.get(), Register.PRISMATICFLESH.get()));
    }


}
