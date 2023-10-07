package com.cartoonishvillain.trickxortreat.enchants;

import com.cartoonishvillain.trickxortreat.TrickXORTreat;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Rotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.cartoonishvillain.trickxortreat.EffectUtils.GetEffect;

public class Trick extends Enchantment {
    private static List<String> listOfEffects = List.of("potioneffect", "teleport", "ignite");
    public Trick(Rarity p_44676_, EnchantmentCategory p_44677_, EquipmentSlot[] p_44678_) {
        super(p_44676_, EnchantmentCategory.WEAPON, p_44678_);
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
        int chance = TrickXORTreat.config.baseTrickChance.get();
        //assuming p_44688_ is level
        chance = chance * p_44688_;
        if(!p_44686_.level().isClientSide()){
            int random = p_44686_.getRandom().nextInt(100);
            if(random < chance){
                if (p_44686_.getRandom().nextBoolean()) {
                    random = p_44686_.getRandom().nextInt(TrickXORTreat.tricksounds.size());
                    p_44686_.level().playSound(null, p_44686_.getOnPos(), TrickXORTreat.tricksounds.get(random), SoundSource.PLAYERS, 0.8f, 1);

                    if (p_44686_ instanceof ServerPlayer) {
                        ((ServerPlayer) p_44686_).sendSystemMessage(Component.translatable("trick.trickxortreat.playsound"), true);
                    }
                } else{
                    random = p_44686_.getRandom().nextInt(listOfEffects.size());
                    getEffect((short) random, p_44687_, p_44686_);
                }
            }

        }
    }

    private void getEffect(short random, Entity entity, LivingEntity attacker) {
        switch (listOfEffects.get(random)) {
            case "potioneffect" -> {
                if (entity instanceof LivingEntity) {
                    random = (short) attacker.getRandom().nextInt(TrickXORTreat.trickeffects.size());
                    MobEffectInstance effectInstance = new MobEffectInstance(TrickXORTreat.trickeffects.get(random), 200, 0);
                    ((LivingEntity) entity).addEffect(effectInstance);
                    if (attacker instanceof ServerPlayer) {
                        ((ServerPlayer) attacker).sendSystemMessage(Component.translatable("trick.trickxortreat.effect", GetEffect(effectInstance)), true);
                    }
                }
            }
            case "teleport" -> {
                if (entity instanceof LivingEntity) {
                    RandomSource randomSource = ((LivingEntity) entity).getRandom();
                    ((LivingEntity) entity).randomTeleport (
                            entity.getX() + randomSource.nextInt(20)-10,
                            entity.getY() + randomSource.nextInt(20)-10,
                            entity.getZ() + randomSource.nextInt(20)-10,
                            true
                    );
                }
                if (attacker instanceof ServerPlayer) {
                    ((ServerPlayer) attacker).sendSystemMessage(Component.translatable("trick.trickxortreat.teleport"), true);
                }
            }
            case "ignite" -> {
                entity.setSecondsOnFire(5);
                if (attacker instanceof ServerPlayer) {
                    ((ServerPlayer) attacker).sendSystemMessage(Component.translatable("trick.trickxortreat.ignite"), true);
                }
            }
        }
    }



}
