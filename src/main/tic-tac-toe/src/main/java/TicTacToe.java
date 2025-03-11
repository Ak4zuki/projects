import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        while (gameRunning){
            printboard();
            playerMove(scanner);
            
            if (checkWinner()){
                printboard();
                System.out.println("Player " + currentPlayer + " Wins!");
                gameRunning = false;
            } else if (isBoardFull()) {
                printboard();
                System.out.println("It's a draw!");
                gameRunning = false;
            }else {
                switchPlayer();
            }
        }

        scanner.close();
    }
    private static void printboard(){
        System.out.println(" 0 1 2");
        for (int i = 0; i < 3; i++){
            System.out.println(i + " ");
            for (int j = 0; j < 3; j++){
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println(" -----");
        }
    }
    private static void playerMove(Scanner scanner){
        int row, col;
        while (true){
            System.out.println("Player " + currentPlayer + " enter row and column (0-2)");
            row = scanner.nextInt();
            col = scanner.nextInt();
            
            if (row >= 0 && row < 3 && col < 3 && board[row][col] == ' '){
                board[row][col] = currentPlayer;
                break;
            }else {
                System.out.println("Invalid Move. Try Again.");
            }
        }
    }
    private static boolean checkWinner(){
        for (int i = 0; i < 3; i++){
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
                return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
                return true;
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
            return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
            return true;

        return false;
    }
    private static boolean isBoardFull(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }
    private static void switchPlayer(){
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}