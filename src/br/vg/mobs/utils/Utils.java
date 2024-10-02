package br.vg.mobs.utils;

import org.bukkit.ChatColor;

public class Utils {

	public static String colorize(String txt) {
		return ChatColor.translateAlternateColorCodes('&', txt);
	}
}
