package net.leif.neutronium.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.leif.neutronium.Neutronium;
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
        });
    }
}
