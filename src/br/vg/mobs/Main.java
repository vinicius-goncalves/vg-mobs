package br.vg.mobs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import br.vg.mobs.commands.MobsCommand;
import br.vg.mobs.utils.HeadsUtils;
import br.vg.mobs.utils.Utils;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		Bukkit.getPluginCommand("mobs").setExecutor(new MobsCommand());
		Bukkit.getPluginCommand("mobs").setTabCompleter(new MobsCommand());
		Bukkit.getConsoleSender().sendMessage(Utils.colorize("&a[vgMobsKilled] Plugin initilized"));
		
		for(Player player : Bukkit.getOnlinePlayers()) {
			player.getInventory().addItem(HeadsUtils.getHead("spider"));
		}
	}
}
