package sustech.sustoilmd;

import net.fabricmc.api.ModInitializer;


import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sustech.sustoilmd.complexBlocks.Bio_Fridge;

public class SustoilMD implements ModInitializer {
	public static final String MOD_ID = "sustoilmd";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModBlocks.initialize();
		ModItems.initialize();
		ModItemGroups.initialize();
		Bio_Fridge.initialize();
		ModEntityTypes.initialize();
		ModScreenHandlers.registerAll();
		LOGGER.info("Hello Fabric world!");

	}
}