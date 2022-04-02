import java.util.Scanner;
import java.util.Random;

public class Main {
    static String player1Name = "Player 1";
    static String player2Name = "Player 2";
    static char actualPlayer = 'X';
    static String actualPlayerName = player1Name;
    static Scanner in = new Scanner(System.in);
    static char[][] board = new char[][] {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    static boolean gameOver = false;
    static Random rand = new Random();

    public static void main(String[] args) {
        while (gameOver != true) {
            createBoard();
            getPlayerNames();
            getPlay();
            gameOver = checkWinner();
        }
    }

    public static void createBoard() {
        System.out.println("  1   2   3");
        System.out.println("1 " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println(" ---" + "+" + "---" + "+" + "---");
        System.out.println("2 " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println(" ---" + "+" + "---" + "+" + "---");
        System.out.println("3 " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }

    public static void getPlayerNames() {
        if (!player1Name.equals("Player 1") && !player2Name.equals("Player 2")) return;
            
            String option;

            System.out.print("Player 1 (X), (M)an or (B)ot ?");
            option = in.nextLine();

            if (option.equalsIgnoreCase(("M"))) {
                System.out.print("Player 1 name: ");
                player1Name = in.nextLine();
                actualPlayerName = player1Name;
            } else if (option.equalsIgnoreCase(("B"))) {
                player1Name = "Bot";
                actualPlayerName = player1Name;
            }

            System.out.print("Player 2 (O), (M)an or (B)ot ?");
            option = in.nextLine();

            if (option.equalsIgnoreCase(("M"))) {
                System.out.print("Player 2 name: ");
                player2Name = in.nextLine();
            } else if (option.equalsIgnoreCase(("B"))) {
                player2Name = "Bot";
            }
            
    }

    public static void getPlay() {
        System.out.print(actualPlayerName + ", please enter your play: ");
        
        int line = in.nextInt();
        int column = in.nextInt();

        if (actualPlayerName.equals(player1Name)) {
            actualPlayer = 'X';
        } else {
            actualPlayer = 'O';
        }

        if (actualPlayerName.equals(player1Name)) {
            actualPlayerName = player2Name;
        } else {
            actualPlayerName = player1Name;
        }

        if (board[line - 1][column - 1] != ' ') {
            gameOver = true;
            System.out.println("Fim de jogo! " + actualPlayerName + " ganhou!");
            return;
        } else {
            board[line - 1][column - 1] = actualPlayer;
        }
    }

    public static boolean checkWinner() {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X') {
                System.out.println(player1Name + " wins!");
                return true;
            } else if (board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O') {
                System.out.println(player2Name + " wins!");
                return true;
            } 

            if (board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == 'X') {
                System.out.println(player1Name + " wins!");
                return true;
            } else if (board[0][i] == 'O' && board[1][i] == 'O' && board[2][i] == 'O') {
                System.out.println(player2Name + " wins!");
                return true;
            }
        }

        if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
            System.out.println(player1Name + " wins!");
            return true;
        } else if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') {
            System.out.println(player2Name + " wins!");
            return true;
        } else if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') {
            System.out.println(player1Name + " wins!");
            return true;
        } else if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') {
            System.out.println(player2Name + " wins!");
            return true;
        } 

        int drawCounter = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != ' ') {
                    drawCounter++;  
                }
            }
        }

        if (drawCounter == 9) {
            System.out.println("Draw!");
            return true;
        } 

        return false;
    }

    

}