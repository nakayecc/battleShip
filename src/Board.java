import java.sql.Array;

public class Board {
    private Player player;
    private Player enemy;
    private static final int boardHeight = 10;
    private Board enemyBoard;
    private Board myBoard;
    private static final int boardWidth = 10;
    //private square[][] gameBoard = new square[10][10];
    private Object[][] coordinates = new Object[boardWidth][boardHeight];
    private boolean isOcean = true;
    private boolean isShip = false;
    private boolean isHit = false;
    private Ship statek;
    private Shipyard shipyard;

    private String name;

    public Board(boolean cleanBoard, Player player) {

        this.player = player;

        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                coordinates[i][j] = "W";
            }

        }

        if(!cleanBoard){
            this.shipyard = new Shipyard(this);
            //coordinates[1][2] = this.shipyard;
            this.shipyard.makeShip("Cruiser", 1, 1, "right");
        }

    }

    public Board(boolean cleanBoard) {

        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                coordinates[i][j] = "W";
            }

        }
    }
    public Player getEnemy(){
        return this.enemy;
    }

    public void setEnemy(Player enemy){
        this.enemy = enemy;
    }

    public void setStatek(Ship ship) {
        this.statek = ship;
    }

    public Board getEnemyBoard() {
        return enemyBoard;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setEnemyBoard(Board enemyBoard) {
        this.enemyBoard = enemyBoard;
    }

    public void setShipPart(ShipPart shipPart) {

    }

    public boolean isShip() {
        return isShip;
    }

    public void printEnnemyBoard(){
        myBoard = player.getEnnemyBoard();
        char pipeVertical = '\u2502';
        char pipeHorizontal = '\u2015';
        String topMarks = "ABCDEFGHIJ";
        String sideMarks = "0123456789";

        String separator = "";

        int n = 42;
        for(int i=0; i < n; i++)
        {
            separator = separator + pipeHorizontal;
        }
        System.out.println("Enemy Board");
        for (int i = 0; i < topMarks.length(); i++)
        {
            System.out.print("   " + topMarks.charAt(i));
        }
        System.out.println();

        for(int i = 0; i < myBoard.coordinates.length; i++)
        {
            System.out.println(separator);
            System.out.print(sideMarks.charAt(i));
            for(int j = 0; j < myBoard.coordinates.length; j++)
            {
                System.out.print(pipeVertical + " ");


                    System.out.print(myBoard.coordinates[i][j] + " ");


            }
            System.out.println(pipeVertical);
        }
        System.out.println(separator);
    }



    public void setCoordinates(int x, int y, ShipPart shipPart){
        coordinates[x][y] = shipPart;
    }

    public void setCoordinates(int x, int y, String value){
        coordinates[x][y] = value;
    }

    public Object getCoordinates(int x, int y) {
        return coordinates[x][y];
    }



    public void printPlayerBoard() {
        char pipeVertical = '\u2502';
        char pipeHorizontal = '\u2015';
        String topMarks = "ABCDEFGHIJ";
        String sideMarks = "0123456789";

        String separator = "";

        int n = 42;
        for(int i=0; i < n; i++)
        {
            separator = separator + pipeHorizontal;
        }
        System.out.println("Your Board");
        //System.out.println(this.player.getNickname());

        for (int i = 0; i < topMarks.length(); i++)
        {
            System.out.print("   " + topMarks.charAt(i));
        }
        System.out.println();

        for(int i = 0; i < coordinates.length; i++)
        {
            System.out.println(separator);
            System.out.print(sideMarks.charAt(i));
            for(int j = 0; j < coordinates.length; j++)
            {
                System.out.print(pipeVertical + " ");
                Object statek = coordinates[i][j];
                if(statek != "W"){
                    System.out.print("X ");
                } else {
                    System.out.print(coordinates[i][j] + " ");

                }
            }
            System.out.println(pipeVertical);
        }
        System.out.println(separator);
    }

//    public square[][] getGameBoard() {
//        return gameBoard;
//    }

    public Player getPlayer(){
        return this.player;
    }

    public void setMyBoard(Board myBoard){
        this.myBoard = myBoard;
    }
}
