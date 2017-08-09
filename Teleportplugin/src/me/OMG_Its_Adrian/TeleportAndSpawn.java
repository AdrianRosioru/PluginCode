package me.OMG_Its_Adrian;

public class TeleportAndSpawn {
	
Public class Spawn extends JavaPlugin {
	
	public void onEnable() {
		
	}
	
	public void onDisable() {
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "This plugin is for players only") ;
		}
		
		Playerp = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("tp")) {
			if (args.length == 0) {
				p.sendMessage(ChatColor.RED + "Please specify a player");
				return true;
			}
			Player target = bukkit.getServer().getPlayer(args[0]);
			if (target == null) {
				p.sendMessage(ChatColor.RED + "Could not find player" + args[0] + "!");
				return true;
			}
			p.teleport(target.getLocation());
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("setspawn")) {
			getConfig.set("spawn.world", p.getLocation().getWorld());
			getConfig.set("spawn.x", p.getLocation().getX());
			getConfig.set("spawn.y", p.getLocation().getY());
			getConfig.set("spawn.z", p.getLocation().getZ());
			getConfig.set("spawn.pitch", p.getLocation().getPitch());
			getConfig.set("spawn.yaw", p.getLocation().getYaw());
			saveConfig();
			p.sendMessage(ChatColor.GREEN + "Spawn set!");
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("spawn")) {
			if (getConfig().getConfigurationSection("spawn") ==null) {
				p.sendMessage(ChatColor.RED = "The spawn has not yet been set!");
				return true;
			}
			World w = Bukkit.getServer().getWorld(getConfig().getString("spawn.world"));
			double x = getConfig().getDouble("spawn.x");
			double y = getConfig().getDouble("spawn.y");
			double z = getConfig().getDouble("spawn.z");
			p.teleport(new Location(w, x, y, z));
			p.sendMessage(ChatColor.GREEN + "Welcome to the spawn");
			
		}
		return false;
	}
}
	
