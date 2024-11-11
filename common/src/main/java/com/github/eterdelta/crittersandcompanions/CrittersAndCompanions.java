package com.github.eterdelta.crittersandcompanions;

import com.github.eterdelta.crittersandcompanions.entity.*;
import com.github.eterdelta.crittersandcompanions.handler.SpawnHandler;
import com.github.eterdelta.crittersandcompanions.network.CACPacketHandler;
import com.github.eterdelta.crittersandcompanions.platform.RegistryEntry;
import com.github.eterdelta.crittersandcompanions.platform.RegistryHelper;
import com.github.eterdelta.crittersandcompanions.platform.Services;
import com.github.eterdelta.crittersandcompanions.registry.CACBlocks;
import com.github.eterdelta.crittersandcompanions.registry.CACEntities;
import com.github.eterdelta.crittersandcompanions.registry.CACItems;
import com.github.eterdelta.crittersandcompanions.registry.CACSounds;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.item.CreativeModeTab;
import software.bernie.geckolib.GeckoLib;

import java.util.function.BiConsumer;

public class CrittersAndCompanions {
    public static final String MODID = "crittersandcompanions";

    private static final RegistryHelper<CreativeModeTab> CREATIVE_TABS = Services.PLATFORM.createRegistryHelper(Registries.CREATIVE_MODE_TAB, MODID);
    public static final RegistryEntry<CreativeModeTab> CREATIVE_TAB = CREATIVE_TABS.register("main", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .icon(() -> CACItems.PEARL_NECKLACE_1.get().getDefaultInstance())
            .title(Component.translatable("itemGroup." + MODID))
            .build()
    );

    public static void init() {
        GeckoLib.initialize();

        CACBlocks.init();
        CACEntities.init();
        CACItems.init();
        CACSounds.init();
    }

    public static void setup() {
        CACPacketHandler.registerPackets();
        SpawnHandler.registerSpawnPlacements();
    }

    public static void onAttributeCreation(BiConsumer<EntityType<? extends LivingEntity>, AttributeSupplier> event) {
        event.accept(CACEntities.OTTER.get(), OtterEntity.createAttributes().build());
        event.accept(CACEntities.JUMPING_SPIDER.get(), JumpingSpiderEntity.createAttributes().build());
        event.accept(CACEntities.KOI_FISH.get(), KoiFishEntity.createAttributes().build());
        event.accept(CACEntities.DRAGONFLY.get(), DragonflyEntity.createAttributes().build());
        event.accept(CACEntities.SEA_BUNNY.get(), SeaBunnyEntity.createAttributes().build());
        event.accept(CACEntities.SHIMA_ENAGA.get(), ShimaEnagaEntity.createAttributes().build());
        event.accept(CACEntities.FERRET.get(), FerretEntity.createAttributes().build());
        event.accept(CACEntities.DUMBO_OCTOPUS.get(), DumboOctopusEntity.createAttributes().build());
        event.accept(CACEntities.LEAF_INSECT.get(), LeafInsectEntity.createAttributes().build());
        event.accept(CACEntities.RED_PANDA.get(), RedPandaEntity.createAttributes().build());
    }

}
