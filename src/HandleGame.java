import java.util.Scanner;

public class HandleGame
{
    private Player player = new Player();
    private boolean turn = player.getTurn();
    private int score = player.getScore();
    private boolean gameIsRunning;





    public void runApp(){
        Scanner userInput = new Scanner(System.in);
        this.gameIsRunning = true;
        player.setTurn(true);
        Board board = new Board();
        while(this.gameIsRunning) {
            board.printBoard();
            System.out.print("Enter x position: ");
            int x = userInput.nextInt();
            System.out.print("Enter y position: ");
            int y = userInput.nextInt();
            System.out.println("Your score: " + player.getScore());
            shot(x, y);
        }
    }

    private void shot(int x, int y){
        square[][] board = Board.getGameBoard();
        if(board[x][y].getName() == "S") {
            board[x][y].setName("X");
            board[x][y].setDestroyed(true);
            player.setScore(this.score += 1);
            System.out.println("Hit!");

        } else {
            System.out.println("Miss!");
            player.setTurn(false);
        }
    }

    public void setGameIsRunning(boolean gameIsRunning) {
        this.gameIsRunning = gameIsRunning;
    }
}
