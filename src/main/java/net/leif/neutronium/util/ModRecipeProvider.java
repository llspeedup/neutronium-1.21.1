package net.leif.neutronium.util;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.leif.neutronium.block.ModBlocks;
import net.leif.neutronium.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> UNENRICHED_URANIUM_SMELTABLES = List.of(
                ModItems.RAW_URANIUM,
                ModBlocks.URANIUM_ORE,
                ModBlocks.URANIUM_DEEPSLATE_ORE);

        offerSmelting(recipeExporter, UNENRICHED_URANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.UNENRICHED_URANIUM, 0.25f, 200, "unenriched_uranium");
        offerBlasting(recipeExporter, UNENRICHED_URANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.UNENRICHED_URANIUM, 0.25f, 100, "unenriched_uranium");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.UNENRICHED_URANIUM, RecipeCategory.MISC, ModBlocks.UNENRICHED_URANIUM_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ENRICHED_URANIUM, RecipeCategory.MISC, ModBlocks.ENRICHED_URANIUM_BLOCK);

        List<ItemConvertible> CHROMIUM_INGOT_SMELTABLES = List.of(
                ModItems.RAW_CHROMIUM,
                ModBlocks.CHROMIUM_ORE,
                ModBlocks.CHROMIUM_DEEPSLATE_ORE);

        offerSmelting(recipeExporter, CHROMIUM_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.CHROMIUM_INGOT, 0.25f, 200, "chromium_ingot");
        offerBlasting(recipeExporter, CHROMIUM_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.CHROMIUM_INGOT, 0.25f, 100, "chromium_ingot");
    }
}
