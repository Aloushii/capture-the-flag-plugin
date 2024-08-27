package com.aloushiz.ctf.listener;

import com.aloushiz.ctf.CaptureTheFlag;
import com.aloushiz.ctf.game.GameState;
import com.aloushiz.ctf.team.TeamManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerHitListener implements Listener {

    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }

        if (CaptureTheFlag.getGame().getGameState() == GameState.WAITING) {
            event.setCancelled(true);
        }

        Player playerVictim = (Player) event.getEntity();

        Entity entityDamager = event.getDamager();

        if (entityDamager instanceof Player) {
            Player playerDamager = (Player) entityDamager;

            if (TeamManager.playersInSameTeam(playerDamager, playerVictim)) {
                event.setCancelled(true);
            }
        }
        if ((event.getEntity() instanceof Player) && (event.getDamager() instanceof Projectile) &&
                (((Projectile) event.getDamager()).getShooter() instanceof Player)) {
            Player victim = (Player) event.getEntity();
            Player damager = ((Player) ((Projectile) event.getDamager()).getShooter());

            if (TeamManager.playersInSameTeam(victim, damager)){
                event.setCancelled(true);
            }
        }
    }
}

