public class square {
    private int xPos;
    private int yPos;
    private String name;

    public square(int x, int y) {
        this.xPos = x;
        this.yPos = y;
        this.name="W";

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

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return xPos +" "+ yPos +" "+ name;
    }
}
