package Util;

import java.util.Arrays;

import static Util.SudokuBoard.puzzleSolver;

public class Main {
    public static void main(String[] args) {
        SudokuBoard board = new SudokuBoard(9,9);
        int[][] another = board.tryRandom();
        for (int[] rows : another) {
            System.out.println(Arrays.toString(rows));}
        board.solvePuzzle();
        System.out.println(" ");
        board.printBoard();
        }
    }
