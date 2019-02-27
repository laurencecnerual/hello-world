//This class serves as a calculator to make computations across an array of numbers and return its result
//To do so, as input, it requires both an array of numbers to be used and the mathematical operation to be performed.

package com.company;

import java.util.Arrays;

public class Calculator {
    private double[] input; // numbers to be operated on
    private int maxIn; // the in-house max array size
    private int numOfIn; // the actual number of elements, capped by maxIn
    private char operation; // the math operation to be performed
    private double output; // the result of the operation
    private String equation; //the full equation depicting the input values, operation, and their result

    public Calculator() { // constructor for making a new Calculator
        maxIn = 100;
        numOfIn = maxIn;
        input = new double[numOfIn];

        for (int i = 0; i < numOfIn; i++) {
            input[i] = 1;
        }

        operation = '+';
        equation = "";
    }

    public void setArgs(int[] userIn, char userOp) {
        double[] intToDouble = Arrays.stream(userIn).asDoubleStream().toArray();
        setArgs(intToDouble, userOp);
    }

    public void setArgs(double[] userIn, char userOp) { // used to input the user's entries and desired operation type, and then actually compute the answer and prepare a String representing what was done.

        if (userIn.length < maxIn) {
            numOfIn = userIn.length;
        }

        System.arraycopy(userIn, 0, input, 0, numOfIn);
        setArgs(userOp);
    }

    public void setArgs(char userOp) {
        operation = userOp;
        doMath();
        makeEquation();
    }

    private void doMath() { // used to calculate the result of the selected math operation based on the user's input
        output = input[0];

        switch (operation) {
            case '+':
                for (int i = 1; i < numOfIn; i++) {
                    output += input[i];
                }
                break;
            case '-':
                for (int i = 1; i < numOfIn; i++) {
                    output -= input[i];
                }
                break;
            case '*':
                for (int i = 1; i < numOfIn; i++) {
                    output *= input[i];
                }
                break;
            case '/':
                for (int i = 1; i < numOfIn; i++) {
                    output /= input[i];
                }
                break;
            case '%':
                for (int i = 1; i < numOfIn; i++) {
                    output %= input[i];
                }
                break;
            default:
                output = -666;
        }
    }

    public double getResult() { // returns the result of the selected math operation and input values
        return output;
    }

    private void makeEquation() { // prepares a String representation of the full equation computed (featuring input values, the operation performed, and their result)
        for (int i = 0; i < numOfIn - 1; i++) {
            equation += input[i] + " " + operation + " ";
        }

        equation += input[numOfIn - 1] + " = " + output + ".";
    }

    public String getEquation() { // returns the full calculation performed (in equation form)
        return equation;
    }
}
