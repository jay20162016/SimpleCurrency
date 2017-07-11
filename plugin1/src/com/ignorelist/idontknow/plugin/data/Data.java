package com.ignorelist.idontknow.plugin.data;

import java.io.File;

import org.bukkit.Server;

public abstract class Data {
	public File storagefile;
	public Data(File storagefile){
		this.storagefile = storagefile;
	}
	
	public abstract void load(Server server);
	
	public abstract void save();
}
