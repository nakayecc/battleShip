
public class Board {
    private static final int boardHeight = 10;
    private static final int boardWidth = 10;
    private square[][] gameBoard = new square[10][10];

    public Board() {
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                gameBoard[i][j] = new square(i, j);
            }
        }

    }


    public void printBoard(Board playerBoard, Board aiBoard) {
        char pipeVertical = '\u2502';
        char pipeHorizontal = '\u2015';
        String topMarks = "0123456789";
        String sideMarks = "0123456789";

        String separator = "";
        String spaceBetweenBoards = "       ";
        String spaceBetweenSeparators = "      ";

        int n = 42;
        for (int l = 0; l < n; l++) {
            separator = separator + pipeHorizontal;
        }

        for (int m = 0; m < topMarks.length(); m++) {
            System.out.print("   " + topMarks.charAt(m));
        }
        System.out.print("        ");
        for (int o = 0; o < topMarks.length(); o++) {
            System.out.print("   " + topMarks.charAt(o));
        }


        for (int i = 0; i < playerBoard.gameBoard.length; i++) {
            System.out.println();
            System.out.print(separator);
            System.out.print(spaceBetweenSeparators);
            System.out.println(separator);

            System.out.print(sideMarks.charAt(i));
            for (int j = 0; j < playerBoard.gameBoard.length; j++) {
                System.out.print(pipeVertical + " ");
                System.out.print(playerBoard.gameBoard[j][i].getName() + " ");
            }

            System.out.print(spaceBetweenBoards);

            System.out.print(sideMarks.charAt(i));
            for (int k = 0; k < aiBoard.gameBoard.length; k++) {
                System.out.print(pipeVertical + " ");
                System.out.print(aiBoard.gameBoard[k][i].getName() + " ");
            }
        }
    }

    public void printBoard(Board board) {
        char pipeVertical = '\u2502';
        char pipeHorizontal = '\u2015';
        String topMarks = "0123456789";
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

        for(int i = 0; i < board.getGameBoard().length; i++)
        {
            System.out.println(separator);
            System.out.print(sideMarks.charAt(i));
            for(int j = 0; j < board.getGameBoard().length; j++)
            {
                System.out.print(pipeVertical + " ");
                System.out.print(board.getGameBoard()[j][i].getName() + " ");
            }
            System.out.println(pipeVertical);
        }
        System.out.println(separator);
    }

    public square[][] getGameBoard() {
        return gameBoard;
    }
}
