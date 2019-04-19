import java.util.ArrayList;
import java.util.List;

public class Shipyard {
    private List fleet;
    private Board board;

    public Shipyard(Board board) { //player
        this.board = board;
        this.fleet = new ArrayList();

    }


    public void makeShip(String shipClass, int posX, int posY, String direction) {
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
                //System.out.println("Robie crusiera");
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
                //System.out.println("Robie crusiera prawo");
                break;
            case "up":
                endPosX = posX;
                endPosY = posY - shipLen;
                break;
            case "down":
                endPosX = posX;
                endPosY = posY + shipLen;
        }


        if (checkSpace(this.board, posX, posY, endPosX, endPosY, shipLen, direction)) {
            Ship ship = new Ship(shipLen);
            board.setStatek(ship);
            for (int len = 0; len < shipLen; len++) {
                ShipPart shipPart = new ShipPart(posX, posY);
                System.out.println("Robie szip parta");
                System.out.println(posX + " " + posY);

                //this.board.setShipPart(shipPart);
                ship.addShipPart(shipPart, board);


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
            fleet.add(ship.getShipParts());
        } else {
            System.out.println("Error");}

    }



    public boolean checkSpace(Board board, int startPosX, int startPosY, int endPosX, int endPosY, int shipLen, String direcion) {

        if (startPosX < -1 || startPosY < -1 || endPosX < -1 || endPosY < -1) {
            return false;
        }
        if (startPosX > 10 || startPosY > 10 || endPosX > 10 || endPosY > 10) {
            return false;
        }

        for (int shipPart = 0; shipPart < shipLen; shipPart++) {

                switch (direcion) {
                    case "left":
                        if (checkMiddleSpace(board, startPosX, startPosY)) return false;
                        if (checkUpSpace(board, startPosX, startPosY)) return false;
                        if (checkDownSpace(board, startPosX, startPosY)) return false;
                        if (checkLeftSpace(board, startPosX, startPosY)) return false;
                        startPosX -= 1;
                        break;
                    case "right":
                        if (checkMiddleSpace(board, startPosX, startPosY)) return false;
                        if (checkUpSpace(board, startPosX, startPosY)) return false;
                        if (checkDownSpace(board, startPosX, startPosY)) return false;
                        if (checkRightSpace(board, startPosX, startPosY)) return false;
                        startPosX += 1;
                        break;

                    case "up":
                        if (checkMiddleSpace(board, startPosX, startPosY)) return false;
                        if (checkLeftSpace(board, startPosX, startPosY)) return false;
                        if (checkRightSpace(board, startPosX, startPosY)) return false;
                        if (checkUpSpace(board, startPosX, startPosY)) return false;
                        startPosY -= 1;
                        break;
                    case "down":
                        if (checkMiddleSpace(board, startPosX, startPosY)) return false;
                        if (checkLeftSpace(board, startPosX, startPosY)) return false;
                        if (checkRightSpace(board, startPosX, startPosY)) return false;
                        if (checkDownSpace(board, startPosX, startPosY)) return false;
                        startPosY += 1;
                        break;
                }
            }return true;
    }

    public boolean checkLeftSpace(Board board, int startPosX, int startPosY) {
        if (startPosX - 1 < 0) {
            return false;
        } else {
            if (board.isShip()) {
                return true;
            }
        }
        return false;
    }

    public boolean checkRightSpace(Board board, int startPosX, int startPosY) {
        if (startPosX + 1 > 10) {
            return false;
        } else {
            if (board.isShip()) {
                return true;
            }
        }
        return false;
    }

    public boolean checkUpSpace(Board board, int startPosX, int startPosY) {
        if (startPosY - 1 < 0) {
            return false;
        } else {
            if (board.isShip()) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDownSpace(Board board, int startPosX, int startPosY) {
        if (startPosY + 1 > 10) {
            return false;
        } else {
            if (board.isShip()) {
                return true;
            }
        }
        return false;
    }

    public boolean checkMiddleSpace(Board board, int startPosX, int startPosY) {
        if (board.isShip()) {
            return true;
        }
        return false;
    }

    public List getFleet() {
        return fleet;
    }
}
