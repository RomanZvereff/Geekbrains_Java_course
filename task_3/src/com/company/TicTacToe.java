package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {

    private static char[][] field;
    private static final int SIZE = 3;
    private static final char X = 'X';
    private static final char O = 'O';
    private static final char EMPTY_CELL = ' ';

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        initField();
        printField();

        while(true) {
            humanTurn();
            if(isEndGame(X)) {
                break;
            }
            computerTurn();
            if(isEndGame(O)) {
                break;
            }
        }
    }

    private static void initField() {
        field = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = EMPTY_CELL;
            }
        }
    }

    private static void printField() {
        for (int i = 0; i <= SIZE; i++) {
            if(i == 0){
                System.out.print("\t");
            }else {
                System.out.print(i + "\t");
            }
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" " + (i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                if(j == SIZE - 1){
                    System.out.println(field[i][j]);
                }else{
                    System.out.print(" " + field[i][j] + " | ");
                }
            }
            if(i != SIZE - 1) {
                System.out.println("\t— ┾ —— ┾ —");
            }
        }
    }

    private static void humanTurn() {
        int x = 0, y = 0;

        do {
            System.out.println("Enter cell coordinates.");
            try {
                System.out.print("column number:");
                x = Integer.parseInt(reader.readLine()) - 1;
                System.out.print("row number:");
                y = Integer.parseInt(reader.readLine()) - 1;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }while(!isCellValid(x, y));
        field[y][x] = X;
    }

    private static boolean isCellValid(int x, int y) {
        boolean result = true;
        if(x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            result = false;
        }
        if(field[y][x] != EMPTY_CELL) {
            result = false;
        }
        return result;
    }

    private static boolean isEndGame(char playerSymbol) {
        boolean endGame = false;
        printField();

        if(checkWin(playerSymbol)) {
            System.out.println(playerSymbol + " wins!");
            endGame = true;
        }
        if(isFieldFull()) {
            System.out.println("Draw!");
            endGame = true;
        }
        return endGame;
    }

    private static boolean isFieldFull() {
        boolean fieldFull = true;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(field[i][j] == EMPTY_CELL) {
                    fieldFull = false;
                }
            }
        }
        return fieldFull;
    }

    private static boolean checkWin(char playerSymbol) {
        boolean isWin = false;

        if((field[0][0] == playerSymbol && field[0][1] == playerSymbol && field[0][2] == playerSymbol) ||
                (field[1][0] == playerSymbol && field[1][1] == playerSymbol && field[1][2] == playerSymbol) ||
                (field[2][0] == playerSymbol && field[2][1] == playerSymbol && field[2][2] == playerSymbol) ||
                (field[0][0] == playerSymbol && field[1][0] == playerSymbol && field[2][0] == playerSymbol) ||
                (field[0][1] == playerSymbol && field[1][1] == playerSymbol && field[2][1] == playerSymbol) ||
                (field[0][2] == playerSymbol && field[1][2] == playerSymbol && field[2][2] == playerSymbol) ||
                (field[0][0] == playerSymbol && field[1][1] == playerSymbol && field[2][2] == playerSymbol) ||
                (field[0][2] == playerSymbol && field[1][1] == playerSymbol && field[2][0] == playerSymbol)) {
            isWin = true;
        }
        return isWin;
    }

    private static void computerTurn() {
        int x = 0, y = 0;

        int xCount = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(field[i][j] == X) {
                    xCount++;
                }
            }
        }
        if(xCount == 1) {
            do{
                x = (int)(Math.random() * 2);
                y = (int)(Math.random() * 2);
            }while(!isCellValid(x, y));
            field[y][x] = O;
        }else {
            if(!blockOpponent()){
                blockDiagonal();
            };
        }
    }

    public static boolean blockOpponent() {
        boolean result = false;
        // horizontal lines
        for (int i = 0; i < SIZE; i++) {
            if (field[i][0] == X && field[i][1] == X && field[i][2] == EMPTY_CELL) {
                field[i][2] = O;
                result = true;
            }
            if (field[i][1] == X && field[i][2] == X && field[i][0] == EMPTY_CELL) {
                field[i][0] = O;
                result = true;
            }
            if (field[i][0] == X && field[i][2] == X && field[i][1] == EMPTY_CELL) {
                field[i][1] = O;
                result = true;
            }
        }
        // vertical lines
        for (int i = 0; i < SIZE; i++) {
            if (field[0][i] == X && field[1][i] == X && field[2][i] == EMPTY_CELL) {
                field[2][i] = O;
                result = true;
            }
            if (field[1][i] == X && field[2][i] == X && field[0][i] == EMPTY_CELL) {
                field[0][i] = O;
                result = true;
            }
            if (field[0][i] == X && field[2][i] == X && field[1][i] == EMPTY_CELL) {
                field[1][i] = O;
                result = true;
            }
        }
        return result;
    }

    public static void blockDiagonal() {

        //diagonal top left right bottom
        if (field[0][0] == X && field[1][1] == X && field[2][2] == EMPTY_CELL) {
            field[2][2] = O;
            return;
        }
        if (field[1][1] == X && field[2][2] == X && field[0][0] == EMPTY_CELL) {
            field[0][0] = O;
            return;
        }
        if (field[0][0] == X && field[2][2] == X && field[1][1] == EMPTY_CELL) {
            field[1][1] = O;
            return;
        }
        //diagonal top right bottom left
        if (field[0][2] == X && field[1][1] == X && field[2][0] == EMPTY_CELL) {
            field[2][0] = O;
            return;
        }
        if (field[1][1] == X && field[2][0] == X && field[0][2] == EMPTY_CELL) {
            field[0][2] = O;
            return;
        }
        if (field[0][2] == X && field[2][0] == X && field[1][1] == EMPTY_CELL) {
            field[1][1] = O;
            return;
        }
    }

}
