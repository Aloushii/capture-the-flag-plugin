package com.aloushiz.ctf.listener;

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

        event.setJoinMessage("§7[CTF] " + ChatColor.LIGHT_PURPLE + player.getName()
                + ChatColor.DARK_AQUA + " has joined Capture the Flag "
                + ChatColor.LIGHT_PURPLE + "(" + CaptureTheFlag.getPlugin().getServer().getOnlinePlayers().size() + "/20)");
        player.teleport(new Location(player.getWorld(), 42.5, 178.0, 463.5));
        player.getInventory().clear();
        player.setFoodLevel(20);
        player.setMaxHealth(40);
        player.setHealth(40);
        player.setGameMode(GameMode.SURVIVAL);
        ItemStack redWool = new ItemStack(Material.RED_WOOL);
        ItemStack blueWool = new ItemStack(Material.BLUE_WOOL);
        player.getInventory().addItem(redWool, blueWool);

        if (Bukkit.getOnlinePlayers().size() > 1 && CaptureTheFlag.getGame().getGameState() == GameState.WAITING) {
            new StartGameTimerTask().runTaskTimerAsynchronously(CaptureTheFlag.getPlugin(), 0L, 20L);
        }

    }

}
