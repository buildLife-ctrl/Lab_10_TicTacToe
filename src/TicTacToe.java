import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    public static String [][] board = new String [3][3];
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String player1 = " X ";
        String player2 = " O ";
        boolean contin = true;
        boolean validMove = false;
        boolean win;

        System.out.println("Welcome to Tic-Tac-Toe!");

        //do {
            //do {
                clearBoard();
                displayBoard();
                System.out.println("Player 1:");
                do {
                    int row = InputHelper.getRangedInt(scan, "Enter a row move [1 - 3]:", 1, 3);
                    int col = InputHelper.getRangedInt(scan, "Enter a column move [1 - 3]:", 1, 3);
                    if (isValidMove(row, col)) {
                        board[row - 1][col - 1] = player1;
                        validMove = true;
                    } else {
                        System.out.println("Invalid move, please try again!");
                    }
                } while (!validMove);
                System.out.println();
                displayBoard();

                validMove = false; //so that I can redo another do while loop
                System.out.println("Player 2:");
                do {
                    int row = InputHelper.getRangedInt(scan, "Enter a row move [1 - 3]:", 1, 3);
                    int col = InputHelper.getRangedInt(scan, "Enter a column move [1 - 3]:", 1, 3);
                    if (isValidMove(row, col)) {
                        board[row - 1][col - 1] = player2;
                        validMove = true;
                    } else {
                        System.out.println("Invalid move, please try again!");
                    }
                } while (!validMove);
                System.out.println();
                displayBoard();

                //isWin()
            // } while (!win);
            //contin = InputHelper.getYNConfirm(scan, "Would you like to play again?");
        //} while (contin);
    }

    private static void displayBoard() {
        for (String[] r : board) {
            for (String c : r) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void clearBoard() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                board[r][c] = " - ";
            }
        }
    }

    private static boolean isValidMove(int row, int col) {
        if (board[row - 1][col - 1].equals(" - ")) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isColWin(String player) {
        int player1Count = 0;
        int player2Count = 0;

        for (String[] r : board) {
            for (String c : r) {
                if (c == " X ") {
                    player1Count++;
                } else if (c == " O ") {
                    player2Count++;
                }
            }
            System.out.println();
        }
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
