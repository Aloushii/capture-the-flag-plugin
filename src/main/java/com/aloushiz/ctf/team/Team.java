package com.aloushiz.ctf.team;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Team {

    private String name;
    private int points;
    private Location spawn;
    private List<UUID> playerList;
    private TeamColor teamColor;

    public Team(String name, Location spawn, TeamColor teamColor) {
        this.name = name;
        this.points = 0;
        this.spawn = spawn;
        this.playerList = new ArrayList<>();
        this.teamColor = teamColor;
    }

    public void addPlayer(Player player) {
        if (!playerList.contains(player.getUniqueId())) {
            playerList.add(player.getUniqueId());
        }
    }

    public void removePlayer(Player player) {
        playerList.remove(player.getUniqueId());
    }

    public boolean containsPlayer(Player player) {
        return playerList.contains(player.getUniqueId());
    }

    public int size() {
       return playerList.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Location getSpawn() {
        return spawn;
    }

    public void setSpawn(Location spawn) {
        this.spawn = spawn;
    }

    public TeamColor getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(TeamColor teamColor) {
        this.teamColor = teamColor;
    }
}