package com.aelatis.minecraft.wolftag;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.entity.CraftWolf;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerListener;

/**
 * Handle events for all Player related events
 * @author amdprophet
 */
public class WTPlayerListener extends PlayerListener {
	
    public WTPlayerListener() {
        
    }

    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
    	Entity entity = event.getRightClicked();
    	if (entity instanceof CraftWolf)
    	{
    		CraftWolf wolf = (CraftWolf) entity;
    		if ( wolf.isTamed() ) {
    			if (wolf.getOwner() == null) return;
    			String owner = ((Player) wolf.getOwner()).getDisplayName();
    			if ( !owner.equals(event.getPlayer().getDisplayName()) )
    			{
    				String wolfOwnerStr = ChatColor.RED + "Property of " + owner;
        			event.getPlayer().sendMessage(wolfOwnerStr);
    			}
    		}
    	}
    	
    }
}
