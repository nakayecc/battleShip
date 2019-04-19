public class ShipPart {
    private int x;
    private int y;
    private boolean isHit;

    public ShipPart(int x, int y){
        this.x = x;
        this.y = y;
        this.isHit = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public boolean isHit() {
        return isHit;
    }


}
