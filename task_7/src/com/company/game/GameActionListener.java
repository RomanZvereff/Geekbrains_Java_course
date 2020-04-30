package com.company.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameActionListener implements ActionListener {
    private int row;
    private int cell;
    private GameButton gameButton;

    public GameActionListener(int row, int cell, GameButton gameButton) {
        this.row = row;
        this.cell = cell;
        this.gameButton = gameButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameBoard board = gameButton.getBoard();

        if(board.isTurnable(row, cell)){
            updateByPlayersData(board);

            if(board.isFull()){
                board.getGame().showMessage("Draw!");
                board.clearField();
            }else{
                updateByAiData(board);
            }
        }else{
            board.getGame().showMessage("Invalid turn!");
        }
    }

    private void updateByPlayersData(GameBoard board) {
        board.updateGameField(row, cell);

        gameButton.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayersSign()));

        if(board.checkWin()){
            gameButton.getBoard().getGame().showMessage("You win!");
            board.clearField();
        }else{
            board.getGame().passTurn();
        }
    }

    private void updateByAiData(GameBoard board) {
        int x = -1;
        int y = -1;
        int maxScoreFieldX = -1;
        int maxScoreFieldY = -1;
        int maxScore = 0;
        Random random = new Random();

        for(int i = 0; i < GameBoard.dimension; i++){
            for(int j = 0; j < GameBoard.dimension; j++){
                int fieldScore = 0;

                if(board.isTurnable(i, j)){
                    if(i - 1 >= 0 && j - 1 >= 0 && board.getPlayerSign ((i - 1), (j - 1)) == board.getGame().getCurrentPlayer().getPlayersSign()){
                        fieldScore++;
                    }

                    if(i - 1 >= 0 && j - 1 >= 0 && board.getPlayerSign ((i - 1), j) == board.getGame().getCurrentPlayer().getPlayersSign()){
                        fieldScore++;
                    }

                    if(i - 1 >= 0 && j + 1 < GameBoard.dimension && board.getPlayerSign ((i - 1), (j + 1)) == board.getGame().getCurrentPlayer().getPlayersSign()){
                        fieldScore++;
                    }

                    if(j + 1 < GameBoard.dimension && board.getPlayerSign (i, (j + 1)) == board.getGame().getCurrentPlayer().getPlayersSign()){
                        fieldScore++;
                    }

                    if(i + 1 < GameBoard.dimension && j + 1 < GameBoard.dimension && board.getPlayerSign ((i + 1), (j + 1)) == board.getGame().getCurrentPlayer().getPlayersSign()){
                        fieldScore++;
                    }

                    if(i + 1 < GameBoard.dimension && board.getPlayerSign ((i + 1), j) == board.getGame().getCurrentPlayer().getPlayersSign()){
                        fieldScore++;
                    }

                    if(i + 1 < GameBoard.dimension && j - 1 >= 0 && board.getPlayerSign ((i + 1), (j - 1)) == board.getGame().getCurrentPlayer().getPlayersSign()){
                        fieldScore++;
                    }

                    if(j - 1 >= 0 && board.getPlayerSign (i, j - 1) == board.getGame().getCurrentPlayer().getPlayersSign()){
                        fieldScore++;
                    }

                    if(fieldScore > maxScore){
                        maxScore = fieldScore;
                        maxScoreFieldX = j;
                        maxScoreFieldY = i;

                    }
                }
            }

            if(maxScoreFieldX != -1){
                x = maxScoreFieldX;
                y = maxScoreFieldY;
            }

            if(x == -1){
                do{
                    x = random.nextInt(GameBoard.dimension);
                    y = random.nextInt(GameBoard.dimension);
                }while(!board.isTurnable(x, y));
            }

        }

        board.updateGameField(x, y);

        int cellIndex = GameBoard.dimension * x + y;
        board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayersSign()));

        if(board.checkWin()){
            gameButton.getBoard().getGame().showMessage("AI wins!");
            board.clearField();
        }else{
            board.getGame().passTurn();
        }
    }
}
