//This program allows users to input two numbers, and perform the mathematical operation of their choosing between them
//(ie. addition, subtraction, multiplication, or division)

package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner getInput = new Scanner(System.in);
        double arg1 = 0; // the user's first numerical input
        double arg2 = 0; // the user's second numerical input
        double answer; // the sum, difference, product, or quotient of the two numbers supplied by the user
        char mathOp; // the user's desired mathematical operation type
        Calculator myCalc = new Calculator();

        System.out.println("Hello! What type of calculation would you like to make?");
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

        System.out.println("Enter the two numbers you would like to perform the operation on, separated by either a new line or a space.");

        while (!getInput.hasNextDouble()) {
            getInput.next();
            System.out.println("Uh oh. It seems you did not enter a number. Please try again.");
        }

        arg1 = getInput.nextDouble();

        while (!getInput.hasNextDouble()) {
            getInput.next();
            System.out.println("Uh oh. It seems you did not enter a number. Please try again.");
        }

        arg2 = getInput.nextDouble();
        System.out.println("Thank you.");
        System.out.println();

        myCalc.setArgs(arg1, arg2, mathOp);
        answer = myCalc.getResult();

        System.out.println("According to our calculations...");
        System.out.println(arg1 + " " + mathOp + " " + arg2 + " = " + answer + ".");
        System.out.println();
        System.out.println("We hope you have enjoyed using our services.");
        System.out.println("Thank you, and have a nice day.");
    }
}
