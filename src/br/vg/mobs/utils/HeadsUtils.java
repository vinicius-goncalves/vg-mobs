package br.vg.mobs.utils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import br.vg.mobs.enums.Heads;

public class HeadsUtils {

	public static final PlayerProfile createPlayerProfile(String uuid) {
		PlayerProfile playerProfile = Bukkit.createPlayerProfile(UUID.randomUUID());
		PlayerTextures playerTextures = playerProfile.getTextures();
		
		URL url = null;
		
		try {
			url = URI.create(uuid).toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		playerTextures.setSkin(url);
		playerProfile.setTextures(playerTextures);
		
		return playerProfile;
	}
	
	public static final ItemStack getHead(String headName) {
		ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD, 1);
		
		for(Heads head : Heads.values()) {
			if(!head.getName().equals(headName)) {
				continue;
			}
			
			PlayerProfile playerProfile = HeadsUtils.createPlayerProfile(head.getTexture());
			
			SkullMeta skullMeta = (SkullMeta) itemStack.getItemMeta();
			skullMeta.setDisplayName(head.getDisplayName());
			skullMeta.setOwnerProfile(playerProfile);
			itemStack.setItemMeta(skullMeta);
			return itemStack;
		}
		
		return itemStack;
	}
}