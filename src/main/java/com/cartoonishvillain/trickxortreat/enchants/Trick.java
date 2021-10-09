package com.cartoonishvillain.trickxortreat.enchants;

import com.cartoonishvillain.trickxortreat.TrickXORTreat;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.SoundCategory;

public class Trick extends Enchantment {
    public Trick(Rarity p_44676_, EnchantmentType p_44677_, EquipmentSlotType[] p_44678_) {
        super(p_44676_, EnchantmentType.WEAPON, p_44678_);
    }


    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    protected boolean checkCompatibility(Enchantment p_44690_) {
        return !(p_44690_ instanceof Treat) && !(p_44690_ instanceof Trick);
    }

    @Override
    public void doPostAttack(LivingEntity p_44686_, Entity p_44687_, int p_44688_) {
        super.doPostAttack(p_44686_, p_44687_, p_44688_);
        int chance = 5;
        //assuming p_44688_ is level
        chance = chance * p_44688_;
        if(!p_44686_.level.isClientSide()){
            int random = p_44686_.getRandom().nextInt(100);
            if(random < chance){
                random = p_44686_.getRandom().nextInt(TrickXORTreat.tricksounds.size() + TrickXORTreat.trickeffects.size());
                if(!(random >= TrickXORTreat.tricksounds.size())) {
                    p_44686_.level.playSound(null, p_44686_.blockPosition(), TrickXORTreat.tricksounds.get(random), SoundCategory.PLAYERS, 0.8f, 1);
                }else{
                    random -= TrickXORTreat.tricksounds.size();
                    if (p_44687_ instanceof LivingEntity)
                        ((LivingEntity) p_44687_).addEffect(new EffectInstance(TrickXORTreat.trickeffects.get(random), 200, 0));
                }
            }

        }
    }
}
