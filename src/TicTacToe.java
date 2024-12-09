import java.util.Scanner;

public class TicTacToe {
    public static String [][] board = new String [3][3];
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String player1 = " X ";
        String player2 = " O ";
        boolean contin;
        boolean validMove = false;
        boolean win;

        System.out.println("Welcome to Tic-Tac-Toe!");

        do { //plays while the player wants to play a new game
            clearBoard();
            displayBoard();
            do { //Plays until there is a
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

                win = isWin(player1);

                if (!win) {
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

                    win = isWin(player1) || isWin(player2);
                }
            } while (!win);
            contin = InputHelper.getYNConfirm(scan, "Would you like to play again?");
        } while (contin);
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
        return board[row - 1][col - 1].equals(" - ");
    }

    private static boolean isColWin(String player) {
        boolean win = false;

        for (int c = 0; c < board[0].length; c++) {
            if (board[0][c].equalsIgnoreCase(player) == board[1][c].equalsIgnoreCase(player) && board[0][c].equalsIgnoreCase(player) == board[2][c].equalsIgnoreCase(player) && board[0][c].equals(player)) {
                win = true;
            }
        }

        return win;
    }

    private static boolean isRowWin(String player) {
        boolean win = false;

        for (String[] strings : board) {
            if (strings[0].equalsIgnoreCase(player) == strings[1].equalsIgnoreCase(player) && strings[0].equalsIgnoreCase(player) == strings[2].equalsIgnoreCase(player) && strings[0].equals(player)) {
                win = true;
            }
        }

        return win;
    }


    private static boolean isDiagonalWin(String player) {
        boolean diagonalLeftToRight = true;
        boolean diagonalRightToLeft = true;

        for (int r = 0; r < board.length; r++) {
            if (!board[r][r].equalsIgnoreCase(player)) {
                diagonalLeftToRight = false;
                break;
            }
        }

        for (int r = 0; r < board.length; r++) {
            int c = board.length - 1 - r;
            if (!board[r][c].equalsIgnoreCase(player)) {
                diagonalRightToLeft = false;
                break;
            }
        }

        return diagonalLeftToRight || diagonalRightToLeft;
    }

    private static boolean isTie(String player) {
        int count = 0;
        boolean tie = false;

        for (String[] strings : board) {
            for(String row:strings) {
                if (!row.equalsIgnoreCase(" - ")) {
                    count++;
                }
            }
        }

        if (count == 9) {
            tie = true;
        }

        return tie;
    }

    private static boolean isWin(String player) {
        boolean win = false;
        boolean tie = false;

        if (isColWin(player)) {
            win = true;
            System.out.println("Player " + player + " got a column win!");
        } else if (isRowWin(player)) {
            win = true;
            System.out.println("Player " + player + " got a row win!");
        } else if (isDiagonalWin(player)) {
            win = true;
            System.out.println("Player " + player + " got a diagonal win!");
        } else if (isTie(player)) {
            System.out.println("You both win! It's a tie.");
            tie = true;
        }

        return win || tie;
    }
}
