package net.leif.neutronium;

import net.fabricmc.api.ModInitializer;

import net.leif.neutronium.block.ModBlocks;
import net.leif.neutronium.block.entity.ModBlockEntities;
import net.leif.neutronium.item.ModItemGroups;
import net.leif.neutronium.item.ModItems;
import net.leif.neutronium.screen.ModScreenHandlers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Neutronium implements ModInitializer {
	public static final String MOD_ID = "neutronium";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerModItemGroups();
		ModBlockEntities.registerModBlockEntities();
		ModScreenHandlers.registerModScreenHandlers();
	}
}