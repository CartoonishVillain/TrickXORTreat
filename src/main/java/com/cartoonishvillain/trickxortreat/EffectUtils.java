package com.cartoonishvillain.trickxortreat;

import net.minecraft.world.effect.MobEffectInstance;

public class EffectUtils {
    public static String GetEffect(MobEffectInstance instance){
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
        return name;
    }


    public static String GetAmplifier(MobEffectInstance instance){return PotentBuilder(instance.getAmplifier());}
    public static String GetDuration(MobEffectInstance instance){return TimeBuilder(instance.getDuration());}

    private static String PotentBuilder(int potency) {
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

    private static String TimeBuilder(int duration) {
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
}
