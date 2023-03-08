package com.h2;

import java.awt.*;
import java.util.Map;
import java.util.Scanner;

public class BestLoanRates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        System.out.println("Hello " + name);
        System.out.println("Enter the loan term (in years)");
        int loanTermInYears = scanner.nextInt();
        float bestRate = getRates(loanTermInYears);
        if (Float.compare(bestRate, 0.0f) == 0) {
            System.out.println("No available rates for term : " + loanTermInYears + "years");
        }
        else {
            System.out.println("Best available Rate : " + getRates(loanTermInYears) + "%");
        }
        scanner.close();
    }

    private static final Map<Integer, Float> bestRates
            = Map.of(1, 5.50f,
            2, 3.45f,
            3, 267f);

    public static float getRates(int loanTermInYears) {
        if (bestRates.containsKey(loanTermInYears)) {
            return bestRates.get(loanTermInYears);
        } else
           return 0.0f;

    }


}