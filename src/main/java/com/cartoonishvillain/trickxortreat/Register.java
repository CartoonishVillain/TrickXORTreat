package com.cartoonishvillain.trickxortreat;

import com.cartoonishvillain.trickxortreat.enchants.Treat;
import com.cartoonishvillain.trickxortreat.enchants.Trick;
import com.cartoonishvillain.trickxortreat.items.Candy;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.Arrays;

public class Register {


    public static final DeferredRegister<Enchantment> ENCHANTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, TrickXORTreat.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TrickXORTreat.MODID);


    public static void init(){
        ENCHANTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<Enchantment> TRICK = ENCHANTS.register("trick", () -> new Trick(Enchantment.Rarity.COMMON, EnchantmentType.WEAPON, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND}));
    public static final RegistryObject<Enchantment> TREAT = ENCHANTS.register("treat", () -> new Treat(Enchantment.Rarity.UNCOMMON, EnchantmentType.WEAPON, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND}));


    public static final RegistryObject<Candy> CLOUDCANDY  = ITEMS.register("cloud_candy", () -> new Candy(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().nutrition(1).saturationMod(0.5f).fast().effect(() -> new EffectInstance(Effects.LEVITATION, 20*15, 0), 1.0f).effect(()-> new EffectInstance(Effects.SLOW_FALLING, 20*30, 0), 1f).alwaysEat().build()), new ArrayList<>(Arrays.asList(new EffectInstance(Effects.LEVITATION, 20*15, 0), new EffectInstance(Effects.SLOW_FALLING, 20*30, 0))), new ArrayList<>(Arrays.asList(TextFormatting.BLUE, TextFormatting.BLUE, TextFormatting.RESET)), new ArrayList<>(Arrays.asList("It's almost as light as the air..."))));
    public static final RegistryObject<Candy> CREEPERCOCHOCOLATE  = ITEMS.register("creeper_chocolate", () -> new Candy(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().nutrition(1).saturationMod(0.5f).fast().effect(() -> new EffectInstance(Effects.INVISIBILITY, 20*15, 0), 1.0f).effect(()-> new EffectInstance(Effects.NIGHT_VISION, 20*15, 0), 1f).alwaysEat().build()), new ArrayList<>(Arrays.asList(new EffectInstance(Effects.INVISIBILITY, 20*15, 0), new EffectInstance(Effects.NIGHT_VISION, 20*15, 0))), new ArrayList<>(Arrays.asList(TextFormatting.BLUE, TextFormatting.BLUE, TextFormatting.GREEN)), new ArrayList<>(Arrays.asList("Made with creepers, by creepers, for creepers!"))));
    public static final RegistryObject<Candy> HEROICBAR  = ITEMS.register("heroic_bar", () -> new Candy(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().nutrition(1).saturationMod(0.5f).fast().effect(() -> new EffectInstance(Effects.DAMAGE_BOOST, 20*15, 0), 1.0f).effect(()-> new EffectInstance(Effects.DAMAGE_RESISTANCE, 20*15, 0), 1f).alwaysEat().build()), new ArrayList<>(Arrays.asList(new EffectInstance(Effects.DAMAGE_BOOST, 20*15, 0), new EffectInstance(Effects.DAMAGE_RESISTANCE, 20*15, 0))), new ArrayList<>(Arrays.asList(TextFormatting.BLUE, TextFormatting.BLUE, TextFormatting.RED)), new ArrayList<>(Arrays.asList("Fight well!"))));
    public static final RegistryObject<Candy> PIGMENTCOIN  = ITEMS.register("pigmen_gold", () -> new Candy(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().nutrition(1).saturationMod(0.5f).fast().effect(() -> new EffectInstance(Effects.DIG_SPEED, 20*15, 0), 1.0f).effect(()-> new EffectInstance(Effects.LUCK, 20*15, 0), 1f).alwaysEat().build()), new ArrayList<>(Arrays.asList(new EffectInstance(Effects.DIG_SPEED, 20*15, 0), new EffectInstance(Effects.LUCK, 20*15, 0))), new ArrayList<>(Arrays.asList(TextFormatting.BLUE, TextFormatting.BLUE, TextFormatting.YELLOW)), new ArrayList<>(Arrays.asList("It may not be gold, but it's still good luck!"))));
    public static final RegistryObject<Candy> SUGARBONE  = ITEMS.register("sugar_bone", () -> new Candy(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().nutrition(1).saturationMod(0.5f).fast().effect(() -> new EffectInstance(Effects.MOVEMENT_SPEED, 20*15, 0), 1.0f).alwaysEat().build()), new ArrayList<>(Arrays.asList(new EffectInstance(Effects.MOVEMENT_SPEED, 20*15, 0))), new ArrayList<>(Arrays.asList(TextFormatting.BLUE, TextFormatting.RESET)), new ArrayList<>(Arrays.asList("Notice: Do not feed this to dogs."))));
    public static final RegistryObject<Candy> RABBITCANDY = ITEMS.register("candy_rabbit", () -> new Candy(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().nutrition(1).saturationMod(0.5f).fast().effect(() -> new EffectInstance(Effects.JUMP, 20*15, 1), 1.0f).alwaysEat().build()), new ArrayList<>(Arrays.asList(new EffectInstance(Effects.JUMP, 20*15, 1))), new ArrayList<>(Arrays.asList(TextFormatting.BLUE, TextFormatting.GREEN)), new ArrayList<>(Arrays.asList("Reach the skies! No rabbits were harmed in the making of this product."))));
    public static final RegistryObject<Candy> PRISMATICFLESH = ITEMS.register("prismatic_flesh", () -> new Candy(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().nutrition(1).saturationMod(0.5f).fast().effect(() -> new EffectInstance(Effects.DAMAGE_BOOST, 20*15, 0), 1f).effect(() -> new EffectInstance(Effects.DAMAGE_RESISTANCE, 20*15, 0), 1f).effect(() -> new EffectInstance(Effects.MOVEMENT_SPEED, 20*15, 0), 1f).effect(() -> new EffectInstance(Effects.JUMP, 20*15, 0), 1f).effect(() -> new EffectInstance(Effects.DIG_SPEED, 20*15, 0), 1f).effect(() -> new EffectInstance(Effects.CONFUSION, 20*25, 0), 1f).alwaysEat().build()), new ArrayList<>(Arrays.asList(new EffectInstance(Effects.DAMAGE_BOOST, 20*15, 0), new EffectInstance(Effects.DAMAGE_RESISTANCE, 20*15, 0), new EffectInstance(Effects.MOVEMENT_SPEED, 20*15, 0), new EffectInstance(Effects.JUMP, 20*15, 0), new EffectInstance(Effects.DIG_SPEED, 20*15, 0), new EffectInstance(Effects.CONFUSION, 20*25, 0))), new ArrayList<>(Arrays.asList(TextFormatting.BLUE, TextFormatting.BLUE, TextFormatting.BLUE, TextFormatting.BLUE, TextFormatting.BLUE, TextFormatting.RED, TextFormatting.RED)), new ArrayList<>(Arrays.asList("It's sweet. Maybe a bit too sweet."))));
    public static final RegistryObject<Candy> FLAMINGDOTS = ITEMS.register("flaming_dots", () -> new Candy(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().nutrition(1).saturationMod(0.5f).fast().effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 20*20, 0), 1.0f).alwaysEat().build()), new ArrayList<>(Arrays.asList(new EffectInstance(Effects.FIRE_RESISTANCE, 20*20, 0))), new ArrayList<>(Arrays.asList(TextFormatting.BLUE, TextFormatting.GOLD)), new ArrayList<>(Arrays.asList("Blaze Co. holds no responsibility for personal injury while consuming this product."))));
    public static final RegistryObject<Candy> DOLPHINCRUNCH = ITEMS.register("dolphin_crunch", () -> new Candy(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().nutrition(1).saturationMod(0.5f).fast().effect(() -> new EffectInstance(Effects.DOLPHINS_GRACE, 20*5, 0), 1.0f).effect(() -> new EffectInstance(Effects.WATER_BREATHING, 20*10, 0), 1).alwaysEat().build()), new ArrayList<>(Arrays.asList(new EffectInstance(Effects.DOLPHINS_GRACE, 20*5, 0), new EffectInstance(Effects.WATER_BREATHING, 20*10, 0))), new ArrayList<>(Arrays.asList(TextFormatting.BLUE, TextFormatting.BLUE, TextFormatting.AQUA)), new ArrayList<>(Arrays.asList("Made with real dolphin fins!"))));






}
