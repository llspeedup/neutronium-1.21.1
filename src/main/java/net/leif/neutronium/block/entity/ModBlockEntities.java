package net.leif.neutronium.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.leif.neutronium.Neutronium;
import net.leif.neutronium.block.ModBlocks;
import net.leif.neutronium.block.entity.custom.PedestalBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<PedestalBlockEntity> PEDESTAL_BE =
            Registry.register(
                    Registries.BLOCK_ENTITY_TYPE,
                    Identifier.of(Neutronium.MOD_ID, "pedestal_be"),
                    FabricBlockEntityTypeBuilder
                            .create(PedestalBlockEntity::new, ModBlocks.PEDESTAL)
                            .build()
            );

    public static void registerModBlockEntities(){
        Neutronium.LOGGER.info("Registering block entities for " + Neutronium.MOD_ID);
    }
}
