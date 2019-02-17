package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner getInput = new Scanner(System.in);
        double a; // the user's first numerical input
        double b; // the user's second numerical input
        double c = 0; // the sum, difference, product, or quotient of the two numbers supplied by the user
        char mathType = 'F'; // the user's desired mathematical operation type

        do {
            System.out.println("What type of calculation would you like to make?");
            System.out.println("Enter A for Addition, S for Subtraction, M for Multiplication, or D for Division.");
            mathType = (getInput.next()).charAt(0);
            System.out.println();
        } while ((mathType != 'A') && (mathType != 'S') && (mathType != 'M') && (mathType != 'D'));

        System.out.println("Enter any two numbers, separated by either a new line or a space.");
        a = getInput.nextDouble();
        b = getInput.nextDouble();

        switch (mathType) {
            case 'A':
                c = a + b;
                break;
            case 'S':
                c = a - b;
                break;
            case 'M':
                c = a * b;
                break;
            case 'D':
                c = a / b;
                break;
        }

        System.out.println("The result of the operation you selected is " + c + ".");
    }
}
