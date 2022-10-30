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

    public String GetEffect(MobEffectInstance instance){
        String name = instance.getDescriptionId();
        String[] split = name.split("\\.");
        String[] split2 = split[2].split("_");
        name = split2[0];
        String name2 = null;
        Character character = name.charAt(0);
        character = Character.toUpperCase(character);
        name = name.substring(1);
        name = character + name;

        if(split2.length == 2){name2 = split2[1];}
        if(name2 != null){
            character = name2.charAt(0);
            character = Character.toUpperCase(character);
            name2 = name2.substring(1);
            name2 = character + name2;
        }
        if(name2 != null)
            name = name + " " + name2;
        else name = name;
        return name;}
    public String GetAmplifier(MobEffectInstance instance){return PotentBuilder(instance.getAmplifier());}
    public String GetDuration(MobEffectInstance instance){return TimeBuilder(instance.getDuration());}


    public ArrayList<MobEffectInstance> getEffectInstance() {return effectInstances;}

    private String PotentBuilder(int potency){
        switch(potency){
            case 0:
                return "I";
            case 1:
                return "II";
            case 2:
                return "III";
            case 3:
                return "IV";
            case 4:
                return "V";
            default:
                return "?";
        }
    }



    private String TimeBuilder(int duration){
        String timer = "(";
        int timermath = duration/20;
        if (timermath >= 60){
            timer += Integer.toString(timermath/60);
            while(timermath >= 60){timermath -= 60;}
            timer += ":";
        }else{
            timer += "00:";
        }
        if (timermath > 9){
            timer += Integer.toString(timermath);
            timer += ")";
        } else{
            timer += "0";
            timer += Integer.toString(timermath);
            timer += ")";
        }
        return timer;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        short counter = 0;
        for(MobEffectInstance instance : effectInstances){
            String effect = this.GetEffect(instance);
            String amplifier = this.GetAmplifier(instance);
            String duration = this.GetDuration(instance);
            String msg;
            msg = textFormattings.get(counter) + effect + " " + amplifier + " " + duration;
            counter++;
            tooltip.add(Component.literal(msg));}
        if(extraLore != null) {
            for (String extras : extraLore) {
                String msg;
                msg = textFormattings.get(counter) + extras;
                counter++;
                tooltip.add(Component.literal(msg));
            }
        }
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
