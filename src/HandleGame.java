import java.util.List;
import java.util.Scanner;

public class HandleGame {
    private Player player;
    private Si si;
    private Board playerBoard;
    private Board aiBoard;
    private Shipyard playerShipyard;
    private Shipyard aiShipyard;
    private List<List<ShipPart>> ships;

    public HandleGame() {
        this.playerBoard = new Board();
        this.aiBoard = new Board();
        this.playerShipyard = new Shipyard(playerBoard);
        this.aiShipyard = new Shipyard(aiBoard);
        this.player = new Player(playerShipyard, playerBoard);
        this.si = new Si(aiBoard, aiShipyard);
    }

    public void gameInitialization() {
        //player.placeShipOnMap();
        player.rollShip();
        si.rollShip();
    }

    public void playGame() {
        Scanner userInput = new Scanner(System.in);
        while (si.getShips().size() > 0 && player.getShips().size() > 0) {
            System.out.println(si.getShips());
            printAiBoard();
            System.out.println("Shoot cord x y");

            player.shot(userInput.nextInt(), userInput.nextInt(), si.getShips(), si.getBoard());
            isShipSiAllive();
        }
        if(si.getShips().size() == 0){
            System.out.println("You won this game but not a war");
        } else {
            System.out.println("Not this time a little boy");
        }
    }


    public void isShipSiAllive(){
        ships = getSi().getShips();
        int counter = 0;
        for (int shipCounter = 0; shipCounter < ships.size(); shipCounter++) {
            for (int shipElement = 0; shipElement < ships.get(shipCounter).size(); shipElement++) {
                if(ships.get(shipCounter).get(shipElement).isHit()){
                    counter+=1;
                }
            }
            if(counter == ships.get(shipCounter).size()){
                ships.remove(shipCounter);
            }
            counter = 0;
        }
    }


    public Player getPlayer() {
        return player;
    }

    public Si getSi() {
        return si;
    }


    /* public void runApp() {
        Scanner userInput = new Scanner(System.in);
        this.gameIsRunning = true;
        player.setTurn(true);

        System.out.println(player.getTurn());

        while (this.gameIsRunning) {
            player.setTurn(true);
            while (player.getTurn()) {
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
            while (si.getSiTurn()) {
                playVsSi();
            }
        }
    }*/


       /* if(board.getGameBoard()[x][y].getName() == "S") {
            board.getGameBoard()[x][y].setName("X");
            board.getGameBoard()[x][y].setDestroyed(true);
            player.setScore(this.score += 1);
            System.out.println("Hit!");

        } else {
            System.out.println("Miss!");
            board.getGameBoard()[x][y].setName("O");
            player.setTurn(false);
            si.setDifficulty(3);
            si.setSiTurn(true);
        }
    }*/
/*

    private void playVsSi(){

        si.setSiTurn(true);
        si.siStartGame();
    }
*/

    public void setGameIsRunning(boolean gameIsRunning) {
        this.gameIsRunning = gameIsRunning;
    }


    public void printPlayerBoard() {
        playerBoard.printBoard(playerBoard);
    }

    public void printAiBoard() {
        aiBoard.printBoard(si.getBoard());
    }


   /* public Shipyard getShipyard() {
        return shipyard;
    }*/
}
