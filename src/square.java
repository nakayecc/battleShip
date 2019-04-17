public class square {
    private int xPos;
    private int yPos;
    private String name;
    private boolean isDestroyed;

    public square(int x, int y) {
        this.xPos = x;
        this.yPos = y;
        this.name=" ";

    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }
    public boolean getDestroyed(){
        return isDestroyed;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return xPos +" "+ yPos +" "+ name;
    }
}
