import java.util.ArrayList;
import java.util.List;

public class Ship {
    private int size;
    private List<ShipPart> shipParts;


    public Ship(int size) {
        this.size = size;
        shipParts = new ArrayList<>();
    }

    public void addShipPart(ShipPart shipPart) {
        shipParts.add(shipPart);//todo: checksize
    }

    public List<ShipPart> getShipParts() {
        return shipParts;
    }

    boolean isShipLive() {
        int counter = 0;
        for (int singlepart = 0; singlepart < shipParts.size(); singlepart++) {
            if (shipParts.get(singlepart).isHit()) {
                counter += 1;
            }
        }

        if (counter == shipParts.size()) {
            return false;
        }

        return true;
    }

}

