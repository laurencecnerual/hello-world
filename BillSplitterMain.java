//This program takes in the bill total and number of people splitting it (from the user), and then computes and displays the cost per person, plus the remainder (if any)
//This program is specifically made for handling transactions in Japanese yen (which means no decimals)

package com.company;
import java.util.Scanner;

public class BillSplitterMain {

    public static void main(String[] args) {
        Scanner getInput = new Scanner(System.in);
        int[] userEntries = new int[2]; // index 0 stores the bill total and index 1 stores the number of people
        Calculator myCalc = new Calculator();
        int minYen = 2;
        int minPeople = 2;
        int onePersonPays;
        int billRemainder;

        System.out.println("割り勘計算機のご利用ありがとうございます。");
        System.out.println();

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                System.out.println("本日のお会計はいくらですか。");
            }
            else {
                System.out.println("何名様でお分けになりますか。");
            }

            while (!getInput.hasNextDouble()) {
                getInput.next();
                System.out.println("頂いたご入力は数じゃありませんでした。もう一度ご入力ください。");
            }

            userEntries[i] = (int) getInput.nextDouble();

            if ((i == 0) && (userEntries[i]) < minYen) {
                userEntries[i] = minYen;
                System.out.println("入力されたお会計は安すぎますので、" + minYen + "円に調整させていただきました。");
            }
            else if ((i == 1) && (userEntries[i]) < minPeople) {
                userEntries[i] = minPeople;
                System.out.println("入力されたご人数は少なすぎますので、" + minPeople + "名様に調整させていただきました。");
            }
            else {
                System.out.println("かしこまりました。");
            }

            System.out.println();
        }

        myCalc.setArgs(userEntries, '/');
        onePersonPays = (int) myCalc.getResult();

        System.out.println("ただ今、計算しております。。。");
        System.out.println(userEntries[0] + "円 / " + userEntries[1] + "人 = " + onePersonPays + "円/人");
        System.out.println();
        System.out.println("なので、お会計は１名様に" + onePersonPays +  "円となります。");

        myCalc.setArgs('%');
        billRemainder = (int) myCalc.getResult();

        if (billRemainder > 0) {
            System.out.println("しかし、残金" + billRemainder + "円がありますので、ご注意ください。");
        }

        System.out.println();
        System.out.println("ご利用ありがとうございました。");
    }
}