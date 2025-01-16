package com.aloushiz.ctf;

import com.aloushiz.ctf.game.Game;
import com.aloushiz.ctf.listener.block.BlockBreakEventListener;
import com.aloushiz.ctf.listener.block.BlockPlaceEventListener;
import com.aloushiz.ctf.listener.block.BucketEmptyListener;
import com.aloushiz.ctf.listener.block.SpawnEggListener;
import com.aloushiz.ctf.listener.player.*;
import com.aloushiz.ctf.team.Team;
import com.aloushiz.ctf.team.TeamColor;
import com.aloushiz.ctf.team.TeamManager;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public final class CaptureTheFlag extends JavaPlugin {

    private static CaptureTheFlag captureTheFlag = null;
    private static final Game game = new Game();

    @Override
    public void onEnable() {
        captureTheFlag = this;
        loadTeams();
        loadListeners();

        System.out.println("Plugin Capture the Flag has loaded");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void loadTeams() {
        TeamManager.addTeam(new Team(
                "RED",
                new Location(Bukkit.getWorld("world"), -64.5, 118, 469.5, 180, 0),
                TeamColor.RED, Color.RED));
        TeamManager.addTeam(new Team(
                "BLUE",
                new Location(Bukkit.getWorld("world"), 144.5, 118, 468.5, 180, 0),
                TeamColor.BLUE, Color.BLUE));

    }

    private void loadListeners() {
        getServer().getPluginManager().registerEvents(new PlayerDropItemListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinServerListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeaveServerListener(), this);
        getServer().getPluginManager().registerEvents(new BlockBreakEventListener(), this);
        getServer().getPluginManager().registerEvents(new BlockPlaceEventListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
        getServer().getPluginManager().registerEvents(new BucketEmptyListener(), this);
        getServer().getPluginManager().registerEvents(new SpawnEggListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinTeamListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerHitListener(), this);
        getServer().getPluginManager().registerEvents(new FoodLevelChangeListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerRespawnListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerFallEventListener(), this);
    }

    public static CaptureTheFlag getPlugin() {
        return captureTheFlag;
    }

    public static Game getGame() {
        return game;
    }

}
