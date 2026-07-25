package com.sledz.sledzinstruments.capability;

import com.sledz.sledzinstruments.SIMain;
import com.sledz.sledzinstruments.capability.recording.RecordingCapabilityProvider;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.FORGE, modid = SIMain.MODID)
public class ModCapabilities {

    @SubscribeEvent
    public static void registerCapabilities(final AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {

            if (!event.getObject().getCapability(RecordingCapabilityProvider.CAPABILITY).isPresent())
                event.addCapability(new ResourceLocation(SIMain.MODID, "emi_caps"), new RecordingCapabilityProvider());

        }
    }

}
