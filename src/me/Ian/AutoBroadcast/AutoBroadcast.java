		//Welcome to Ian's first Minecraft plugin, AutoBroadcast! - jthort
		//To start the broadcaster, do /amstart
		//after a reload (/reload) the plugin stops working until you use /amstart again
		//To stop the broadcaster, do /amstop
		//DO NOT DO /AMSTART WHEN IT IS LOADING!
		//If the timer is wrong, reload the plugin

package me.Ian.AutoBroadcast;


import java.util.logging.Logger;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AutoBroadcast extends JavaPlugin implements Listener {
	public final Logger logger = Logger.getLogger("Minecraft");
	public  AutoBroadcast plugin;
	public static int nums = 0;
	public static int counter = 1;
	public static int num2 = 0;
	public static int bugfix = 0;
	
	protected String Chatcolor;
		final String message = ("Visit our website at www.economicallycrafted.enjin.com");
		final String message2 = ("Don't forget to vote at www.economicallycrafted.enjin.com");
		final String message3 = ("Don't forget to check both our RPG, and Survival part of the server!");

	@Override
	public void onEnable(){
		logger.info("Automessage Enabled!");	
		 PluginManager pm = this.getServer().getPluginManager();
		 pm.registerEvents(this, this);
		 
		 
	}
	@Override
	public void onDisable(){
		logger.info("Ian's Automessager has been Disabled");	
	}
	
	
@Override
	public boolean onCommand(final CommandSender sender, Command cmd, final String commandLabel, String[] args){
		
		final Player player = (Player) sender;
		if(commandLabel.equalsIgnoreCase("AmStop")){
			bugfix++;
			if (bugfix >= 2){
				player.sendMessage(ChatColor.BLUE + "[AutoBroadcast] " + ChatColor.RED + "AutoBroadcaster is already stopped!" );
				
			}else{
				nums = 4;
				counter = 1;
				num2 = 0;
				player.sendMessage(ChatColor.BLUE + "[AutoBroadcast] " + "Now stopping the message " + ChatColor.DARK_GRAY +  message);
			}
		}
    	if(commandLabel.equalsIgnoreCase("AmStart")){
    		bugfix = 0;
    		if (nums == 0){
    			
    		
    		if (num2 == 0 | player.hasPermission("Am.start")){
    			if (counter == 1){
    			
    		
    		player.sendMessage(ChatColor.BLUE + "Now running the auto message " + ChatColor.DARK_GRAY +  message);
    		counter--;
    	if (counter == 0 && nums < 3){
    		
    		num2++;
		
    		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){

				@Override
				public void run() {
					
					if (nums == 0){
						 Bukkit.broadcastMessage(ChatColor.BLUE + "[AutoMessager] " + ChatColor.GRAY + message);
				    	}else if (nums == 1){
				    		Bukkit.broadcastMessage(ChatColor.BLUE + "[AutoMessager] " + ChatColor.GRAY + message2);
				    	}else if (nums == 2){
				    		Bukkit.broadcastMessage(ChatColor.BLUE + "[AutoMessager] " + ChatColor.GRAY + message3);
				    	}
						 nums++;
						if (nums == 3){
							nums = 0;
						}if (nums == 4){
							player.sendMessage(ChatColor.BLUE + "[AutoBroadcast] " + "Now stopping the auto message " + ChatColor.DARK_GRAY +  message);
							nums = 0;
						}
						if (counter >= 1){
							counter = 0;
						}
				}
    		    // your run-method here
    		}, 0, 200);
    		
    		
    		
    		
    	}else if (counter > 1){
    		player.sendMessage(ChatColor.BLUE + "[AutoBroadcast] " + ChatColor.RED + "You are already running AutoMessager!" );
    		player.sendMessage(ChatColor.BLUE + "[AutoBroadcast] " + ChatColor.RED + "If AutoMessager is not running, conatact the plugin manager!");
    	}else{
    		player.sendMessage(ChatColor.RED + "Error with plugin code 2, contact Ian!");
    	}

    			}else{
    				player.sendMessage(ChatColor.BLUE + "[AutoBroadcast] " + ChatColor.RED + "You are already running AutoBroadcast");
    			}
    	    	

    	    	
    			
    			
    			
    			}else{
    				player.sendMessage(ChatColor.BLUE + "[AutoBroadcast] " + ChatColor.RED + "You don't have the required permission Am.start");
    			}
    		}else{
    			if (nums >= 4){
    			player.sendMessage(ChatColor.RED + "AutoBroadcaster is now starting up again, please wait...");
    				nums = 0;
    				counter = 1;
    			}else{
    				player.sendMessage(ChatColor.BLUE + "[AutoBroadcast] " + ChatColor.RED + "AutoBroadcaster is already running!");
    			}
    			
    		}
		
    	}
		return true;
		
    	
    	
		

	
	
	}

	
}