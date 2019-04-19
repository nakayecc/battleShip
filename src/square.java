public class square {
    private int xPos;
    private int yPos;
    private boolean isShip;
    private boolean isHit;
    private ShipPart shipPart;
    private String name;
    public square(int x, int y) {
        this.xPos = x;
        this.yPos = y;
        this.isShip = false;
        this.isHit = false;
        this.name = " ";


    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public boolean isShip() {
        return isShip;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public void setShipPart(ShipPart shipPart) {
        this.shipPart = shipPart;
        this.isShip = true;
        this.name = "S";
        System.out.println(this.xPos + this.yPos);
    }

    public ShipPart getShipPart() {
        return shipPart;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return xPos +" "+ yPos +" ";
    }

    public void setName(String name) {
        this.name = name;
    }
}
