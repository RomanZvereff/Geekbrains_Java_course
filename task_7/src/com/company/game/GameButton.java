package com.company.game;

import javax.swing.*;

public class GameButton extends JButton {
    private int buttonIndex;
    private GameBoard board;

    public GameButton(int buttonIndex, GameBoard board) {
        this.buttonIndex = buttonIndex;
        this.board = board;

        int rowNum = buttonIndex / GameBoard.dimension;
        int cellNum = buttonIndex % GameBoard.dimension;

        setSize(GameBoard.cellSize - 5, GameBoard.cellSize - 5);
        addActionListener(new GameActionListener(rowNum, cellNum ,this));
    }

    public GameBoard getBoard() {
        return board;
    }
}
