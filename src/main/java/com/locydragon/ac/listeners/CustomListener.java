package com.locydragon.ac.listeners;

import com.locydragon.abf.api.AudioBufferAPI;
import com.locydragon.ac.AudioCustomed;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;

/**
 * @author LocyDragon
 */
public class CustomListener implements Listener {
	@EventHandler
	public void onHeldChange(PlayerItemHeldEvent e) {
		AudioBufferAPI.playFor(e.getPlayer(), AudioCustomed.config.getString("Held"));
	}

	@EventHandler
	public void onShoot(EntityShootBowEvent e) {
		if (e.getEntity() instanceof Player) {
			Player target = (Player)e.getEntity();
			AudioBufferAPI.playFor(target, AudioCustomed.config.getString("Shoot"));
		}
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		AudioBufferAPI.playFor(e.getEntity(), AudioCustomed.config.getString("Death"));
	}

	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player who = (Player)e.getDamager();
			if (who.getItemInHand() == null || who.getItemInHand().getType() == Material.AIR) {
				AudioBufferAPI.playFor(who, AudioCustomed.config.getString("HitEntityByHand"));
			} else if (who.getItemInHand().getType() == Material.DIAMOND_SWORD) {
				AudioBufferAPI.playFor(who, AudioCustomed.config.getString("HitEntityByDiamondSword"));
			}
		}
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		AudioBufferAPI.playFor(e.getPlayer(), AudioCustomed.config.getString("Chat"));
	}

	@EventHandler
	public void onDeath(EntityDeathEvent e) {
		if (e.getEntity().getKiller() != null) {
			Player target = e.getEntity().getKiller();
			AudioBufferAPI.playFor(target, AudioCustomed.config.getString("Kill"));
		}
	}
}
