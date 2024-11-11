package com.github.eterdelta.crittersandcompanions;

import com.github.eterdelta.crittersandcompanions.client.renderer.BubbleLayer;
import com.github.eterdelta.crittersandcompanions.client.renderer.SilkLeashRenderer;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib.event.GeoRenderEvent;

@Mod.EventBusSubscriber(modid = CrittersAndCompanions.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        CrittersAndCompanionsClient.registerEntityLayers(event::registerLayerDefinition);
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        CrittersAndCompanionsClient.registerEntityRenderers(event::registerEntityRenderer);
    }

    @SubscribeEvent
    public static void addEntityLayers(EntityRenderersEvent.AddLayers event) {
        for (String skinName : event.getSkins()) {
            LivingEntityRenderer<Player, PlayerModel<Player>> skinRenderer = event.getSkin(skinName);
            if (skinRenderer != null) {
                skinRenderer.addLayer(new BubbleLayer(skinRenderer, event.getEntityModels()));
            }
        }
    }

    @Mod.EventBusSubscriber(modid = CrittersAndCompanions.MODID, value = Dist.CLIENT)
    public static class ForgeEvents {

        @SubscribeEvent
        public static void renderSilkLeash(GeoRenderEvent.Entity.Post event) {
            SilkLeashRenderer.renderSilkLeash(event);
        }

    }

}
