package com.company.game;

import javax.swing.*;

public class Game {
    private GameBoard gameBoard;
    private GamePlayer[] gamePlayers = new GamePlayer[2];
    private int playerTurn = 0;

    public Game() {
        this.gameBoard = new GameBoard(this);
    }

    public void initGame() {
        gamePlayers[0] = new GamePlayer('X', true);
        gamePlayers[1] = new GamePlayer('O', false);
    }

    void passTurn() {
        if(playerTurn == 0){
            playerTurn = 1;
        }else{
            playerTurn = 0;
        }
    }

    GamePlayer getCurrentPlayer() {
        return gamePlayers[playerTurn];
    }

    void showMessage(String message) {
        JOptionPane.showMessageDialog(gameBoard, message);
    }
}
