package net.leif.neutronium;

import net.fabricmc.api.ModInitializer;

import net.leif.neutronium.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Neutronium implements ModInitializer {
	public static final String MOD_ID = "neutronium";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}