import java.util.Scanner;

public class HandleGame
{
    private Player player;
    private Player bot;
    private Si computer = new Si();
    private Board board; //ennemy statki
    private Board playerBoard; //player statki
    private Board playerBoardEnemy; //player czysta mapa
    private Board botBoardEnemy; // bot gdzie bedzie czysta mapa

    //private Si si = new Si(board);
    private boolean gameIsRunning;
    //private int score = player.getScore();



    public Player getPlayer() {
        return player;
    }

    public void runApp(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("POdej nick: ");
        String nickname = userInput.nextLine().toString();
        this.player = new Player(nickname, false);
        this.bot = new Player("Joshua",false);
        this.player.getPlayerBoard().setEnemy(bot);

        this.player.setEnnemyHiddenBoard(bot.getPlayerBoard());
        this.bot.setEnnemyHiddenBoard(player.getPlayerBoard());


        this.gameIsRunning = true;
        player.setTurn(true);

        player.getPlayerBoard().printPlayerBoard();
        computer.setBoard(bot.getEnnemyBoard());
        while(this.gameIsRunning) {

            while(player.getTurn()) {

                //player.getPlayerBoard().printEnnemyBoard();

                System.out.print("Enter x position: ");
                int x = userInput.nextInt();
                System.out.print("Enter y position: ");
                int y = userInput.nextInt();

                if (x <= 9 && y <= 9) {
                    shot(x, y);
                } else {
                    System.out.println("Enter correct coordinates!");
                }
                player.getPlayerBoard().printEnnemyBoard();
            }

            while(bot.getTurn()) {
                playVsSi();
                bot.getPlayerBoard().printEnnemyBoard();
                //computer.setSiTurn(true);
            }

        }

    }
//    private void strzal(int x, int y){
//        playerBoard.setCoordinates(x, y);
//    }


    private void playVsSi(){
        computer.siStartGame(bot, player);
    }

    private void shot(int x, int y){

        Object coordinates = player.getEnnemyHiddenBoard().getCoordinates(x,y);
        System.out.println(coordinates);

        if(coordinates.equals("W")){
            player.setEnnemyBoard(x,y,"O");
            player.setTurn(false);
            bot.setTurn(true);

        } else {
            player.setEnnemyBoard(x,y,"X");
        }


//        if(board.getGameBoard()[x][y].getName() == "S") {
//            board.getGameBoard()[x][y].setName("X");
//            board.getGameBoard()[x][y].setDestroyed(true);
//            player.setScore(this.score += 1);
//            System.out.println("Hit!");
//
//        } else {
//            System.out.println("Miss!");
//            board.getGameBoard()[x][y].setName("O");
//            player.setTurn(false);
//            si.setDifficulty(3);
//            si.setSiTurn(true);
//        }
    }

    public void setGameIsRunning(boolean gameIsRunning) {
        this.gameIsRunning = gameIsRunning;
    }
}
