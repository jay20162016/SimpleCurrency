package com.ignorelist.idontknow.plugin;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.SignChangeEvent;

public class EventListener implements Listener {

	@EventHandler
	public void onSignChange(SignChangeEvent event){
		String[] lines = event.getLines();
		
		String starterline=lines[0];
		
		if (starterline == "[Sell]"){
			
		}
	}
	
	
}
