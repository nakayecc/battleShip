public class Player {
    private boolean turn;
    private int score = 0;

    public boolean getTurn() {
        return turn;
    }

    public int getScore() {
        return score;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
