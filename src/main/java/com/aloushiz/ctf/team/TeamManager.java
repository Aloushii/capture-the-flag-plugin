package com.aloushiz.ctf.team;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

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
}
