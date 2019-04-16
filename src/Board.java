
public class Board {
    private static final int boardHeight = 10;
    private static final int boardWidth = 10;
    private static square[][] gameBoard = new square[10][10];

    public Board() {
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                gameBoard[i][j] = new square(i, j);
            }
        }

        gameBoard[1][1].setName("S");
        gameBoard[1][2].setName("S");
        gameBoard[1][3].setName("S");

    }


    public void printBoard() {
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                System.out.print(gameBoard[i][j].getName() + " ");
            }
            System.out.println("\n");
        }
    }
}