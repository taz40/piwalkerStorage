package net.piwalker.storage;

import net.fabricmc.api.ModInitializer;
import net.piwalker.storage.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PiWalkerStorage implements ModInitializer {
	public static final String MOD_ID = "piwalker_storage";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing mod " + MOD_ID);
		ModBlocks.registerBlocks();
	}
}
