package br.vg.mobs.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import br.vg.mobs.inventories.MobsKilledInventory;
import br.vg.mobs.utils.Utils;

public class MobsCommand implements CommandExecutor, TabCompleter {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return true;
		}
		
		final Player player = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("mobs")) {
			
			if(args.length == 0) {
				player.sendMessage("");
				player.sendMessage(Utils.colorize("&cUsage:"));
				player.sendMessage(Utils.colorize("    &e/mobs killed &c - to see mobs you've killed"));
				player.sendMessage(Utils.colorize("    &e/mobs nearby &c - to see nearby mobs"));
				player.sendMessage("");
				return true;
			}
			
			switch(args[0]) {
				case "killed":
					MobsKilledInventory mobsKilledInventory = new MobsKilledInventory(player);
					mobsKilledInventory.openInventory();
					
					break;
				
				case "nearby":
					player.sendMessage("nearby!");
					break;
			}
			
//			if(args[0].equalsIgnoreCase("nearby")) {
//				Collection<Entity> entities = player.getWorld().getNearbyEntities(player.getLocation(), 15, 15, 15);
//				HashMap<EntityType, Integer> mobs = new HashMap<>();
//				
//				for(Entity entity : entities) {
//					EntityType et = entity.getType();
//					if(et == EntityType.PLAYER && entity.getName() == player.getName()) continue;
//					mobs.put(et, mobs.containsKey(et) ? mobs.get(et) + 1 : 1);
//				}
//				
//				for(Entry<EntityType, Integer> mob: mobs.entrySet()) {
//					player.sendMessage("");
//					player.sendMessage("§aMob: §f" + mob.getKey().toString());
//					player.sendMessage("§aAmount: §fx" + mob.getValue());
//					player.sendMessage("");
//				}
//			}
		}
		
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] args) {
		if(args.length == 1) {
			String[] cmds = {"killed", "nearby"};
			ArrayList<String> commands = new ArrayList<String>();
			for(String cmd : cmds) commands.add(cmd);
			return commands;
		}
		
		return null;
	}
}
