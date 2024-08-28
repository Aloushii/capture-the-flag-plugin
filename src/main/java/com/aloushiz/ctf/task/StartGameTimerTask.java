package com.aloushiz.ctf.task;

import com.aloushiz.ctf.CaptureTheFlag;
import com.aloushiz.ctf.player.utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;

public class StartGameTimerTask extends BukkitRunnable {
    private int counter = 20;

    @Override
    public void run() {
        if (counter != 0) {
            if (counter <= 5) {
                PlayerUtils.sendTitleToPlayers(Bukkit.getOnlinePlayers(), "§e§lCapture the Flag",
                        "§7The game will start in §f" + counter + " §7seconds...", 5, 10, 5);
                PlayerUtils.playSoundToPlayers(Bukkit.getOnlinePlayers(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            } else if (counter % 10 == 0) {
                PlayerUtils.sendTitleToPlayers(Bukkit.getOnlinePlayers(), "§e§lCapture the Flag",
                        "§7The game will start in §f" + counter + " §7seconds...", 5, 30, 5);
                PlayerUtils.playSoundToPlayers(Bukkit.getOnlinePlayers(), Sound.UI_BUTTON_CLICK, 1, 1);
            }
        } else {
            CaptureTheFlag.getGame().start();
            PlayerUtils.sendTitleToPlayers(Bukkit.getOnlinePlayers(), "§cThe Game has Started !",
                    "§7Capture the enemy's flag", 0, 25, 5);
            PlayerUtils.playSoundToPlayers(Bukkit.getOnlinePlayers(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
            cancel();
        }
        counter--;
    }
}
