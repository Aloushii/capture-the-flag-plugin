package com.aloushiz.ctf.listener;

import com.aloushiz.ctf.CaptureTheFlag;
import com.aloushiz.ctf.game.GameState;
import com.aloushiz.ctf.team.TeamColor;
import com.aloushiz.ctf.team.TeamManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerJoinTeamListener implements Listener {

    @EventHandler
    public void onPlayerJoinTeam(PlayerInteractEvent event) {
        if (CaptureTheFlag.getGame().getGameState() == GameState.WAITING) {
            if (event.getMaterial() == Material.RED_WOOL) {
                event.getPlayer().sendMessage(ChatColor.DARK_AQUA
                        + "You successfully joined the" + ChatColor.RED + " red §r§3team!");
                TeamManager.clearPlayerTeam(event.getPlayer());
                TeamManager.getTeamByName(TeamColor.RED).addPlayer(event.getPlayer());

            } else if (event.getMaterial() == Material.BLUE_WOOL) {
                event.getPlayer().sendMessage(ChatColor.DARK_AQUA
                        + "You successfully joined the §r§9blue §r§3team!");
                TeamManager.clearPlayerTeam(event.getPlayer());
                TeamManager.getTeamByName(TeamColor.BLUE).addPlayer(event.getPlayer());
            }
        }
    }
}
