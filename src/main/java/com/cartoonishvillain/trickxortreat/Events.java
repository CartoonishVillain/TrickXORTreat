package com.cartoonishvillain.trickxortreat;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.cartoonishvillain.trickxortreat.Register.*;

@Mod.EventBusSubscriber(modid = TrickXORTreat.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Events {
    @SubscribeEvent
    public static void registerTabs(BuildCreativeModeTabContentsEvent buildContents) {
        if (buildContents.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            buildContents.accept(CLOUDCANDY);
            buildContents.accept(CREEPERCOCHOCOLATE);
            buildContents.accept(HEROICBAR);
            buildContents.accept(PIGMENTCOIN);
            buildContents.accept(SUGARBONE);
            buildContents.accept(RABBITCANDY);
            buildContents.accept(PRISMATICFLESH);
            buildContents.accept(FLAMINGDOTS);
            buildContents.accept(DOLPHINCRUNCH);
            buildContents.accept(VILLAGEBITE);
            buildContents.accept(GUARDIANGUMMY);
            buildContents.accept(SCUTESNACKS);
        }
    }
}
