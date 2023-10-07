package com.cartoonishvillain.trickxortreat;

import com.cartoonishvillain.trickxortreat.enchants.Treat;
import com.cartoonishvillain.trickxortreat.enchants.Trick;
import com.cartoonishvillain.trickxortreat.items.Candy;
import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.Arrays;

public class Register {


    public static final DeferredRegister<Enchantment> ENCHANTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, TrickXORTreat.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TrickXORTreat.MODID);


    public static void init(){
        ENCHANTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<Enchantment> TRICK = ENCHANTS.register("trick", () -> new Trick(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    public static final RegistryObject<Enchantment> TREAT = ENCHANTS.register("treat", () -> new Treat(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));


    public static final RegistryObject<Candy> CLOUDCANDY  = ITEMS.register("cloud_candy", () -> new Candy(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).fast().effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 20*15, 0), 1.0f).effect(()-> new MobEffectInstance(MobEffects.SLOW_FALLING, 20*30, 0), 1f).alwaysEat().build()), new ArrayList<>(Arrays.asList(new MobEffectInstance(MobEffects.LEVITATION, 20*15, 0), new MobEffectInstance(MobEffects.SLOW_FALLING, 20*30, 0))), new ArrayList<>(Arrays.asList(ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.RESET)), new ArrayList<>(Arrays.asList("It's almost as light as the air..."))));
    public static final RegistryObject<Candy> CREEPERCOCHOCOLATE  = ITEMS.register("creeper_chocolate", () -> new Candy(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).fast().effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 20*15, 0), 1.0f).effect(()-> new MobEffectInstance(MobEffects.NIGHT_VISION, 20*15, 0), 1f).alwaysEat().build()), new ArrayList<>(Arrays.asList(new MobEffectInstance(MobEffects.INVISIBILITY, 20*15, 0), new MobEffectInstance(MobEffects.NIGHT_VISION, 20*15, 0))), new ArrayList<>(Arrays.asList(ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.GREEN)), new ArrayList<>(Arrays.asList("Made with creepers, by creepers, for creepers!"))));
    public static final RegistryObject<Candy> HEROICBAR  = ITEMS.register("heroic_bar", () -> new Candy(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).fast().effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20*15, 0), 1.0f).effect(()-> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*15, 0), 1f).alwaysEat().build()), new ArrayList<>(Arrays.asList(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20*15, 0), new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*15, 0))), new ArrayList<>(Arrays.asList(ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.RED)), new ArrayList<>(Arrays.asList("Fight well!"))));
    public static final RegistryObject<Candy> PIGMENTCOIN  = ITEMS.register("pigmen_gold", () -> new Candy(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).fast().effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 20*15, 0), 1.0f).effect(()-> new MobEffectInstance(MobEffects.LUCK, 20*15, 0), 1f).alwaysEat().build()), new ArrayList<>(Arrays.asList(new MobEffectInstance(MobEffects.DIG_SPEED, 20*15, 0), new MobEffectInstance(MobEffects.LUCK, 20*15, 0))), new ArrayList<>(Arrays.asList(ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.YELLOW)), new ArrayList<>(Arrays.asList("It may not be gold, but it's still good luck!"))));
    public static final RegistryObject<Candy> SUGARBONE  = ITEMS.register("sugar_bone", () -> new Candy(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).fast().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20*15, 0), 1.0f).alwaysEat().build()), new ArrayList<>(Arrays.asList(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20*15, 0))), new ArrayList<>(Arrays.asList(ChatFormatting.BLUE, ChatFormatting.RESET)), new ArrayList<>(Arrays.asList("Notice: Do not feed this to dogs."))));
    public static final RegistryObject<Candy> RABBITCANDY = ITEMS.register("candy_rabbit", () -> new Candy(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).fast().effect(() -> new MobEffectInstance(MobEffects.JUMP, 20*15, 1), 1.0f).alwaysEat().build()), new ArrayList<>(Arrays.asList(new MobEffectInstance(MobEffects.JUMP, 20*15, 1))), new ArrayList<>(Arrays.asList(ChatFormatting.BLUE, ChatFormatting.GREEN)), new ArrayList<>(Arrays.asList("Reach the skies! No rabbits were harmed in the making of this product."))));
    public static final RegistryObject<Candy> PRISMATICFLESH = ITEMS.register("prismatic_flesh", () -> new Candy(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).fast().effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20*15, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*15, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20*15, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.JUMP, 20*15, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 20*15, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 20*25, 0), 1f).alwaysEat().build()), new ArrayList<>(Arrays.asList(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20*15, 0), new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*15, 0), new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20*15, 0), new MobEffectInstance(MobEffects.JUMP, 20*15, 0), new MobEffectInstance(MobEffects.DIG_SPEED, 20*15, 0), new MobEffectInstance(MobEffects.CONFUSION, 20*25, 0))), new ArrayList<>(Arrays.asList(ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.RED, ChatFormatting.RED)), new ArrayList<>(Arrays.asList("It's sweet. Maybe a bit too sweet."))));
    public static final RegistryObject<Candy> FLAMINGDOTS = ITEMS.register("flaming_dots", () -> new Candy(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).fast().effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20*20, 0), 1.0f).alwaysEat().build()), new ArrayList<>(Arrays.asList(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20*20, 0))), new ArrayList<>(Arrays.asList(ChatFormatting.BLUE, ChatFormatting.GOLD)), new ArrayList<>(Arrays.asList("Blaze Co. holds no responsibility for personal injury while consuming this product."))));
    public static final RegistryObject<Candy> DOLPHINCRUNCH = ITEMS.register("dolphin_crunch", () -> new Candy(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).fast().effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 20*5, 0), 1.0f).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 20*10, 0), 1).alwaysEat().build()), new ArrayList<>(Arrays.asList(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 20*5, 0), new MobEffectInstance(MobEffects.WATER_BREATHING, 20*10, 0))), new ArrayList<>(Arrays.asList(ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.AQUA)), new ArrayList<>(Arrays.asList("Made with real dolphin fins!"))));






}
