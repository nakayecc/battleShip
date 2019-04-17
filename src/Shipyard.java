import java.util.List;

public class Shipyard {
    private List<Shipyard> fleet;
    private square board[][];
    private Board boardTable;

    public Shipyard(Board board) {
        this.boardTable = board ;
        this.board = boardTable.getGameBoard();

    }


    public void makeHhip(String shipClass, int sPosX, int sPosY, int ePosX, int ePosY){
        List<square> ship;




    }


    @Override
    public String toString() {
        return board[0][0].toString();
    }
}
