package com.ignorelist.idontknow.plugin.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.bukkit.Server;
import org.bukkit.entity.Player;

public class EconomyData extends Data {
	public EconomyData(File storagefile) {
		super(storagefile);
	}

	ArrayList<ArrayList<Object>> map = new ArrayList<ArrayList<Object>>();
			
	@SuppressWarnings("deprecation")
	@Override
	public void load(Server server) {
		DataInputStream dis;
		try {
			dis = new DataInputStream(new FileInputStream(storagefile));
			BufferedReader br = new BufferedReader(new InputStreamReader(dis));
			
			String line;
			String[] data;
			Player player;
			int amount;
			
			while ((line=br.readLine()) != null){
				data = line.split(" :");
				player=server.getPlayer(data[0]);
				amount = Integer.parseInt(data[1]);
				
				if (player == null){
					player=(Player) server.getOfflinePlayer(data[0]);
				}
				
				if (player == null){
					return;
				}
				
				ArrayList<Object> tmp1 = new ArrayList<Object>();
				tmp1.add(player);
				tmp1.add(amount);
				for (ArrayList<Object> i:map){
					if (i.get(0)==tmp1.get(0)){
						map.set(map.indexOf(i),tmp1);
					}
				}
			}
			
			br.close();
			dis.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void save() {
		FileWriter fw;
		try {
			fw = new FileWriter(this.storagefile);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (ArrayList<Object> i: map){
				try {
					bw.write(i.get(0) + ": " + i.get(1));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
	
	public int get(Player player){
		for (ArrayList<Object> i : map){
			if (i.get(0) == player){
				return ((int) i.get(1));
			}
		}
		return -1;
	}
	
	public void set(Player player,int amount){
		for (ArrayList<Object> i : map){
			if (i.get(0) == player){
				i.set(1, amount);
				return;
			}
		}
		ArrayList<Object> tmp = new ArrayList<Object>();
		tmp.add(player);
		tmp.add(amount);
		map.add(tmp);
	}
}
