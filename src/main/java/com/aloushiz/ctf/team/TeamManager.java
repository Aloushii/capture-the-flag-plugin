package com.aloushiz.ctf.team;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class TeamManager {
    private static final List<Team> teamList = new ArrayList<>();

    public static void addTeam(Team team) {
        teamList.add(team);
    }

    public static List<Team> getTeamList() {
        return teamList;
    }

    public static Team getTeamByName(TeamColor teamColor) {
        for (Team team : teamList) {
            if (team.getTeamColor() == teamColor)
                return team;
        }
        return null;
    }

    public static void clearPlayerTeam(Player player) {
        for (Team team : teamList) {
            if (team.containsPlayer(player)) {
                team.removePlayer(player);
            }
        }
    }

    public static Team getTeamByPlayer(Player player) {
        for (Team team : teamList) {
            if (team.containsPlayer(player)) {
                return team;
            }
        }
        return null;
    }

    public static boolean playerHasTeam(Player player) {
        return getTeamByPlayer(player) != null;
    }

    public static void assignTeamToTeamlessPlayers() {
        Bukkit.getOnlinePlayers()
                .stream()
                .filter(player -> !playerHasTeam(player))
                .forEach(player -> {
                    Team smalestTeam = null;
                    for (Team team : teamList) {
                        if (smalestTeam == null) {
                            smalestTeam = team;
                        } else if (team.size() < smalestTeam.size()) {
                            smalestTeam = team;
                        }
                    }
                    Objects.requireNonNull(smalestTeam).addPlayer(player);
                });
    }

    public static void teleportAllPlayersToTeamSpawn() {
        for (Team team : teamList) {
            for (UUID playerUuid : team.getPlayerList()) {
                Player player = Bukkit.getPlayer(playerUuid);
                if (player != null) {
                    player.teleport(team.getSpawn());
                }
            }
        }
    }

    public static boolean playersInSameTeam(Player player1, Player player2) {
        return Objects.equals(getTeamByPlayer(player1), getTeamByPlayer(player2));
    }

    public static void givePlayersBaseKits(){
        for (Team team : teamList) {
            for (UUID playerUuid : team.getPlayerList()) {
                Player player = Bukkit.getPlayer(playerUuid);
                player.getInventory().clear();

                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metaBoots = (LeatherArmorMeta) boots.getItemMeta();
                metaBoots.setColor(team.getColor());
                metaBoots.setUnbreakable(true);
                boots.setItemMeta(metaBoots);

                ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metaChest = (LeatherArmorMeta) chest.getItemMeta();
                metaChest.setColor(team.getColor());
                metaChest.setUnbreakable(true);
                chest.setItemMeta(metaBoots);

                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta metaHelmet = (LeatherArmorMeta) helmet.getItemMeta();
                metaHelmet.setColor(team.getColor());
                metaHelmet.setUnbreakable(true);
                helmet.setItemMeta(metaHelmet);

                ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metaLegs = (LeatherArmorMeta) legs.getItemMeta();
                metaLegs.setColor(team.getColor());
                metaLegs.setUnbreakable(true);
                legs.setItemMeta(metaLegs);

                ItemStack woodenSword = new ItemStack(Material.WOODEN_SWORD);
                ItemMeta metaWoodenSword = woodenSword.getItemMeta();
                metaWoodenSword.setUnbreakable(true);
                woodenSword.setItemMeta(metaWoodenSword);
                ItemStack[] weapons = new ItemStack[] {woodenSword};

                ItemStack[] baseArmorSet = new ItemStack[] {boots, legs, chest, helmet};
                player.getInventory().setContents(weapons);
                player.getInventory().setArmorContents(baseArmorSet);
            }
        }
    }
}
