package me.sirgregg.gchantessentials;

import me.sirgregg.gchantessentials.enchants.ExplosiveEnchant;
import me.sirgregg.gchantessentials.enchants.JumpEnchant;
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
		new JumpEnchant();
		new ExplosiveEnchant();
	}

	public GchantEssentials getInstance() {
		return instance;
	}
}
