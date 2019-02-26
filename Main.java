//This program allows users to input between two and twenty numbers, and perform the mathematical operation of their choosing between them
//(ie. addition, subtraction, multiplication, or division)

package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner getInput = new Scanner(System.in);
        int numOfEntries; // number of numbers to be entered by the user
        int maxEntries = 20; //in-house cap on number of user entries allowed
        double[] userEntries; // to store user input
        char mathOp; // the user's desired mathematical operation type
        Calculator myCalc = new Calculator();

        System.out.print("Hello! ");

        main_flow: while (true) {
            System.out.println("What type of calculation would you like to make?");
            System.out.println("Enter + for Addition, - for Subtraction, * for Multiplication, or / for Division.");

            while (true) {
                mathOp = (getInput.next()).charAt(0);
                if ((mathOp != '+') && (mathOp != '-') && (mathOp != '*') && (mathOp != '/')) {
                    System.out.println("Uh oh. It seems you did not make a valid selection. Please try again.");
                }
                else {
                    System.out.println("Thank you.");
                    System.out.println();
                    break;
                }
            }

            System.out.println("How many different entries will you be inputting?");
            System.out.println("There should be at least 2, and no more than " + maxEntries + ".");

            numOfEntries = (int) getUserNumIn(getInput);

            if (numOfEntries < 2) {
                numOfEntries = 2;
                System.out.println("The number you entered was too small, so it has been adjusted to 2.");
            }
            else if (numOfEntries > maxEntries) {
                numOfEntries = maxEntries;
                System.out.println("The number you entered was too big, so it has been adjusted to " + maxEntries + ".");
            }
            else {
                System.out.println("Thank you.");
            }

            System.out.println();
            userEntries = new double[numOfEntries];

            System.out.println("Enter the numbers you would like to perform the operation on, each separated by either a new line or a space.");

            for (int i = 0; i < numOfEntries; i++) {
                userEntries[i] = getUserNumIn(getInput);
                System.out.println("Entry #" + (i + 1) + " has been saved. Remaining entries: " + (numOfEntries - (i + 1)));
            }

            System.out.println("Thank you.");
            System.out.println();

            myCalc.setArgs(userEntries, mathOp);

            System.out.println("According to our calculations...");
            System.out.println(myCalc.getEquation());
            System.out.println();

            System.out.println("Would you like to make another calculation?");
            System.out.println("Enter Y for Yes or N for No.");

            while (true) {
                char userSelection = (getInput.next()).charAt(0);

                if ((userSelection != 'Y') && (userSelection != 'N') && (userSelection != 'y') && (userSelection != 'n')) {
                    System.out.println("Uh oh. It seems you did not make a valid selection. Please try again.");
                }
                else if ((userSelection == 'Y') || (userSelection == 'y')) {
                    System.out.println();
                    System.out.print("Ok! ");
                    break;
                }
                else {
                    System.out.println();
                    System.out.print("Understood! ");
                    break main_flow;
                }
            }
        }

        System.out.println("We hope you have enjoyed using our services.");
        System.out.println("Thank you, and have a nice day.");
    }

    static double getUserNumIn(Scanner s) //used to make sure the user inputs a number and returns said number
    {
        while (!s.hasNextDouble()) {
            s.next();
            System.out.println("Uh oh. It seems you did not enter a number. Please try again.");
        }

        return s.nextDouble();
    }
}
