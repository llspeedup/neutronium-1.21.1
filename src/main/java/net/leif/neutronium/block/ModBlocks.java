package net.leif.neutronium.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.leif.neutronium.Neutronium;
import net.leif.neutronium.block.custom.MagicBlock;
import net.leif.neutronium.block.custom.TransformBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block URANIUM_ORE = registerBlock("uranium_ore", new Block(AbstractBlock.Settings.create()
            .strength(3f)
            .requiresTool()
            .sounds(BlockSoundGroup.STONE)
    ));
    public static final Block URANIUM_DEEPSLATE_ORE = registerBlock("uranium_deepslate_ore", new Block(AbstractBlock.Settings.create()
            .strength(4f)
            .requiresTool()
            .sounds(BlockSoundGroup.DEEPSLATE)
    ));
    public static final Block BOOM_BLOCK = registerBlock("boom_block", new MagicBlock(AbstractBlock.Settings.create()
            .strength(4f))
    );
    public static final Block UNENRICHED_URANIUM_BLOCK = registerBlock("unenriched_uranium_block", new Block(AbstractBlock.Settings.create()
            .strength(4f)
            .requiresTool()
    ));
    public static final Block ENRICHED_URANIUM_BLOCK = registerBlock("enriched_uranium_block", new Block(AbstractBlock.Settings.create()
            .strength(4f)
            .requiresTool()
            .luminance(state -> 7)
    ));
    public static final Block TEMP_URANIUM_ENRICHER = registerBlock("temp_uranium_enricher", new TransformBlock(AbstractBlock.Settings.create()
            .strength(3f)
    ));


    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(Neutronium.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Neutronium.MOD_ID, name), block);
    }

    public static void registerModBlocks(){
        Neutronium.LOGGER.info("Registering items for " + Neutronium.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries ->{
            entries.add(URANIUM_ORE);
            entries.add(URANIUM_DEEPSLATE_ORE);
            entries.add((UNENRICHED_URANIUM_BLOCK));
            entries.add((ENRICHED_URANIUM_BLOCK));
            entries.add((BOOM_BLOCK));
        });
    }
}
