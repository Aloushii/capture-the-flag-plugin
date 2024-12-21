package com.aloushiz.ctf.listener;

import com.aloushiz.ctf.team.Team;
import com.aloushiz.ctf.team.TeamManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.Objects;

public class PlayerRespawnListener implements Listener {

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        event.setRespawnLocation(Objects.requireNonNull(TeamManager.getTeamByPlayer(event.getPlayer())).getSpawn());
        Player player = event.getPlayer();
        Team team = TeamManager.getTeamByPlayer(player);
        assert team != null;
        TeamManager.givePlayerBaseKit(player, team.getColor());
    }
}
