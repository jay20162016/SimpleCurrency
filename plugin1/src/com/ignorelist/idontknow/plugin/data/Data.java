package com.ignorelist.idontknow.plugin.data;

import java.io.File;
import java.io.IOException;

import org.bukkit.Server;

public abstract class Data {
	public File storagefile;
	public Data(File storagefile){
		this.storagefile = storagefile;
		if (!storagefile.exists())
			try {
				storagefile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public abstract void load(Server server);
	
	public abstract void save();
}
