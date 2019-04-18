import java.util.Random;

public class Si {
    private int difficulty;
    private Board board;
    private square gameBoard[][];
    private boolean siTurn;


    public Si(Board board) {
        this.board = board;
        this.gameBoard = board.getGameBoard();
    }

    public void setSiTurn(boolean siTurn) {
        this.siTurn = siTurn;
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


    public void siStartGame() {

        shot(this.difficulty);
        System.out.println("fsdf");


    }

    private void shot(int difficulty) {
        while (siTurn) {
            Random randomCoordinates = new Random();
            int x = randomCoordinates.nextInt(9);
            int y = randomCoordinates.nextInt(9);

            switch (difficulty) {
                case 1: {
                    if (gameBoard[x][y].getName() == "S" || gameBoard[x][y].getName() == "X") {
                        gameBoard[x][y].setName("X");
                        gameBoard[x][y].setDestroyed(true);
                    } else {
                        gameBoard[x][y].setName("O");
                        this.siTurn = false;

                    }

                }
                case 2: {
                    if (gameBoard[x][y].getName() == "S") {
                        gameBoard[x][y].setName("X");
                        gameBoard[x][y].setDestroyed(true);
                        checkAreaNearHitPlaceLevelMedium(x, y);

                    } else {
                        gameBoard[x][y].setName("O");
                        this.siTurn = false;
                    }


                }
            }
        }
    }

    private void checkAreaNearHitPlaceLevelMedium(int x, int y) {
        // x right left
        //y up down
        //check right left area
        int oldXright = x;
        int oldXleft = x;
        int oldYup = y;
        int oldYdown = y;
        int right = oldXright + 1;
        int left = oldXleft - 1;
        int up = oldYup + 1;
        int down = oldYdown - 1;
        Random randomDirection = new Random();
        int direction = randomDirection.nextInt(3);
        System.out.println(direction);


        while(siTurn) {
            /*direction 0 = right
            1 = left
            2 = up
            3 = down
             */

            switch (direction) {
                case 0: {
                    if (x < 9) {
                        if (gameBoard[right][y].getName() == "S" || gameBoard[right][y].getName() == "X") {
                            gameBoard[right][y].setName("X");
                            gameBoard[right][y].setDestroyed(true);
                            oldXright = right;
                        } else {
                            gameBoard[right][y].setName("O");
                            this.siTurn = false;
                        }
                    } else {
                        direction = 1;
                    }

                }
                case 1: {
                    if (x > 0) {
                        if (gameBoard[left][y].getName() == "S" || gameBoard[left][y].getName() == "X") {
                            gameBoard[left][y].setName("X");
                            gameBoard[left][y].setDestroyed(true);
                            oldXleft = left;
                        } else {
                            gameBoard[left][y].setName("O");
                            this.siTurn = false;
                        }
                    } else {
                        direction = 0;
                    }
                }
                case 2: {
                    if (y < 9) {
                        if (gameBoard[x][up].getName() == "S" || gameBoard[x][up].getName() == "X") {
                            gameBoard[x][up].setName("X");
                            gameBoard[x][up].setDestroyed(true);
                            oldYup = up;
                        } else {
                            gameBoard[x][up].setName("O");
                            this.siTurn = false;
                        }
                    } else {
                        direction = 3;
                    }
                }
                case 3: {
                    if (y > 0) {
                        if (gameBoard[x][down].getName() == "S" || gameBoard[x][down].getName() == "X") {
                            gameBoard[x][down].setName("X");
                            gameBoard[x][down].setDestroyed(true);
                            oldYdown = down;
                        } else {
                            gameBoard[x][down].setName("O");
                            this.siTurn = false;
                        }
                    } else {
                        direction = 2;
                    }
                }
            }
        }
    }
}
