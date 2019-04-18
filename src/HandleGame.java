import java.util.Scanner;

public class HandleGame
{
    private Player player = new Player();
    private Board board = new Board();
    private Si si = new Si(board);
    private boolean gameIsRunning;
    private int score = player.getScore();



    public Player getPlayer() {
        return player;
    }

    public void runApp(){
        Scanner userInput = new Scanner(System.in);
        this.gameIsRunning = true;
        player.setTurn(true);

        System.out.println(player.getTurn());

        while(this.gameIsRunning) {
            player.setTurn(true);
            while(player.getTurn()) {
                board.printBoard();
                System.out.print("Enter x position: ");
                int x = userInput.nextInt();
                System.out.print("Enter y position: ");
                int y = userInput.nextInt();
                System.out.println("Your score: " + player.getScore());
                if (x <= 9 && y <= 9) {
                    shot(x, y);
                } else {
                    System.out.println("Enter correct coordinates!");
                }
            }
            while(si.getSiTurn()){
                playVsSi();
            }
        }
    }

    private void shot(int x, int y){

        if(board.getGameBoard()[x][y].getName() == "S") {
            board.getGameBoard()[x][y].setName("X");
            board.getGameBoard()[x][y].setDestroyed(true);
            player.setScore(this.score += 1);
            System.out.println("Hit!");

        } else {
            System.out.println("Miss!");
            board.getGameBoard()[x][y].setName("O");
            player.setTurn(false);
            si.setDifficulty(2);
            si.setSiTurn(true);
        }
    }

    private void playVsSi(){

        si.setSiTurn(true);
        si.siStartGame();
    }

    public void setGameIsRunning(boolean gameIsRunning) {
        this.gameIsRunning = gameIsRunning;
    }
}
