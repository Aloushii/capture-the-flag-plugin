package com.aloushiz.ctf.game;

public class Game {

    private GameState gameState;

    public Game(){
        this.gameState = GameState.WAITING;
    }

    public Game(GameState gameState){
        this.gameState = gameState;
    }

    public void start(){
        gameState = GameState.IN_GAME;
    }

    public GameState getGameState(){
        return gameState;
    }

    public void setGameState(GameState gameState){
        this.gameState = gameState;
    }

}
