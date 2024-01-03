package com.aloushiz.ctf.listener;

import com.aloushiz.ctf.CaptureTheFlag;
import com.aloushiz.ctf.game.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerHitListener implements Listener {

    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent event) {
        if (CaptureTheFlag.getGame().getGameState() == GameState.WAITING) {
            event.setCancelled(true);
        }
    }
}

