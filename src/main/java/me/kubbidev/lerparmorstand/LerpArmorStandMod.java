package me.kubbidev.lerparmorstand;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class LerpArmorStandMod implements ClientModInitializer {

    public static final String MOD_ID = "lerparmorstand";

    /**
     * The static mod logger instance.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("Successfully initialized!");
    }
}
