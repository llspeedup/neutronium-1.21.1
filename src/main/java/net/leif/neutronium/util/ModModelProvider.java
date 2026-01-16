package net.leif.neutronium.util;

import com.ibm.icu.text.Normalizer2;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.leif.neutronium.block.ModBlocks;
import net.leif.neutronium.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TEMP_URANIUM_ENRICHER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.UNENRICHED_URANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENRICHED_URANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHROMIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHROMIUM_DEEPSLATE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_URANIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNENRICHED_URANIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENRICHED_URANIUM, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_CHROMIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHROMIUM_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.WOOD_WAND, Models.GENERATED);
        itemModelGenerator.register(ModItems.ATOMIC_HAMMER, Models.GENERATED);
    }
}
