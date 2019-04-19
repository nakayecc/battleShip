import java.sql.Array;
import java.util.Random;

public class Si {
    private int difficulty;
    private Player bot;
    private Player player;
    private Board board;
    private boolean siTurn;
    private Array[][] hittinAreaCoordinates = new Array[10][10];


    public Si() {
        this.siTurn = true;


    }
    public void setBoard(Board board){
        this.board = board;
    }


    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public boolean getSiTurn() {
        return siTurn;
    }


    public void siStartGame(Player bot, Player player) {
        this.bot = bot;
        this.player = player;
        shot(1);
        System.out.println("fsdf");


    }

    private int[] generateRandomCoordinate() {
        Random rndCoordinates = new Random();
        int[] randomNumber = new int[2];
        do {
            randomNumber[0] = rndCoordinates.nextInt(9);
            randomNumber[1] = rndCoordinates.nextInt((9));
        } while (board.getCoordinates(randomNumber[0],randomNumber[1]) == null);

        return randomNumber;

    }

    private void shot(int difficulty) {
        Object hittenPlace = new Object();


       // while (siTurn) {
            int[] coordinates = generateRandomCoordinate();
            //int x = coordinates[0];
            //int y = coordinates[1];
            int x = 1;
            int y = 1;
            hittenPlace = board.getCoordinates(x, y);


            switch (difficulty) {
                case 1: {
                    if (board.getCoordinates(x, y) != "W" || board.getCoordinates(x, y) == "X") {

                        hittenPlace = "X";
                        System.out.println(x + " " + y);
                        this.player.setEnnemyBoard(x,y,"*");

                    } else {
                        hittenPlace = "O";
                        this.siTurn = false;
                        this.bot.setTurn(false);
                        this.player.setTurn(true);
                        this.player.setEnnemyBoard(x,y,"O");
                        System.out.println(x + " " + y);


                    }
                    break;

                }
            }
        //}
    }
//                case 2: {
//                    if (gameBoard[x][y].getName() == "S" || gameBoard[x][y].getName() == "X") {
//                        gameBoard[x][y].setName("X");
//                        gameBoard[x][y].setDestroyed(true);
//                        System.out.println(x + " " + y);
//                        checkAreaNearHitPlaceLevelMedium(x, y);
//
//                    } else {
//                        gameBoard[x][y].setName("O");
//                        System.out.println(x + " " + y);
//                        this.siTurn = false;
//                    }
//                    break;
//                }
//                case 3: {
//                    for (int i = 0; i < 10; i++) {
//                        for (int j = 0; j < 10; j++) {
//                            System.out.print(hittinAreaCoordinates[i][j]);
//                        }
//                    }
//
//
//                    if (hittinAreaCoordinates[x][y] != null) {
//                        if (gameBoard[x][y].getName() == "S" || gameBoard[x][y].getName() == "X") {
//                            gameBoard[x][y].setName("X");
//                            gameBoard[x][y].setDestroyed(true);
//                            hittinAreaCoordinates[x][y] = null;
//
//                            checkAreaNearHitPlaceLevelHigh(x, y);
//                            System.out.println(hittinAreaCoordinates[x][y]);
//
//                        } else {
//                            gameBoard[x][y].setName("O");
//                            hittinAreaCoordinates[x][y] = null;
//                            System.out.println(hittinAreaCoordinates[x][y]);
//                            this.siTurn = false;
//                        }
//                    }
//                    break;
//                }
//            }
//        }
//    }
//
//    private void checkAreaNearHitPlaceLevelMedium(int x, int y) {
//        // x right left
//        //y up down
//        //check right left area
//        int up = x - 1;
//        int down = x + 1;
//        int right = y + 1;
//        int left = y - 1;
//        Random randomDirection = new Random();
//        int direction = randomDirection.nextInt(3);
//
//        while (siTurn) {
//            /*direction 0 = right
//            1 = left
//            2 = up
//            3 = down
//             */
//
//            switch (direction) {
//                case 0: {
//                    //right
//                    if (y < 9 && y != 0) {
//
//                        if (gameBoard[x][right].getName() == "S" || gameBoard[x][right].getName() == "X") {
//                            gameBoard[x][right].setName("X");
//                            gameBoard[x][right].setDestroyed(true);
//                            right += 1;
//                        } else {
//                            gameBoard[x][right].setName("O");
//                            this.siTurn = false;
//                            break;
//                        }
//                    } else {
//                        direction = 1;
//                    }
//                    break;
//
//                }
//                case 1: {
//                    //left
//                    if (y > 0 && y != 9) {
//                        if (gameBoard[x][left].getName() == "S" || gameBoard[x][left].getName() == "X") {
//                            gameBoard[x][left].setName("X");
//                            gameBoard[x][left].setDestroyed(true);
//                            left -= 1;
//                        } else {
//                            gameBoard[x][left].setName("O");
//                            this.siTurn = false;
//                            break;
//                        }
//                    } else {
//                        direction = 0;
//                    }
//                    break;
//                }
//                case 2: {
//                    //up
//                    if (x <= 9 && x != 0) {
//                        if (gameBoard[up][y].getName() == "S" || gameBoard[up][y].getName() == "X") {
//                            gameBoard[up][y].setName("X");
//                            gameBoard[up][y].setDestroyed(true);
//                            up -= 1;
//                        } else {
//                            gameBoard[up][y].setName("O");
//                            this.siTurn = false;
//                            break;
//                        }
//                    } else {
//                        direction = 3;
//                    }
//                    break;
//                }
//                case 3: {
//                    //down
//                    if (x > 0 && x != 9) {
//                        if (gameBoard[down][y].getName() == "S" || gameBoard[down][y].getName() == "X") {
//                            gameBoard[down][y].setName("X");
//                            gameBoard[down][y].setDestroyed(true);
//                            down += 1;
//                        } else {
//                            gameBoard[down][y].setName("O");
//                            this.siTurn = false;
//                            break;
//                        }
//                    } else {
//                        direction = 2;
//                    }
//                    break;
//                }
//            }
//        }
//    }

//    private void checkAreaNearHitPlaceLevelHigh(int x, int y) {
//        // x right left
//        //y up down
//        //check right left area
//        int up = x - 1;
//        int down = x + 1;
//        int right = y + 1;
//        int left = y - 1;
//        Random randomDirection = new Random();
//        int direction = randomDirection.nextInt(3);
//        //int direction = 0;
//
//        while (siTurn) {
//            /*direction 0 = right
//            1 = left
//            2 = up
//            3 = down
//             */
//
//            switch (direction) {
//                case 0: {
//                    //right
//                    if (y < 9 && y != 0) {
//
//                        if (gameBoard[x][right].getName() == "S" || gameBoard[x][right].getName() == "X") {
//                            gameBoard[x][right].setName("X");
//                            gameBoard[x][right].setDestroyed(true);
//                            hittinAreaCoordinates[x][right] = null;
//                            right += 1;
//                        } else {
//                            gameBoard[x][right].setName("O");
//                            hittinAreaCoordinates[x][right] = null;
//                            this.siTurn = false;
//                            break;
//                        }
//                    } else {
//                        direction = 1;
//                    }
//                    break;
//
//                }
//                case 1: {
//                    //left
//                    if (y > 0 && y != 9) {
//                        if (gameBoard[x][left].getName() == "S" || gameBoard[x][left].getName() == "X") {
//                            gameBoard[x][left].setName("X");
//                            gameBoard[x][left].setDestroyed(true);
//                            hittinAreaCoordinates[x][left] = null;
//                            left -= 1;
//                        } else {
//                            gameBoard[x][left].setName("O");
//                            hittinAreaCoordinates[x][left] = null;
//                            this.siTurn = false;
//                            break;
//                        }
//                    } else {
//                        direction = 0;
//                    }
//                    break;
//                }
//                case 2: {
//                    //up
//                    if (x <= 9 && x != 0) {
//                        if (gameBoard[up][y].getName() == "S" || gameBoard[up][y].getName() == "X") {
//                            gameBoard[up][y].setName("X");
//                            gameBoard[up][y].setDestroyed(true);
//                            hittinAreaCoordinates[up][y] = null;
//                            up -= 1;
//                        } else {
//                            gameBoard[up][y].setName("O");
//                            hittinAreaCoordinates[up][y] = null;
//                            this.siTurn = false;
//                            break;
//                        }
//                    } else {
//                        direction = 3;
//                    }
//                    break;
//                }
//                case 3: {
//                    //down
//                    if (x > 0 && x != 9) {
//                        if (gameBoard[down][y].getName() == "S" || gameBoard[down][y].getName() == "X") {
//                            gameBoard[down][y].setName("X");
//                            gameBoard[down][y].setDestroyed(true);
//                            hittinAreaCoordinates[down][y] = null;
//                            down += 1;
//                        } else {
//                            gameBoard[down][y].setName("O");
//                            this.siTurn = false;
//                            hittinAreaCoordinates[down][y] = null;
//                            break;
//                        }
//                    } else {
//                        direction = 2;
//                    }
//                    break;
//                }
//            }
//        }
//    }

//    private void fillHittingCoordinates() {
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                this.hittinAreaCoordinates[i][j] = new square(i, j);
//            }
//        }
//
//    }


}
