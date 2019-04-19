public class Player {
    private boolean turn;
    private Board playerBoard; // nassze statki
    private Board ennemyBoard; //nasza czysta karta
    private Board ennemyHiddenBoard; // statki przeciwnika

    private int score = 0;
    private String nickname = "Joshua";

    public Player(String nickname, boolean cleanBoard){
        this.nickname = nickname;
        this.playerBoard = new Board(cleanBoard, this);
        this.ennemyBoard = new Board(true, this);
    }



    public boolean getTurn() {
        return turn;
    }

    public void setEnnemyBoard(int x, int y, String value) {
        this.ennemyBoard.setCoordinates(x, y, value);
    }

    public void setEnnemyBoard(Board ennemyBoard) {
        this.ennemyBoard = ennemyBoard;
    }

    public void setEnnemyHiddenBoard(Board ennemyHiddenBoard) {
        this.ennemyHiddenBoard = ennemyHiddenBoard;
    }

    public Board getEnnemyHiddenBoard() {
        return ennemyHiddenBoard;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public int getScore() {
        return score;
    }

    public Board getPlayerBoard() {
        return playerBoard;
    }

    public Board getEnnemyBoard() {
        return ennemyBoard;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNickname() {
        return nickname;
    }

}
