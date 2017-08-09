package me.OMG_Its_Adrian;

public class RandomTeleporter {
	
public class Teleporter extends JavaPlugin {

		public void onEnable() {
		
		}
		
		public void onDisable() {
			
		}
		
		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			
			if (cmd.getName().equalsIgnoreCase("teleportme") && sender instanceof Player) {
				
				Player player = (Player) sender;
				
				Location original = player.getlocation();
				
				Random random = new Random();
				
				int x = random.nextInt(1000) + 1;
				int y = 150;
				int z = random.nextInt(1000) + 1;
				
				Location teleportLocation = new Location(player.getWorld(), x, y, z);
				
				player.teleport(teleportLocation);
				
				player.send.Message(ChatColor.GREEN + "You have been teleported " + (int)teleportLocation.distanc(originalLocation) + "blocks away!");
				
				return true;
				
			}
			
			return false;	
			
		}
		
	}

}
