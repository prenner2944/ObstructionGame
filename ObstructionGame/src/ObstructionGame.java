
import java.util.*;

/**
 * CS 180 - Project 2 - Obstruction
 *
 * This class provides the skeleton methods you need to implement and
 * runs the in-console UI to play the game in the main method.
 *
 * @author
 * @version
 */
public class ObstructionGame {

    // game variables
    public char[][] gameBoard;
    public char[][] screen;

    // display variables
    public static boolean usingLargeBoard = true;
    public static int numPixels = 6;

    // variable constants
    private static final char DOT = '.';
    private static final char STAR = '*';
    private static final char PLUS = '+';
    private static final char EMPTY = ' ';
    private static final char CROSS = 'X';
    private static final char CIRCLE = 'O';

    private static final char[][] BIG_CIRCLE = {{EMPTY, PLUS, PLUS, PLUS, PLUS, EMPTY},
        {PLUS, EMPTY, EMPTY, EMPTY, EMPTY, PLUS},
        {PLUS, EMPTY, EMPTY, EMPTY, EMPTY, PLUS},
        {PLUS, EMPTY, EMPTY, EMPTY, EMPTY, PLUS},
        {PLUS, EMPTY, EMPTY, EMPTY, EMPTY, PLUS},
        {EMPTY, PLUS, PLUS, PLUS, PLUS, EMPTY}};

    private static final char[][] BIG_CROSS = {{STAR, EMPTY, EMPTY, EMPTY, EMPTY, STAR},
        {EMPTY, STAR, EMPTY, EMPTY, STAR, EMPTY},
        {EMPTY, EMPTY, STAR, STAR, EMPTY, EMPTY},
        {EMPTY, EMPTY, STAR, STAR, EMPTY, EMPTY},
        {EMPTY, STAR, EMPTY, EMPTY, STAR, EMPTY},
        {STAR, EMPTY, EMPTY, EMPTY, EMPTY, STAR}};

    private static final char[][] BIG_DOT =  {{DOT, DOT, DOT, DOT, DOT, DOT},
        {DOT, DOT, DOT, DOT, DOT, DOT},
        {DOT, DOT, DOT, DOT, DOT, DOT},
        {DOT, DOT, DOT, DOT, DOT, DOT},
        {DOT, DOT, DOT, DOT, DOT, DOT},
        {DOT, DOT, DOT, DOT, DOT, DOT}};
    /**
     * Initializes all instance variables (such as gameBoard) used to
     * run the game. You may create other variables if you wish.
     *
     * @param rows number of rows on the board
     * @param cols number of columns on the board
     *
     */
    public ObstructionGame(int rows, int cols) {
        gameBoard = new char[rows][cols];
        screen = new char[rows * numPixels][cols * numPixels];
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = EMPTY;
            }
        }
        for (int x = 0; x < screen.length; x++) {
            for (int y = 0; y < screen[x].length; y++) {
                screen[x][y] = EMPTY;
            }
        }
        // TODO: implement method
    }

    /**
     * Updates the board with the player's move.
     *
     * @param row the row of the move
     *
     * @param col the column of the move
     *
     * @param player the player who is making the move.
     *
     * @return false if the location or player is not a legal spot
     *         or player, true otherwise
     */

    public boolean playAtLocation(int row, int col, char player) {
        if (row > gameBoard.length - 1 || col > gameBoard[0].length - 1) {
            return false;
        }
        if (row < 0 || col < 0) {
            return false;
        }
        if (player != CROSS && player != CIRCLE) {
            return false;
        }
        if (player == CROSS || player == CIRCLE) {
            if (gameBoard[row][col] == ' ') {
                if (row == 0 && col == 0) {
                    gameBoard[row][col] = player;
                    updateScreen(row, col);
                    gameBoard[row][col + 1] = DOT;
                    updateScreen(row, col + 1);
                    gameBoard[row + 1][col] = DOT;
                    updateScreen(row + 1, col);
                    gameBoard[row + 1][col + 1] = DOT;
                    updateScreen(row + 1, col + 1);
                    return true;
                }
                if (row == 0 && col == gameBoard[0].length - 1) {
                    gameBoard[row][col] = player;
                    updateScreen(row, col);
                    gameBoard[row][col - 1] = DOT;
                    updateScreen(row, col - 1);
                    gameBoard[row + 1][col] = DOT;
                    updateScreen(row + 1, col);
                    gameBoard[row + 1][col - 1] = DOT;
                    updateScreen(row + 1, col - 1);
                    return true;
                }
                if (row == gameBoard.length - 1 && col == 0) {
                    gameBoard[row][col] = player;
                    updateScreen(row, col);
                    gameBoard[row - 1][col] = DOT;
                    updateScreen(row - 1, col);
                    gameBoard[row - 1][col + 1] = DOT;
                    updateScreen(row - 1, col + 1);
                    gameBoard[row][col + 1] = DOT;
                    updateScreen(row, col + 1);
                    return true;
                }
                if (row == gameBoard.length - 1 && col == gameBoard[0].length - 1) {
                    gameBoard[row][col] = player;
                    updateScreen(row, col);
                    gameBoard[row][col - 1] = DOT;
                    updateScreen(row, col - 1);
                    gameBoard[row - 1][col - 1] = DOT;
                    updateScreen(row - 1, col - 1);
                    gameBoard[row - 1][col] = DOT;
                    updateScreen(row - 1, col);
                    return true;
                }
                if (row == 0 && col != 0 && col != gameBoard[0].length - 1) {
                    gameBoard[row][col] = player;
                    updateScreen(row, col);
                    gameBoard[row][col - 1] = DOT;
                    updateScreen(row, col - 1);
                    gameBoard[row + 1][col - 1] = DOT;
                    updateScreen(row + 1, col - 1);
                    gameBoard[row + 1][col] = DOT;
                    updateScreen(row + 1, col);
                    gameBoard[row + 1][col + 1] = DOT;
                    updateScreen(row + 1, col + 1);
                    gameBoard[row][col + 1] = DOT;
                    updateScreen(row, col + 1);
                    return true;
                }
                if (row == gameBoard.length - 1 && col != 0 && col != gameBoard[0].length - 1) {
                    gameBoard[row][col] = player;
                    updateScreen(row, col);
                    gameBoard[row][col - 1] = DOT;
                    updateScreen(row, col - 1);
                    gameBoard[row][col + 1] = DOT;
                    updateScreen(row, col + 1);
                    gameBoard[row - 1][col - 1] = DOT;
                    updateScreen(row - 1, col - 1);
                    gameBoard[row - 1][col] = DOT;
                    updateScreen(row - 1, col);
                    gameBoard[row - 1][col + 1] = DOT;
                    updateScreen(row - 1, col + 1);
                    return true;
                }
                if (col == 0 && row != 0 && row != gameBoard.length - 1) {
                    gameBoard[row][col] = player;
                    updateScreen(row, col);
                    gameBoard[row + 1][col] = DOT;
                    updateScreen(row + 1, col);
                    gameBoard[row + 1][col + 1] = DOT;
                    updateScreen(row + 1, col + 1);
                    gameBoard[row][col + 1] = DOT;
                    updateScreen(row, col + 1);
                    gameBoard[row - 1][col + 1] = DOT;
                    updateScreen(row - 1, col + 1);
                    gameBoard[row - 1][col] = DOT;
                    updateScreen(row - 1, col);
                    return true;
                }
                if (col == gameBoard[0].length - 1 && row != 0 && row != gameBoard.length - 1) {
                    gameBoard[row][col] = player;
                    updateScreen(row, col);
                    gameBoard[row - 1][col] = DOT;
                    updateScreen(row - 1, col);
                    gameBoard[row - 1][col - 1] = DOT;
                    updateScreen(row - 1, col - 1);
                    gameBoard[row][col - 1] = DOT;
                    updateScreen(row, col - 1);
                    gameBoard[row + 1][col - 1] = DOT;
                    updateScreen(row + 1, col - 1);
                    gameBoard[row + 1][col] = DOT;
                    updateScreen(row + 1, col);
                    return true;
                }
                if (row > 0 && row < gameBoard.length - 1 && col > 0 && col < gameBoard[0].length - 1) {
                    gameBoard[row][col] = player;
                    updateScreen(row, col);
                    gameBoard[row - 1][col] = DOT;
                    updateScreen(row - 1, col);
                    gameBoard[row + 1][col] = DOT;
                    updateScreen(row + 1, col);
                    gameBoard[row][col - 1] = DOT;
                    updateScreen(row, col - 1);
                    gameBoard[row][col + 1] = DOT;
                    updateScreen(row, col + 1);
                    gameBoard[row - 1][col - 1] = DOT;
                    updateScreen(row - 1, col - 1);
                    gameBoard[row - 1][col + 1] = DOT;
                    updateScreen(row - 1, col + 1);
                    gameBoard[row + 1][col + 1] = DOT;
                    updateScreen(row + 1, col + 1);
                    gameBoard[row + 1][col - 1] = DOT;
                    updateScreen(row + 1, col - 1);
                    return true;
                }

            }

            // TODO: implement method
        }
        return false;
    }

    /**
     * Determines if there are any valid moves on the board that a
     * player can make. This function is used to check if the game
     * has ended.
     *
     * @return true if the player can make a move
     */
    public boolean anyMovesPossible() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == EMPTY) {
                    return true;
                }
            }
        }
        return false;
        // TODO: implement method
    }

    /**
     * This is a getter method that returns a copy of the game board.
     *
     * @return a copy of the current state of the board
     */
    public char[][] getBoard() {
        char[][] copy = new char[gameBoard.length][gameBoard[0].length];
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                copy[i][j] = gameBoard[i][j];
            }
        }
        return copy;
        // TODO: implement method
    }
    public void convertScreen(int row, int col, char[][] temp) {
        for (int i = 0; i < numPixels; i++) {
            for (int j = 0; j < numPixels; j++) {
                screen[row * numPixels + i][col * numPixels + j] = temp[i][j];
            }
        }
    }

    /**
     * This method updates the screen variable to represent the player
     * move in the specified cell as large ascii characters.
     * @param row row number of cell
     * @param col column number of cell
     */
    public void updateScreen(int row, int col) {
        if (row > gameBoard.length - 1 || col > gameBoard[0].length - 1) {
            return;
        }
        if (row < 0 || col < 0) {
            return;
        }

        if (gameBoard[row][col] == CIRCLE) {
            convertScreen(row, col, BIG_CIRCLE);
        }
        if (gameBoard[row][col] == CROSS) {
            convertScreen(row, col, BIG_CROSS);
        }
        if (gameBoard[row][col] == DOT) {
            convertScreen(row, col, BIG_DOT);
        }

    }





    // TODO: implement method


    /**
     * This is a getter method that returns of copy of the screen.
     *
     * @return a copy of the current state of the screen
     */
    public char[][] getScreen() {
        char[][] copy = new char[screen.length][screen[0].length];
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                copy[i][j] = screen[i][j];
            }
        }
        return copy;
        // TODO: implement method
    }

    /**
     * This method prints a pretty version of the board to the
     * console. While we are giving this method to you, feel free to
     * edit it if you are confident enough in your coding abilities.
     */
    public void printBoard() {
        char[][] board = getBoard();

        if (!usingLargeBoard) {
            // Make the header of the board
            System.out.printf("\n ");
            for (int i = 0; i < board[0].length; ++i)
                System.out.printf("   %d", i);
            System.out.println();

            System.out.printf("  ");
            for (int i = 0; i < board[0].length; ++i)
                System.out.printf("----");
            System.out.println("-");

            // Print the board contents
            for (int i = 0; i < board.length; ++i) {
                System.out.printf("%c ", 'A' + i);
                for (int k = 0; k < board[0].length; ++k)
                    System.out.printf("| %c ", board[i][k]);
                System.out.println("|");

                // print the line between each row
                System.out.printf("  ");
                for (int k = 0; k < board[0].length; ++k)
                    System.out.printf("----");
                System.out.println("-");
            }
        } else { // where we are printing the large board

            // Make the header of the board
            System.out.println();
            for (int i = 0; i < board[0].length; ++i) {
                for (int k = 0; k < numPixels; ++k)
                    System.out.printf(" ");
                System.out.printf("%d", i);
            }
            System.out.println();

            System.out.printf("  ");
            for (int i = 0; i < board[0].length; ++i) {
                for (int k = 0; k < numPixels + 1; ++k)
                    System.out.printf("-");
            }
            System.out.println("-");

            // Print the board contents
            for (int i = 0; i < screen.length; ++i) {
                System.out.printf("%c |", i % numPixels == numPixels / 2 ?
                        'A' + i / numPixels : EMPTY);

                // print the row of the screen
                for (int k = 0; k < screen[0].length; ++k) {
                    System.out.printf("%c", screen[i][k]);
                    if ((k + 1) % numPixels == 0)
                        System.out.print("|");
                }
                System.out.println();

                // print the line between each row
                if ((i + 1) % numPixels == 0) {
                    System.out.printf("  ");
                    for (int j = 0; j < board[0].length; ++j) {
                        for (int k = 0; k < numPixels + 1; ++k)
                            System.out.printf("-");
                    }
                    System.out.println("-");
                }
            }
        }
    }

    /**
     * This method initiates gameplay.
     */
    public void play() {
        char currentPlayer = CROSS;

        // Begin playing the game
        Scanner in = new Scanner(System.in);
        do {
            currentPlayer = currentPlayer == CIRCLE ? CROSS : CIRCLE;
            this.printBoard();
            System.out.printf("Current player: '%c'\n", currentPlayer);

            // read and validate the input
            int row = -1;
            int col = -1;
            do {
                System.out.printf("Choose a move location: ");
                String line = in.nextLine();

                if (line == null)
                    continue;

                // Check for special commands
                if (line.equals("switch")) {
                    usingLargeBoard = !usingLargeBoard;
                    System.out.printf("Big Board display is %s.\n",
                            usingLargeBoard ? "on" : "off");
                    this.printBoard();
                    continue;
                }
                else if (line.equals("end")) {
                    System.out.printf("Game is manually ending.\n");
                    return;
                }
                else if (line.contains("=")) {
                    String[] parts = line.split("=");
                    if (parts.length == 2 && parts[0].equals("pixels")) {
                        // Change the number of pixels in the big board

                        if ((new Scanner(parts[1])).hasNextInt()) {
                            if (Integer.parseInt(parts[1]) < 3)
                                continue;
                            numPixels = Integer.parseInt(parts[1]);
                        }
                        else
                            continue;

                        System.out.printf("Big Board cell sizes are "
                                + "now %sx%s pixels.\n", parts[1], parts[1]);

                        screen = new char[numPixels * gameBoard.length]
                                [numPixels * gameBoard[0].length];
                        for (int i = 0; i < screen.length; ++i) {
                            for (int j = 0; j < screen[i].length; ++j) {
                                screen[i][j] = EMPTY;
                            }
                        }

                        for (int i = 0; i < gameBoard.length; ++i)
                            for (int j = 0; j < gameBoard[i].length; ++j)
                                this.updateScreen(i, j);

                        if (usingLargeBoard)
                            this.printBoard();
                    }

                    continue;
                }
                else if (line.length() != 2)
                    continue;

                row = line.charAt(0) - 'A';
                col = line.charAt(1) - '0';

            } while (!this.playAtLocation(row, col, currentPlayer));

        } while (this.anyMovesPossible());

        this.printBoard();
        System.out.printf("\n!!! Winner is Player '%c' !!!\n", currentPlayer);
        in.close();
    }

}