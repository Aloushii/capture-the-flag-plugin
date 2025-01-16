package com.aloushiz.ctf.listener.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class SpawnEggListener implements Listener {

    @EventHandler
    public void onSpawnEgg(CreatureSpawnEvent event){
       if (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER_EGG){
           event.setCancelled(true);
       }
    }
}
