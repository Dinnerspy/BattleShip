//Class for battle ship
package battleship;


public class PlayingBoard {

    int xCounter, yCounter, Ship1Counter, Ship2Counter, Ship3Counter, Ship4Counter, Ship5Counter;
    String[][] ShipGrid = new String[10][10];
    String[][] ShotGrid = new String[10][10];

    public PlayingBoard() {

        xCounter = 0;
        while (xCounter < 10) {

            yCounter = 0;
            while (yCounter < 10) {
                ShipGrid[yCounter][xCounter] = "empty";
                yCounter++;

            }
            xCounter++;
        }

        xCounter = 0;
        while (xCounter < 10) {

            yCounter = 0;
            while (yCounter < 10) {
                ShotGrid[yCounter][xCounter] = "O";
                yCounter++;

            }
            xCounter++;
        }
    }

    public boolean putShip(int ShipXCord, int ShipYCord, String ShipOrentation, int ShipNumber) {

        if (validateShip(ShipXCord, ShipYCord, ShipOrentation, ShipNumber) == false) {
            return false;
        }

        xCounter = 1;
        ShipGrid[ShipYCord - 1][ShipXCord] = "Ship " + ShipNumber;

        while (xCounter < 5) {
            switch (ShipOrentation) {
                case "UP": {

                    ShipGrid[ShipYCord - xCounter - 1][ShipXCord] = "Ship " + ShipNumber;

                    break;
                }
                case "DOWN": {

                    ShipGrid[ShipYCord + xCounter - 1][ShipXCord] = "Ship " + ShipNumber;

                    break;
                }
                case "LEFT": {

                    ShipGrid[ShipYCord - 1][ShipXCord - xCounter] = "Ship " + ShipNumber;

                    break;
                }
                case "RIGHT": {

                    ShipGrid[ShipYCord - 1][ShipXCord + xCounter] = "Ship " + ShipNumber;

                    break;
                }
                default: {

                }

            }
            xCounter++;

        }
        return true;

    }

    public boolean validateShip(int ShipXCord, int ShipYCord, String ShipOrentation, int ShipNumber) {

        switch (ShipOrentation) {
            case "UP": {
                if (!(ShipYCord > 4)) {
                    return false;
                }
                break;

            }
            case "DOWN": {
                if (!(ShipYCord < 7)) {
                    return false;
                }
                break;
            }
            case "LEFT": {
                if (!(ShipXCord > 3)) {
                    return false;
                }
                break;
            }
            case "RIGHT": {
                if (!(ShipXCord < 6)) {
                    return false;
                }
                break;
            }
            default: {

            }
        }

        xCounter = 1;
        if (ShipGrid[ShipYCord - 1][ShipXCord].contains("empty")) {

        } else {
            return false;
        }

        while (xCounter < 5) {
            switch (ShipOrentation) {
                case "UP": {
                    if (ShipGrid[ShipYCord - xCounter - 1][ShipXCord].contains("empty")) {
                    } else {
                        return false;
                    }

                    break;
                }
                case "DOWN": {

                    if (ShipGrid[ShipYCord + xCounter - 1][ShipXCord].contains("empty")) {
                    } else {
                        return false;
                    }

                    break;
                }
                case "LEFT": {

                    if (ShipGrid[ShipYCord - 1][ShipXCord - xCounter].contains("empty")) {
                    } else {
                        return false;
                    }

                    break;
                }
                case "RIGHT": {

                    if (ShipGrid[ShipYCord - 1][ShipXCord + xCounter].contains("empty")) {
                    } else {
                        return false;
                    }
                    break;
                }
                default: {

                }

            }
            xCounter++;

        }
        return true;

    }

    public void printShotGrid() {
        System.out.println("\tA\tB\tC\tD\tE\tF\tG\tH\tI\tJ\t");
        xCounter = 0;
        while (xCounter < ShotGrid.length) {
            System.out.print(xCounter + 1 + "\t");
            yCounter = 0;
            while (yCounter < ShotGrid[xCounter].length) {
                System.out.print(ShotGrid[xCounter][yCounter] + "\t");

                yCounter++;
            }
            System.out.println();
            xCounter++;

        }

    }

    public void printShipGrid() {
        System.out.println("\tA\tB\tC\tD\tE\tF\tG\tH\tI\tJ\t");
        xCounter = 0;
        while (xCounter < ShipGrid.length) {
            System.out.print(xCounter + 1 + "\t");
            yCounter = 0;
            while (yCounter < ShipGrid[xCounter].length) {
                System.out.print(ShipGrid[xCounter][yCounter] + "\t");

                yCounter++;
            }
            System.out.println();
            xCounter++;

        }

    }

    public int putShot(int ShipXCord, int ShipYCord, PlayingBoard OtherPlayer) {

        if (ShotGrid[ShipYCord - 1][ShipXCord].equals("O")) {

            if (OtherPlayer.ShipGrid[ShipYCord - 1][ShipXCord].equals("empty")) {

                ShotGrid[ShipYCord - 1][ShipXCord] = "Miss";
                return 0;
            } else {

                ShotGrid[ShipYCord - 1][ShipXCord] = "Hit";
                return 1;

            }
        } else {

            return -1;

        }

    }

    public void setHit(int ShipXCord, int ShipYCord) {

        ShipGrid[ShipYCord - 1][ShipXCord] = "Damage";

    }

    public boolean isShipSunk() {
        Ship1Counter = 0;
        Ship2Counter = 0;
        Ship3Counter = 0;
        Ship4Counter = 0;
        Ship5Counter = 0;
        
        xCounter = 0;
        while (xCounter < 10) {

            yCounter = 0;
            while (yCounter < 10) {

               
                if ((ShipGrid[yCounter][xCounter].equals("Ship 1"))==true){
                    
                    Ship1Counter++;
                
                
                
                }
                
                if ((ShipGrid[yCounter][xCounter].equals("Ship 2"))==true){
                    
                    Ship2Counter++;
                
                
                
                }
                
                if ((ShipGrid[yCounter][xCounter].equals("Ship 3"))==true){
                    
                    Ship3Counter++;
                
                
                
                }
                
                if ((ShipGrid[yCounter][xCounter].equals("Ship 4")==true)){
                    
                    Ship4Counter++;
                
                
                
                }
                
                if ((ShipGrid[yCounter][xCounter].equals("Ship 5")==true)){
                    
                    Ship5Counter++;
                
                
                
                }
                       
                  yCounter++;   
            }
            xCounter++;
        }
        
         return Ship1Counter ==0||Ship2Counter ==0|| Ship3Counter ==0|| Ship4Counter ==0|| Ship5Counter ==0;
    }

}
