package com.aelatis.minecraft.wolftag;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * WolfTag plugin for Bukkit
 *
 * @author amdprophet
 */
public class WolfTag extends JavaPlugin {
    private final WTPlayerListener playerListener = new WTPlayerListener();
    public static Logger log;

    public void onDisable() {
    	log.info("WolfTag Disabled!");
    }

    public void onEnable() {
    	log = getServer().getLogger();
    	
        // Register our events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvent(Event.Type.PLAYER_INTERACT_ENTITY, playerListener, Priority.Normal, this);

        // EXAMPLE: Custom code, here we just output some info so we can check all is well
        PluginDescriptionFile pdfFile = this.getDescription();
        log.info( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
    }
}
