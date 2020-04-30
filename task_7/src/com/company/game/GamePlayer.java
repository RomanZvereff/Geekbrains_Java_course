package com.company.game;

public class GamePlayer {
    private char playersSign;
    private boolean realPlayer = true;

    public GamePlayer(char playersSign, boolean realPlayer) {
        this.playersSign = playersSign;
        this.realPlayer = realPlayer;
    }

    public boolean isRealPlayer() {
        return realPlayer;
    }

    public char getPlayersSign() {
        return playersSign;
    }
}
