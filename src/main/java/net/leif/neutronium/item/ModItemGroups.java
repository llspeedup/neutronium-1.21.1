package net.leif.neutronium.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.leif.neutronium.Neutronium;
import net.leif.neutronium.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup ATOMIC_MATERIALS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Neutronium.MOD_ID, "atomic_materials"), FabricItemGroup.builder()
                            .icon(() -> new ItemStack(ModItems.ENRICHED_URANIUM))
                            .displayName(Text.translatable("itemgroup.neutronium.atomic_materials"))
                            .entries((displayContext, entries) -> {
                                entries.add(ModItems.RAW_URANIUM);
                                entries.add(ModItems.UNENRICHED_URANIUM);
                                entries.add(ModItems.ENRICHED_URANIUM);
                                entries.add(ModBlocks.URANIUM_DEEPSLATE_ORE);
                                entries.add(ModBlocks.URANIUM_ORE);
                                entries.add(ModBlocks.UNENRICHED_URANIUM_BLOCK);
                                entries.add(ModBlocks.ENRICHED_URANIUM_BLOCK);
                            })
                    .build());
    public static final ItemGroup MECHANICAL_MATERIALS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Neutronium.MOD_ID, "mechanical_materials"), FabricItemGroup.builder()
                            .icon(() -> new ItemStack(ModItems.MOTOR))
                            .displayName(Text.translatable("itemgroup:neutronium:mechanical_materials"))
                            .entries((displayContext, entries) -> {
                                entries.add(ModItems.MOTOR);
                            })
                    .build());


    public static void registerModItemGroups(){
        Neutronium.LOGGER.info("Registering mod item groups for " + Neutronium.MOD_ID);
    }
}
