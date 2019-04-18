import java.util.Random;

public class Si {
    private int difficulty;
    private Board board;
    private square gameBoard[][];
    private boolean siTurn;


    public Si(Board board){
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


    public void siStartGame(){

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
                    if (gameBoard[x][y].getName() == "S") {
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
                        checkAreaNearHiddenPlace(x,y);

                    } else {
                        gameBoard[x][y].setName("O");
                        this.siTurn = false;
                    }



                }
            }
        }
    }
    private void checkAreaNearHiddenPlace(int x, int y){
        // x right left
        //y up down
        //check right left area
        int right = x + 1;
        int left =  x - 1;
        int up = y + 1;
        int down = y -1;
        if (x < 9 && x > 0) {
            if (gameBoard[right][y].getName() == "S") {
                gameBoard[right][y].setName("X");
                gameBoard[right][y].setDestroyed(true);
            } else if (gameBoard[left][y].getName() == "S") {
                gameBoard[left][y].setName("X");
                gameBoard[left][y].setDestroyed(true);
            }
        } else if(y < 9 && y > 0){
            if (gameBoard[x][up].getName() == "S") {
                gameBoard[x][up].setName("X");
                gameBoard[x][up].setDestroyed(true);
            } else if (gameBoard[x][down].getName() == "S") {
                gameBoard[x][down].setName("X");
                gameBoard[x][down].setDestroyed(true);
            }
        }

    }
}
