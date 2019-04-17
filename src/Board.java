
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

        gameBoard[1][2].setName("S");
        gameBoard[2][2].setName("S");
        gameBoard[3][2].setName("S");

    }


    public void printBoard() {
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

        for (int i = 0; i < topMarks.length(); i++)
        {
            System.out.print("   " + topMarks.charAt(i));
        }
        System.out.println();

        for(int i = 0; i < gameBoard.length; i++)
        {
            System.out.println(separator);
            System.out.print(sideMarks.charAt(i));
            for(int j = 0; j < gameBoard.length; j++)
            {
                System.out.print(pipeVertical + " ");
                System.out.print(gameBoard[i][j].getName() + " ");
            }
            System.out.println(pipeVertical);
        }
        System.out.println(separator);
    }
}
