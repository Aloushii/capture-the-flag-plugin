package com.aloushiz.ctf.player.utils;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.Collection;

public class PlayerUtils {

    public static void sendTitleToPlayers(Collection<? extends Player> players, String title, String subtitle,
                                          int fadeIn, int stay, int fadeOut) {
        for (Player player : players) {
            player.sendTitle(title, subtitle, fadeIn, stay, fadeOut);
        }
    }

    public static void playSoundToPlayers(Collection<? extends Player> players, Sound sound, float volume, float pitch) {
        for (Player player : players) {
            player.playSound(player.getLocation(), sound, volume, pitch);
        }
    }
}
