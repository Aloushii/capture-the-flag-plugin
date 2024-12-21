package com.aloushiz.ctf.team;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Team {

    private final String name;
    private final Location spawn;
    private final List<UUID> playerList;
    private final TeamColor teamColor;
    private final Color color;
    private int points;

    public Team(String name, Location spawn, TeamColor teamColor, Color color) {
        this.name = name;
        this.points = 0;
        this.spawn = spawn;
        this.playerList = new ArrayList<>();
        this.teamColor = teamColor;
        this.color = color;
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Location getSpawn() {
        return spawn;
    }

    public TeamColor getTeamColor() {
        return teamColor;
    }

    public List<UUID> getPlayerList() {
        return playerList;
    }

    public Color getColor() {
        return color;
    }

    /*
    public Inventory getTeamInventory(){}
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}