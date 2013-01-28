package net.LoadingChunks.DiamondShards;

/*
    This file is part of DiamondShards

    Foobar is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Foobar is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import net.LoadingChunks.SpringCoil.api.*;

public class DiamondShards extends JavaPlugin {
	
	/* TODO */
	// tp
	// Find way to communicate with BungeeCord

	//ClassListeners
	private DiamondShardsCommandExecutor commandExecutor;
	private DiamondShardsEventListener eventListener;
	//ClassListeners
	
	private Coil coil;

	public void onDisable() {
		// add any code you want to be executed when your plugin is disabled
	}

	public void onEnable() { 

		PluginManager pm = this.getServer().getPluginManager();
		
		commandExecutor = new DiamondShardsCommandExecutor(this);
		eventListener = new DiamondShardsEventListener(this); 

		getCommand("tp").setExecutor(commandExecutor);
		getCommand("tphere").setExecutor(commandExecutor);
		getCommand("su").setExecutor(commandExecutor);

		pm.registerEvents(eventListener, this);
	}
	
	public Coil getCoilAPI() {
		if(this.coil == null)
		{
			RegisteredServiceProvider<Coil> provider = getServer().getServicesManager().getRegistration(Coil.class);
	        Coil api = provider.getProvider();
	        this.coil = api;
		}
		return this.coil;
	}
}
