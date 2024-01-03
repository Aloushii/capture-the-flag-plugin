package com.aloushiz.ctf.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerJoinTeamListener implements Listener {

    @EventHandler
    public void onPlayerJoinTeam(PlayerInteractEvent event) {
        if (event.getMaterial() == Material.RED_WOOL) {
            event.getPlayer().sendMessage(ChatColor.DARK_AQUA
                    + "You successfully joined the" + ChatColor.RED + " red §r§3team!");
            //event.getPlayer().teleport(new Location(event.getPlayer().getWorld(), 54.344, 178.0, 462.497));
        } else if (event.getMaterial() == Material.BLUE_WOOL) {
            event.getPlayer().sendMessage(ChatColor.DARK_AQUA
                    + "You successfully joined the §r§9blue §r§3team!");
            //event.getPlayer().teleport(new Location(event.getPlayer().getWorld(), 30.639, 178.0, 462.5));
        }

    }
}
