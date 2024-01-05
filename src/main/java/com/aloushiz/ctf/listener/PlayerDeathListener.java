package com.aloushiz.ctf.listener;

import com.aloushiz.ctf.CaptureTheFlag;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Bukkit.getScheduler().runTaskLater(CaptureTheFlag.getPlugin(),
                () -> event.getEntity().spigot().respawn(),
                4L);
    }
}
