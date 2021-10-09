package com.cartoonishvillain.trickxortreat.enchants;

import com.cartoonishvillain.trickxortreat.TrickXORTreat;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;

public class Treat extends Enchantment {
    public Treat(Rarity p_44676_, EnchantmentType p_44677_, EquipmentSlotType[] p_44678_) {
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
            if(random <= chance && p_44687_ instanceof LivingEntity && !(p_44687_ instanceof PlayerEntity)){
                random = p_44686_.getRandom().nextInt(TrickXORTreat.candies.size());
                ItemEntity item = new ItemEntity(EntityType.ITEM, p_44686_.level);
                item.setPos(p_44687_.getX(), p_44687_.getY(), p_44687_.getZ());
                item.setItem(new ItemStack(TrickXORTreat.candies.get(random), 1));
                p_44686_.level.addFreshEntity(item);
                p_44686_.level.playSound(null, p_44687_.blockPosition(), SoundEvents.CHICKEN_EGG, SoundCategory.MASTER, 1, 1);
            }
        }
    }
}
