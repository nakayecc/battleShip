public class Main {
    public static void main(String[] args){
        //Menu.menu();

        Board board = new Board();
        Shipyard sy = new Shipyard(board);

        //board.printBoard();
        System.out.println(sy);
    }
}
