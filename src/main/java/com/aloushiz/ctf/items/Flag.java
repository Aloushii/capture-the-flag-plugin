package com.aloushiz.ctf.items;

import com.aloushiz.ctf.team.Team;
import com.aloushiz.ctf.team.TeamColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Represents a flag in a Capture the Flag mini-game.
 * A flag belongs to a specific team and has various states such as being at its base,
 * being carried by a player, or being dropped on the ground.
 * The flag's location, state, and interactions are managed through this class.
 */
public class Flag {
    private final Team team;
    private final Location baseLocation;
    private Location currentLocation;
    private ItemStack flagBlock;
    private Player carrier;
    private FlagState flagState;


    /**
     * Describes the state of the flag in game
     */
    public enum FlagState {
        AT_BASE, CARRIED, DROPPED
    }

    public Flag(Team team, Location baseLocation) {
        this.team = team;
        this.baseLocation = baseLocation;
        this.flagBlock = getTeamColoredFlag(team.getTeamColor());
        this.flagState = FlagState.AT_BASE;
    }

    public Team getTeam() {
        return team;
    }

    public Location getBaseLocation() {
        return baseLocation;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public ItemStack getFlagBlock() {
        return flagBlock;
    }

    public void setFlagBlock(ItemStack flagBlock) {
        this.flagBlock = flagBlock;
    }

    public Player getCarrier() {
        return carrier;
    }

    public void setCarrier(Player carrier) {
        this.carrier = carrier;
    }

    /**
     * Resets the location of the flag at team base
     */
    public void resetFlag() {
        this.flagState = FlagState.AT_BASE;
        this.carrier = null;
        this.currentLocation = baseLocation;
        //tp flag to baseLocation
        // ...
    }

    public void pickUpFlag(Player player) {
        this.flagState = FlagState.CARRIED;
        this.carrier = player;
        // give flag to player...
    }

    public boolean isAtBase() {
        return this.flagState == FlagState.AT_BASE;
    }

    public boolean isCarried() {
        return this.flagState == FlagState.CARRIED;
    }

    /**
     * Returns a Banner (flag) the same color as the teamColor in parameter.
     *
     * @param teamColor
     * @return {@code ItemStack flag} the same color as teamColor
     */
    public ItemStack getTeamColoredFlag(TeamColor teamColor) {
        ItemStack flag = null;
        if (teamColor.equals(TeamColor.BLUE)) {
            flag = new ItemStack(Material.BLUE_BANNER);
        }
        if (teamColor.equals(TeamColor.RED)) {
            flag = new ItemStack(Material.RED_BANNER);
        }
        return flag;
    }
}
