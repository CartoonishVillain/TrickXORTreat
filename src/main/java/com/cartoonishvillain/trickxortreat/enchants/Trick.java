package com.cartoonishvillain.trickxortreat.enchants;

import com.cartoonishvillain.trickxortreat.TrickXORTreat;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class Trick extends Enchantment {
    protected Trick(Rarity p_44676_, EnchantmentCategory p_44677_, EquipmentSlot[] p_44678_) {
        super(p_44676_, EnchantmentCategory.WEAPON, p_44678_);
    }


    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    protected boolean checkCompatibility(Enchantment p_44690_) {
        return !(p_44690_ instanceof Treat);
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
                    p_44686_.level.playSound(null, p_44686_.getOnPos(), TrickXORTreat.tricksounds.get(random), SoundSource.MASTER, 0.8f, 1);
                }else{
                    random -= TrickXORTreat.tricksounds.size();
                    if (p_44687_ instanceof LivingEntity)
                        ((LivingEntity) p_44687_).addEffect(new MobEffectInstance(TrickXORTreat.trickeffects.get(random), 200, 0));
                }
            }

        }
    }
}
