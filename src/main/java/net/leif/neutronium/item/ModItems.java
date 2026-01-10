package net.leif.neutronium.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.leif.neutronium.Neutronium;
import net.leif.neutronium.item.custom.AtomicHammerItem;
import net.leif.neutronium.item.custom.WoodWandItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RAW_URANIUM = registerItem("raw_uranium", new Item(new Item.Settings()));
    public static final Item UNENRICHED_URANIUM = registerItem("unenriched_uranium", new Item(new Item.Settings()));
    public static final Item ENRICHED_URANIUM = registerItem("enriched_uranium", new Item(new Item.Settings()));
    public static final Item WOOD_WAND = registerItem("wood_wand", new WoodWandItem(new Item.Settings().maxDamage(64)));
    public static final Item ATOMIC_HAMMER = registerItem("atomic_hammer", new AtomicHammerItem(new Item.Settings()));
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Neutronium.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Neutronium.LOGGER.info("Registering items for " + Neutronium.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAW_URANIUM);
            entries.add(UNENRICHED_URANIUM);
            entries.add(ENRICHED_URANIUM);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(WOOD_WAND);
        });
    }
}
