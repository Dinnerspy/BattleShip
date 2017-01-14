/*
* Nicholas Ouellette 3556762
*cs1073 Assignment 6, question 2 
* created October 29 2016
*
*purpose:  A game of battleship 
*input: Sting input form user
*output: Displays fo where the shots hit and missed
*
 */
package battleship;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class BattleShip {

    public static void main(String[] args) {
        int yCounter, xCounter, ShipXCord = 0, ShipYCord = 0, ShipNumber, comIntHolder, HitResult;
        String userInput, Ship, ShipOrentation = null, ShipLetter;
        boolean xValid = false, yValid, OrentationValid, ShipSunk;
        boolean player1Turn, player2Turn;

        Random mygenerator = new Random();
        Scanner myscanner = new Scanner(System.in);
        System.out.println("Welcome to BattleShip!");
        System.out.println("You will be playing agenste a computer \n");

        PlayingBoard Player1 = new PlayingBoard();
        PlayingBoard Player2 = new PlayingBoard();
        Player1.printShipGrid();
        System.out.println();
        //print grid
        //Gets User Input on Boat Placing
        System.out.println("Ships take up 5 spaces in one direction\nin what orientation up down left right.\nEnter it in the formant letter, number, direction.");
        xCounter = 1;
        while (xCounter < 6) {
            System.out.println("Player one where would you like to place ship " + xCounter + "?");
            Ship = myscanner.nextLine();
            ShipYCord = Integer.parseInt(Ship.substring(1, 3).replace(" ", ""));
            ShipLetter = Ship.substring(0, 1);
            if (ShipYCord == 10) {
                ShipOrentation = Ship.substring(4, Ship.length());
                ShipOrentation = ShipOrentation.toUpperCase();
            } else {
                ShipOrentation = Ship.substring(3, Ship.length());
                ShipOrentation = ShipOrentation.toUpperCase();
            }
            ShipLetter = ShipLetter.toUpperCase();
            switch (ShipLetter) {
                case "A": {
                    ShipXCord = 0;
                    xValid = true;
                    break;
                }
                case "B": {
                    ShipXCord = 1;
                    xValid = true;
                    break;
                }
                case "C": {
                    ShipXCord = 2;
                    xValid = true;
                    break;
                }
                case "D": {
                    ShipXCord = 3;
                    xValid = true;
                    break;
                }
                case "E": {
                    ShipXCord = 4;
                    xValid = true;
                    break;
                }
                case "F": {
                    ShipXCord = 5;
                    xValid = true;
                    break;
                }
                case "G": {
                    ShipXCord = 6;
                    xValid = true;
                    break;
                }
                case "H": {
                    ShipXCord = 7;
                    xValid = true;
                    break;
                }
                case "I": {
                    ShipXCord = 8;
                    xValid = true;
                    break;
                }
                case "J": {
                    ShipXCord = 9;
                    xValid = true;
                    break;
                }
                default: {
                }

            }
            yValid = (ShipYCord > 0) && (ShipYCord < 11);

            OrentationValid = ShipOrentation.equalsIgnoreCase("up")
                    || ShipOrentation.equalsIgnoreCase("down")
                    || ShipOrentation.equalsIgnoreCase("right")
                    || ShipOrentation.equalsIgnoreCase("left");

            if (xValid == yValid == OrentationValid) {
                ShipNumber = xCounter;
                if (Player1.putShip(ShipXCord, ShipYCord, ShipOrentation, ShipNumber)) {

                    xCounter++;

                } else {

                    System.out.println("invalid location for placing ship");
                }
            } else {//come back hereasdfghjk
                System.out.println("invalid location for placing ship");

            }
        }
        Player1.printShipGrid();

        //Makes the cpus boat location.
        xCounter = 1;
        while (xCounter < 6) {
            ShipNumber = xCounter;
            ShipXCord = mygenerator.nextInt(10);
            ShipYCord = mygenerator.nextInt(10) + 1;
            comIntHolder = mygenerator.nextInt(3);

            switch (comIntHolder) {

                case 0: {
                    ShipOrentation = "RIGHT";
                    break;

                }
                case 1: {
                    ShipOrentation = "LEFT";
                    break;

                }
                case 2: {
                    ShipOrentation = "UP";
                    break;

                }
                case 3: {
                    ShipOrentation = "DOWN";
                    break;

                }
                default: {

                }
            }
            if (Player2.putShip(ShipXCord, ShipYCord, ShipOrentation, ShipNumber)) {

                xCounter++;

            } else {

            }

        }
        Player2.printShipGrid();
        //runs the game untill one sip has been sunk
        player1Turn = true;
        player2Turn = false;
        ShipSunk = false;
        while (ShipSunk == false) {
            while (player1Turn == true) {
                //places players shot
                System.out.println("Please Enter the location of your Shot.");
                Ship = myscanner.nextLine();
                ShipYCord = Integer.parseInt(Ship.substring(1, Ship.length()));
                ShipLetter = Ship.substring(0, 1);
                ShipLetter = ShipLetter.toUpperCase();
                switch (ShipLetter) {
                    case "A": {
                        ShipXCord = 0;
                        xValid = true;
                        break;
                    }
                    case "B": {
                        ShipXCord = 1;
                        xValid = true;
                        break;
                    }
                    case "C": {
                        ShipXCord = 2;
                        xValid = true;
                        break;
                    }
                    case "D": {
                        ShipXCord = 3;
                        xValid = true;
                        break;
                    }
                    case "E": {
                        ShipXCord = 4;
                        xValid = true;
                        break;
                    }
                    case "F": {
                        ShipXCord = 5;
                        xValid = true;
                        break;
                    }
                    case "G": {
                        ShipXCord = 6;
                        xValid = true;
                        break;
                    }
                    case "H": {
                        ShipXCord = 7;
                        xValid = true;
                        break;
                    }
                    case "I": {
                        ShipXCord = 8;
                        xValid = true;
                        break;
                    }
                    case "J": {
                        ShipXCord = 9;
                        xValid = true;
                        break;
                    }
                    default: {
                    }

                }
                yValid = (ShipYCord > 0) && (ShipYCord < 11);

                if (xValid == yValid) {
                    HitResult = Player1.putShot(ShipXCord, ShipYCord, Player2);
                    if (HitResult > -1) {
                        player1Turn = false;
                        player2Turn = true;
                        if (HitResult == 1) {

                            Player2.setHit(ShipXCord, ShipYCord);

                        } else {

                            System.out.println("You already used this location please pick a new one.");

                        }
                    } else {//come back hereasdfghjk
                        System.out.println("You already used this location please pick a new one.");

                    }

                }
                Player1.printShipGrid();
                Player1.printShotGrid();
            }
            while (player2Turn == true) {

                ShipXCord = mygenerator.nextInt(10);
                ShipYCord = mygenerator.nextInt(10) + 1;
                HitResult = Player2.putShot(ShipXCord, ShipYCord, Player1);
                if (HitResult > -1) {
                    player1Turn = true;
                    player2Turn = false;
                    if (HitResult == 1) {

                        Player1.setHit(ShipXCord, ShipYCord);

                    }
                }
                if ((Player1.isShipSunk()) == true) {

                    ShipSunk = true;
                    player1Turn = false;
                    player2Turn = false;
                    System.out.println("Computer won it sunk my battleship.");
                }

                if (Player2.isShipSunk() == true) {

                    ShipSunk = true;
                    player1Turn = false;
                    player2Turn = false;
                    System.out.println("You won you sunk thier battleship.");
                }

            }

        }

    }
}
