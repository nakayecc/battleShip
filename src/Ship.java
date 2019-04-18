import java.util.ArrayList;
import java.util.List;

public class Ship {
    private int size;
    List<ShipPart> shipParts;


    public Ship(int size){
        this.size = size;
        shipParts = new ArrayList<>();
    }

    public void addShipPart(ShipPart shipPart){
        shipParts.add(shipPart);//todo: checksize
    }

    public List<ShipPart> getShipParts() {
        return shipParts;
    }

    boolean isShipLive(){
        //todo: implement

        return true;
    }

}

