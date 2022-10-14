package Util;

import java.util.Arrays;

public class SudokuBoard {

    int[][] board;
    int x;
    int y;

    SudokuBoard(int x, int y){
        this.x = x;
        this.y = y;

        this.board = new int[x][y];
    }

    public void fill(){
        for (int i = 0; i <= board[x-1].length - 1; i++){
            for (int k = 0; k < board[y-1].length; k++){
                filler(board, i, k);
            }
        }
    }

    public void printBoard(){
        for (int[] rows : board){
            System.out.println(Arrays.toString(rows));
        }
    }

    public static boolean rowContains(int[][] board, int row, int num){
        for (int x = 0; x <= 8; x++)
            if (board[row][x] == num)
                return true;
        return false;
    }

    public static boolean colContains(int[][] board, int col, int num){
        for (int x = 0; x <= 8; x++)
            if (board[x][col] == num)
                return true;
        return false;
    }

    public static boolean boxContains(int[][] board, int row, int col, int num){
        int startRow = row - row % 3, startCol
                = col - col % 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i + startRow][j + startCol] == num)
                    return true;
        return false;
    }

    public static void filler(int[][] board, int row, int col){
        int max = 9;
        int min = 1;
        int range = max - min + 1;
        int randomNumber =(int) (Math.random() * range) + 1;

        if (!boxContains(board, row, col, randomNumber) && !rowContains(board,row, randomNumber) && !colContains(board, row, randomNumber)){
            board[row][col] = randomNumber;
            if (puzzleSolver(board, row, col)){
                return;
            }

        }
        filler(board, row, col);
    }

    public void solvePuzzle(){
        puzzleSolver(board, 0, 0);
    }

    public static boolean puzzleSolver(int[][] board, int row, int col){

        if (row == 8 && col == 9){
            return true;
        }

        if (col == 9){
            row++;
            col = 0;
        }

        if (board[row][col] != 0){
            return puzzleSolver(board, row, col);
        }

        filler(board, row, col);

        return false;
    }


}
