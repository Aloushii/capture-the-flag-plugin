package com.aloushiz.ctf.listener.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItemListener implements Listener {

    @EventHandler
    public void onDropItem(PlayerDropItemEvent event){
        event.setCancelled(true);
    }
}
