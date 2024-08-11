package com.mortcalc;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
        mathematical formula to calculate mortgage

        M = [P × {r(1 + r)^n}/{(1 + r)^n - 1}]

        M = Mortgage
        P = Principal Amount
        r = Monthly Interest Rate
        n = Number of Monthly Payments [Periods (Months)]
        */

        // declaration of constant values
        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;

        Scanner userInput = new Scanner(System.in); // declaring scanner object to accept user input

        // asking for user input and giving back appropriate values
        System.out.print("Principal Amount: ");
        int principal = userInput.nextInt();

        System.out.print("Annual Interest Rate: ");
        float monthlyInterestRate = ((userInput.nextFloat() / PERCENT) / MONTHS_IN_YEAR);
        System.out.println("Monthly Interest Rate: " + monthlyInterestRate);

        System.out.print("Period (Years): ");
        short period= (short) (userInput.nextShort() * MONTHS_IN_YEAR); // stores 'period' in months
        System.out.println("Period (Months): " + period);

        userInput.close(); // closing the scanner object

        // formula for calculating mortgage implemented in java
        double mortgage = (principal * (monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, period)))
                / ((Math.pow(1 + monthlyInterestRate, period)) - 1));

        // prints the properly formatted mortgage value in local currency
        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));


    }
}