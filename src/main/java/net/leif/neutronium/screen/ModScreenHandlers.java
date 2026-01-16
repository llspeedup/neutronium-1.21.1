package net.leif.neutronium.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.leif.neutronium.Neutronium;
import net.leif.neutronium.screen.custom.CentrifugeScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<CentrifugeScreenHandler> CENTRIFUGE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Neutronium.MOD_ID, "centrifuge_screen_handler"),
                    new ExtendedScreenHandlerType<>(CentrifugeScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerModScreenHandlers(){
        Neutronium.LOGGER.info("Registering screen handlers for " + Neutronium.MOD_ID);
    }

}
