package com.cartoonishvillain.trickxortreat.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static com.cartoonishvillain.trickxortreat.EffectUtils.*;

public class Candy extends Item {
    ArrayList<ChatFormatting> textFormattings;
    ArrayList<MobEffectInstance> effectInstances;
    ArrayList<String> extraLore;
    public Candy(Item.Properties properties, ArrayList<MobEffectInstance> effectInstances, ArrayList<ChatFormatting> textFormattings, @Nullable ArrayList<String> extraLore) {
        super(properties);
        this.effectInstances = effectInstances;
        this.textFormattings = textFormattings;
        this.extraLore = extraLore;
    }


    public ArrayList<MobEffectInstance> getEffectInstance() {return effectInstances;}

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        short counter = 0;
        for(MobEffectInstance instance : effectInstances){
            String effect = GetEffect(instance);
            String amplifier = GetAmplifier(instance);
            String duration = GetDuration(instance);
            String msg;
            msg = textFormattings.get(counter) + effect + " " + amplifier + " " + duration;
            counter++;
            tooltip.add(Component.literal(msg));}
        if(extraLore != null) {
            for (String extras : extraLore) {
                tooltip.add(Component.translatable(extras).withStyle(textFormattings.get(counter)));
                counter++;
            }
        }
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
