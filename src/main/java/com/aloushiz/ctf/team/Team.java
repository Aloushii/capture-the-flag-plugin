package com.aloushiz.ctf.team;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Team {

    private String name;
    private int points = 0;
    private Location spawn;

    private List<UUID> playerList = new ArrayList<>();

}
