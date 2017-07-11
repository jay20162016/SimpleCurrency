package com.ignorelist.idontknow.plugin;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.ignorelist.idontknow.plugin.data.EconomyData;

public class Plugin extends JavaPlugin {
	public Logger log;
	public EconomyData econdata;
	String datafdr;
	
   @Override
    public void onEnable() {
       this.log=getLogger();
       datafdr = this.getDataFolder().getAbsolutePath();
       this.getDataFolder().mkdirs();
       econdata = new EconomyData(new File(datafdr + File.pathSeparator + "econdata.txt"));
    }
   
    @Override
    public void onDisable() {
       
    }
    
    @Override
    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args){
		switch (label){
		case "welcome":
			if (!(sender instanceof Player)){
					getServer().broadcastMessage("Welcome to the Server, "+args[0]+"!");
	    				return true;
	    		}
	    				
    	default:
	    		return false;
    	}
    }
}
