package com.aloushiz.ctf.listener.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

public class BucketEmptyListener implements Listener {

    @EventHandler
    public void onBucketEmpty(PlayerBucketEmptyEvent event){
        event.setCancelled(true);
    }
}
