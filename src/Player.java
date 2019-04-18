import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private boolean turn;
    private int score = 0;
    private Shipyard shipyard;
    private Board board;
    private List<List<ShipPart>> ships;

    public Player(Shipyard shipyard, Board board) {
        this.shipyard = shipyard;
        this.board = board;
        this.ships = new ArrayList<>(shipyard.getFleet());
    }

    public void shot(int x, int y) {
        for (int shipCounter = 0; shipCounter < ships.size(); shipCounter++) {
            for (int shipElement = 0; shipElement < ships.get(shipCounter).size(); shipElement++) {
                if (ships.get(shipCounter).get(shipCounter).getX() == x && ships.get(shipCounter).get(shipElement).getY() == y) {
                    ships.get(shipCounter).get(shipElement).setHit(true);
                    board.getGameBoard()[x][y].setName("X");
                    return;
                }
            }
        }
        board.getGameBoard()[x][y].setName("O");
    }

    public void rollShip() {

        Random random = new Random();
        int index = 0;
        String[] shipType = {"Carrier", "Battleship", "Cruiser", "Submarine", "Destroyer"};
        String[] shipDirection = {"left", "right", "up", "down"};
        do {
            if (shipyard.makeShip(shipType[index], random.nextInt(9), random.nextInt(9), shipDirection[random.nextInt(4)])) {
                index += 1;
            }

        } while (index < 5);

    }


    public boolean getTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public int getScore() {
        return score;
    }


    public void setScore(int score) {
        this.score = score;
    }

    public List<List<ShipPart>> getShips() {
        return ships;
    }

    public void setShips(List<List<ShipPart>> ships) {
        this.ships = ships;
    }
}
