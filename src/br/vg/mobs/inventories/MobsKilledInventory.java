package br.vg.mobs.inventories;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import br.vg.mobs.utils.Utils;

public class MobsKilledInventory {
	
	private Player player;
	private final String invTitle;
	private final Inventory inv;
	
	public MobsKilledInventory(Player player) {
		this.player = player;
		
		this.invTitle = Utils.colorize("&8Mobs killed by " + this.getPlayerName());
		this.inv = Bukkit.createInventory(null, 3 * 9, invTitle);
	}
	
	public String getPlayerName() {
		return this.player.getName();
	}
	
	public void openInventory() {
		player.openInventory(inv);
	}
}
