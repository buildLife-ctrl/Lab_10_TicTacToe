import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String [][] board = new String [3][3];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String player1 = "X";
        String player2 = "O";
        int row;
        int col;

        //String isWin = isWin("")

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println();
        System.out.println("Player 1:");
        row = InputHelper.getRangedInt(scan, "Enter a column move [1 - 3]:", 1, 3);
        col = InputHelper.getRangedInt(scan, "Enter a column move [1 - 3]:", 1, 3);
        System.out.println();
        displayBoard();
    }

    private static void displayBoard() {
        for(String[] r : board) {
            for (String c : r) {
                c = " - ";
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void clearBoard() {
        for(String[] r : board) {
            for (String c : r) {
                c = " - ";
                System.out.print(c);
            }
            System.out.println();
        }
    }
    /*
    private static boolean isValidMove(int row, int col) {
        for(String[] r : board) {
            for (String c : r) {
                if (c.equalsIgnoreCase("x") || c.equalsIgnoreCase("o")) {

                }
            }
        }
    }

    private static boolean isColWin(String player) {

    }

    private static boolean isRowWin(String player) {

    }

    private static boolean isDiagonalWin(String player) {

    }

    private static boolean isTie() {

    }

    private static boolean isWin(String player) {

    }*/
}
