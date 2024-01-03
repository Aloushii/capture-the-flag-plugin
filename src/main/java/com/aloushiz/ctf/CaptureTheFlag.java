package com.aloushiz.ctf;

import com.aloushiz.ctf.game.Game;
import com.aloushiz.ctf.listener.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class CaptureTheFlag extends JavaPlugin {

    private static CaptureTheFlag captureTheFlag = null;
    private static Game game = new Game();

    @Override
    public void onEnable() {
        captureTheFlag = this;
        System.out.println("Plugin Capture the Flag has loaded");

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


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static CaptureTheFlag getPlugin(){
        return captureTheFlag;
    }

    public static Game getGame(){
        return game;
    }

}
