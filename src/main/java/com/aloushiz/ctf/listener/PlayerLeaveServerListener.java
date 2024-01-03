package com.aloushiz.ctf.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveServerListener implements Listener {

    @EventHandler
    public void onPlayerLeaverServer(PlayerQuitEvent event) {
        event.setQuitMessage(ChatColor.LIGHT_PURPLE + event.getPlayer().getName()
                + ChatColor.DARK_AQUA + " has left Capture the Flag "
                + ChatColor.LIGHT_PURPLE
                + "(" + (Bukkit.getOnlinePlayers().size() - 1) + "/20)");
    }


}
