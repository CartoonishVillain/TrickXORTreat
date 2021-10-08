package com.cartoonishvillain.trickxortreat;

import com.cartoonishvillain.trickxortreat.enchants.Register;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("trickxortreat")
public class TrickXORTreat
{

    public static ArrayList<SoundEvent> tricksounds = new ArrayList<SoundEvent>(List.of(SoundEvents.ZOMBIE_VILLAGER_CURE, SoundEvents.ZOMBIE_VILLAGER_AMBIENT, SoundEvents.BELL_RESONATE, SoundEvents.PARROT_IMITATE_ENDER_DRAGON, SoundEvents.PHANTOM_AMBIENT, SoundEvents.VEX_CHARGE, SoundEvents.TOTEM_USE));
    public static ArrayList<MobEffect> trickeffects = new ArrayList<MobEffect>(List.of(MobEffects.LEVITATION, MobEffects.WEAKNESS, MobEffects.MOVEMENT_SLOWDOWN, MobEffects.UNLUCK, MobEffects.BLINDNESS, MobEffects.CONFUSION));
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "trickxortreat";

    public TrickXORTreat() {
        // Register the setup method for modloading
        Register.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }


}
