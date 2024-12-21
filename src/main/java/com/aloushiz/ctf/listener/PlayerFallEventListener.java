package com.aloushiz.ctf.listener;

import com.aloushiz.ctf.CaptureTheFlag;
import com.aloushiz.ctf.game.GameState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import com.aloushiz.ctf.game.Game;

public class PlayerFallEventListener implements Listener {
    @EventHandler
    public void onPlayerFall(EntityDamageEvent event) {
        Game game = CaptureTheFlag.getGame();

        if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
            if (event.getEntity() instanceof Player){
                Player player = (Player) event.getEntity();
                if (game.getGameState() == GameState.TIMER || game.getGameState() == GameState.WAITING) {
                    player.setFallDistance(0);
                    event.setCancelled(true);
                }
            }
        }

    }
}
