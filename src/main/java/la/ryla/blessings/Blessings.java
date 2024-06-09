package la.ryla.blessings;

import la.ryla.blessings.enchantment.PaceBlessingEnchantment;
import net.fabricmc.api.ModInitializer;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Blessings implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("blessings");
	public static Enchantment PACE_BLESSING_ENCHANTMENT = Registry.register(Registries.ENCHANTMENT,new Identifier("blessings","pace_blessing"),new PaceBlessingEnchantment());

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("pebis");
	}
}