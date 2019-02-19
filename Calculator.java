//This class serves as a calculator to make computations between two numbers and return said result.
//To do so, it requires the two numbers to be used and the mathematical operation to be performed as input.

package com.company;

public class Calculator {
    private double input1;
    private double input2;
    private char operation;
    private double output;

    public Calculator(){
        input1 = 1;
        input2 = 1;
        operation = '+';
    }

    public void setArgs(double userIn1, double userIn2, char userOp){
        input1 = userIn1;
        input2 = userIn2;
        operation = userOp;
    }

    private void doMath() {
        switch (operation) {
            case '+':
                output = input1 + input2;
                break;
            case '-':
                output = input1 - input2;
                break;
            case '*':
                output = input1 * input2;
                break;
            case '/':
                output = input1 / input2;
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
