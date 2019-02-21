//This class serves as a calculator to make computations across an array of numbers and return its result
//To do so, as input, it requires both an array of numbers to be used and the mathematical operation to be performed.

package com.company;

public class Calculator {
    private double[] input; // numbers to be operated on
    private int maxIn; // the in-house max array size
    private int numOfIn; // the actual number of elements, capped by maxIn
    private char operation; // the math operation to be performed
    private double output; // the result of the operation

    public Calculator() {
        maxIn = 100;
        numOfIn = maxIn;
        input = new double[numOfIn];

        for (int i = 0; i < numOfIn; i++) {
            input[i] = 1;
        }

        operation = '+';
    }

    public void setArgs(double[] userIn, char userOp){

        if (userIn.length < maxIn) {
            numOfIn = userIn.length;
        }

        System.arraycopy(userIn, 0, input, 0, numOfIn);
        operation = userOp;
    }

    private void doMath() {
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
            default:
                output = 0;
        }

    }

    public double getResult(){
        doMath();
        return output;
    }
}
