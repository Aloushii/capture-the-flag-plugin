package com.aloushiz.ctf.game;

import com.aloushiz.ctf.team.TeamManager;

/**
 * @author Aloushiz, Walidoow
 */
public class Game {

    private GameState gameState;

    public Game(){
        this.gameState = GameState.WAITING;
    }

    public Game(GameState gameState){
        this.gameState = gameState;
    }

    /**
     * The start method is used to start the game,
     * it handles everything that needs to be done
     * in order to start the game.
     */
    public void start(){
        gameState = GameState.IN_GAME;
        TeamManager.assignTeamToTeamlessPlayers();
    }

    public GameState getGameState(){
        return gameState;
    }

    public void setGameState(GameState gameState){
        this.gameState = gameState;
    }

}
