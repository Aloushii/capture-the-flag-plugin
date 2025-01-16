package com.aloushiz.ctf.listener.player;

import com.aloushiz.ctf.CaptureTheFlag;
import com.aloushiz.ctf.game.GameState;
import com.aloushiz.ctf.task.StartGameTimerTask;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerJoinServerListener implements Listener {

    @EventHandler
    public void onPlayerJoinServer(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendTitle("§e§lCapture The Flag", "§7The game will start shortly...",
                5, 60,5);
        event.setJoinMessage("§7[CTF] " + ChatColor.LIGHT_PURPLE + player.getName()
                + ChatColor.DARK_AQUA + " has joined Capture the Flag "
                + ChatColor.LIGHT_PURPLE + "(" + CaptureTheFlag.getPlugin().getServer().getOnlinePlayers().size() + "/20)");
        player.teleport(new Location(player.getWorld(), -1164.5, 92.5, 440.5));
        player.getInventory().clear();
        player.setFoodLevel(20);
        player.setMaxHealth(40);
        player.setHealth(40);
        player.setGameMode(GameMode.SURVIVAL);
        ItemStack redWool = new ItemStack(Material.RED_WOOL);
        ItemStack blueWool = new ItemStack(Material.BLUE_WOOL);
        player.getInventory().addItem(redWool, blueWool);

        if (Bukkit.getOnlinePlayers().size() > 1 && CaptureTheFlag.getGame().getGameState() == GameState.WAITING) {
            CaptureTheFlag.getGame().setGameState(GameState.TIMER);
            new StartGameTimerTask().runTaskTimer(CaptureTheFlag.getPlugin(), 200L, 20L);
        }

    }

}
