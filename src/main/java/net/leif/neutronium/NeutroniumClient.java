package net.leif.neutronium;

import net.fabricmc.api.ClientModInitializer;
import net.leif.neutronium.block.entity.ModBlockEntities;
import net.leif.neutronium.block.entity.renderer.PedestalBlockEntityRenderer;
import net.leif.neutronium.screen.ModScreenHandlers;
import net.leif.neutronium.screen.custom.CentrifugeScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class NeutroniumClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockEntityRendererFactories.register(ModBlockEntities.PEDESTAL_BE, PedestalBlockEntityRenderer::new);
        HandledScreens.register(ModScreenHandlers.CENTRIFUGE_SCREEN_HANDLER, CentrifugeScreen::new);

    }
}
