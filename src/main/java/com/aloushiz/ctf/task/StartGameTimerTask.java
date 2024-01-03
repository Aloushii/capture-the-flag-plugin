package com.aloushiz.ctf.task;

import com.aloushiz.ctf.CaptureTheFlag;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class StartGameTimerTask extends BukkitRunnable {
    private int counter = 30;

    @Override
    public void run() {
        counter--;
        if (counter != 0) {
            Bukkit.broadcastMessage("§7[CTF] §3Starting in " + counter + " §3seconds");
        } else {
            CaptureTheFlag.getGame().start();
            Bukkit.broadcastMessage("§7[CTF] §3Game has started !");
            cancel();
        }
    }
}
