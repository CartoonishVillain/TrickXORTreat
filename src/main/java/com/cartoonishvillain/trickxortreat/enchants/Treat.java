package com.cartoonishvillain.trickxortreat.enchants;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class Treat extends Enchantment {
    protected Treat(Rarity p_44676_, EnchantmentCategory p_44677_, EquipmentSlot[] p_44678_) {
        super(p_44676_, EnchantmentCategory.WEAPON, p_44678_);
    }


    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    protected boolean checkCompatibility(Enchantment p_44690_) {
        return !(p_44690_ instanceof Trick);
    }

    @Override
    public void doPostAttack(LivingEntity p_44686_, Entity p_44687_, int p_44688_) {
        super.doPostAttack(p_44686_, p_44687_, p_44688_);
    }
}
