package com.locydragon.ac.commands;

import com.locydragon.ac.AudioCustomed;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * @author LocyDragon
 */
public class CommandExpresser implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		if (sender.isOp() && args[0].equalsIgnoreCase("reload")) {
			AudioCustomed.plugin.reloadConfig();
			AudioCustomed.config = AudioCustomed.plugin.getConfig();
			sender.sendMessage(ChatColor.GREEN + "重载配置文件完成了.");
		}
		return false;
	}
}
