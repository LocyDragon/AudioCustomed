package com.locydragon.ac;

import com.locydragon.ac.commands.CommandExpresser;
import com.locydragon.ac.listeners.CustomListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author LocyDragon
 */
public class AudioCustomed extends JavaPlugin {
	public static FileConfiguration config;
	public static AudioCustomed plugin;
	@Override
	public void onEnable() {
		saveDefaultConfig();
		Bukkit.getPluginManager().registerEvents(new CustomListener(), this);
		config = getConfig();
		Bukkit.getPluginCommand("acu").setExecutor(new CommandExpresser());
		plugin = this;
	}
}
