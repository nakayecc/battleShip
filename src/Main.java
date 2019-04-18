import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
       // Menu.menu();
        Board board = new Board();
        Shipyard sy = new Shipyard(board);
        Ship ship;

        sy.makeShip("Destroyer",3,3,"right");
       // sy.makeShip("Carrier",1,2,"right");
        sy.makeShip("Destroyer",2,5,"up");
        //System.out.println(board.getGameBoard()[0][1].isShip());
        //board.printBoard();


        System.out.println(sy.getFleet());
        board.getGameBoard()[3][3].getShipPart().setHit(true);
        board.getGameBoard()[4][3].getShipPart().setHit(true);

       List tmp = new ArrayList<>();
            tmp= sy.getFleet();
          Ship List = tmp.get(0);

        System.out.println(tmp.get(0).isHit());

        System.out.println(board.getGameBoard()[3][3].getShipPart().isHit());
        System.out.println(board.getGameBoard()[4][3].getShipPart().isHit());






    }
}
