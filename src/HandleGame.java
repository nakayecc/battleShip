import java.util.Scanner;

public class HandleGame
{




    public void runApp(){
        Board board = new Board();
        Scanner userShotX = new Scanner(System.in);
        Scanner userShotY = new Scanner(System.in);
        board.printBoard();
        int x = userShotX.nextInt();
        int y = userShotY.nextInt();
        shot(x, y);
        board.printBoard();


    }

    private void shot(int x, int y){
        square[][] board = Board.getGameBoard();
        if(board[x][y].getName() == "S") {
            board[x][y].setName("X");
        }
        System.out.println(board[x][y]);





    }
    
}
