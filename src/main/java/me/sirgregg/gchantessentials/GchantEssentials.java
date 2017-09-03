package me.sirgregg.gchantessentials;

import me.sirgregg.gchantessentials.enchants.SpeedEnchant;
import org.bukkit.plugin.java.JavaPlugin;

public class GchantEssentials extends JavaPlugin {
	private GchantEssentials instance;

	@Override
	public void onEnable() {
		instance = this;

		setupEnchants();
	}

	private void setupEnchants() {
		new SpeedEnchant();
	}

	public GchantEssentials getInstance() {
		return instance;
	}
}
