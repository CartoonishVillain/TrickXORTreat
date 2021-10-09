package com.cartoonishvillain.trickxortreat.items;


import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class Candy extends Item {
    ArrayList<TextFormatting> textFormattings;
    ArrayList<EffectInstance> effectInstances;
    ArrayList<String> extraLore;
    public Candy(Item.Properties properties, ArrayList<EffectInstance> effectInstances, ArrayList<TextFormatting> textFormattings, @Nullable ArrayList<String> extraLore) {
        super(properties);
        this.effectInstances = effectInstances;
        this.textFormattings = textFormattings;
        this.extraLore = extraLore;
    }

    public String GetEffect(EffectInstance instance){
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
    public String GetAmplifier(EffectInstance instance){return PotentBuilder(instance.getAmplifier());}
    public String GetDuration(EffectInstance instance){return TimeBuilder(instance.getDuration());}


    public ArrayList<EffectInstance> getEffectInstance() {return effectInstances;}

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
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        short counter = 0;
        for(EffectInstance instance : effectInstances){
            String effect = this.GetEffect(instance);
            String amplifier = this.GetAmplifier(instance);
            String duration = this.GetDuration(instance);
            String msg;
            msg = textFormattings.get(counter) + effect + " " + amplifier + " " + duration;
            counter++;
            tooltip.add(new StringTextComponent(msg));}
        if(extraLore != null) {
            for (String extras : extraLore) {
                String msg;
                msg = textFormattings.get(counter) + extras;
                counter++;
                tooltip.add(new StringTextComponent(msg));
            }
        }
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }


}
