
public class Board
{
    private static final int boardHeight = 10;
    private static final int boardWidth = 10;
    private static int[][] gameBoard;

    public static void CreateGameBoard()
    {
        char pipeVertical = '\u2502';
        char pipeHorizontal = '\u2015';
        String topMarks = "ABCDEFGHIJ";
        String sideMarks = "9876543210";

        String separator = "";

        int n = 42;
        for(int i=0; i < n; i++)
        {
            separator = separator + pipeHorizontal;
        }

        gameBoard = new int[boardWidth][boardHeight];

        for (int i = 0; i < topMarks.length(); i++)
        {
            System.out.print("   " + topMarks.charAt(i));
        }
        System.out.println();

        char miss = 'O';
        for(int i = gameBoard.length - 1; i >= 0; i--)
        {
            System.out.println(separator);
            System.out.print(sideMarks.charAt(i));
            for(int j = 0; j < gameBoard.length; j++)
            {
                gameBoard[i][j] = i * boardWidth + j + 1;
                System.out.print(pipeVertical  + "   ");
            }
            System.out.println(pipeVertical);
        }
        System.out.println(separator);
    }
}

//System.out.print(String.format("%-5s%-5d|", "|", 7)); formatowanie stringa