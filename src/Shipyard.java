import java.util.ArrayList;
import java.util.List;

public class Shipyard {
    private List fleet;
    private square board[][];
    private Board boardTable;

    public Shipyard(Board board) {
        this.boardTable = board;
        this.board = boardTable.getGameBoard();
        this.fleet = new ArrayList();

    }


    public void makeShip(String shipClass, int posX, int posY, String direction) {
        List<square> ship = new ArrayList();
        int shipLen = 0;
        int endPosX = 0;
        int endPosY = 0;

        switch (shipClass) {

            case "Carrier":
                shipLen = 5;
                break;
            case "Battleship":
                shipLen = 4;
                break;
            case "Cruiser":
                shipLen = 3;
                break;
            case "Submarine":
                shipLen = 3;
                break;
            case "Destroyer":
                shipLen = 2;
                break;
        }

        switch (direction) {
            case "left":
                endPosX = posX - shipLen;
                endPosY = posY;
                break;
            case "right":
                endPosX = posX + shipLen;
                endPosY = posY;
                break;
            case "up":
                endPosX = posX;
                endPosY = posY + shipLen;
                break;
            case "down":
                endPosX = posX;
                endPosY = posY - shipLen;
        }


        if (checkSpace(board, posX, posY, endPosX, endPosY, shipLen, "left")) {
            for (int len = 0; len < shipLen; len++) {
                board[posX][posY].setName("S");
                ship.add(board[posX][posY]);
                if (direction == "left") {
                    posX -= 1;
                } else if (direction == "right") {
                    posX += 1;
                } else if (direction == "up") {
                    posY -= 1;
                } else if (direction == "down") {
                    posY += 1;
                }
            }
        }
        fleet.add(ship);


    }


    public boolean checkSpace(square board[][], int startPosX, int startPosY, int endPosX, int endPosY, int shipLen, String direcion) {

        if (startPosX < -1 || startPosY < -1 || endPosX < -1 || endPosY < -1) {
            return false;
        }
        if (startPosX > 10 || startPosY > 10 || endPosX > 10 || endPosY > 10) {
            return false;
        }

        for (int shipPart = 0; shipPart < shipLen; shipPart++) {
            if (shipPart == 0) {
                if (checkFirstSingleSquare(board, startPosX, startPosY)) {
                    return false;
                }
            } else if (checkMiddleSingleSquare(board, startPosX, startPosY, direcion)) {
                return false;
            }
            if (direcion == "left") {
                startPosY -= 1;
            } else if (direcion == "right") {
                startPosY -= 1;
            } else if (direcion == "up") {
                startPosX += 1;
            } else if (direcion == "down") {
                startPosX -= 1;
            }
        }
        return true;
    }

    public boolean checkFirstSingleSquare(square board[][], int startPosX, int startPosY) {

        if (board[startPosX][startPosY].getName() == "S" || board[startPosX - 1][startPosY].getName() == "S" ||
                board[startPosX][startPosY + 1].getName() == "S" || board[startPosX][startPosY - 1].getName() == "S" ||
                board[startPosX + 1][startPosY].getName() == "S") {
            return true;
        }
        return false;
    }

    public boolean checkMiddleSingleSquare(square board[][], int startPosX, int startPosY, String direction) {
        if (direction == "left") {
            if (board[startPosX][startPosY + 1].getName() == "S" || board[startPosX][startPosY - 1].getName() == "S" || board[startPosX - 1][startPosY].getName() == "S") {
                return true;
            }
        } else if (direction == "right") {
            if (board[startPosX][startPosY + 1].getName() == "S" || board[startPosX][startPosY - 1].getName() == "S" || board[startPosX + 1][startPosY].getName() == "S") {
                return true;
            }
        } else if (direction == "up") {
            if (board[startPosX + 1][startPosY].getName() == "S" || board[startPosX][startPosY - 1].getName() == "S" || board[startPosX][startPosY + 1].getName() == "S") {
                return true;
            }
        } else if (direction == "down") {
            if (board[startPosX - 1][startPosY].getName() == "S" || board[startPosX][startPosY - 1].getName() == "S" || board[startPosX][startPosY + 1].getName() == "S") {
                return true;
            }
        }
        return false;
    }

    public List getFleet() {
        return fleet;
    }
}
