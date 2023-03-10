package com.h2;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;

public class SavingsCalculator {
    private float[] debits;
    private float[] credits;

    public SavingsCalculator(float[] creits, float[] debits) {
        this.debits = debits;
        this.credits = credits;
    }
    private float sumOfCredits() {
        float sum = 0.0f;
        for (int i = 0; i < credits.length; i++) {
            sum = sum + credits[i];
        }
        return sum;
    }
    private float sumOfDebits() {
        float sum = 0.0f;
        for (int i = 0; i < debits.length; i++) {
            sum = sum + debits[i];
        }
        return sum;
    }
    private static int remainingDaysInMonth(LocalDate date) {
        int year = date.getYear();
        Month month;
        month = date.getMonth();
        YearMonth yearMonth = YearMonth.of(year,month);
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        int remainingDays;
        remainingDays = totalDaysInMonth - date.getDayOfMonth();
        return remainingDays;
    }
    public float calculate() {
        return sumOfCredits() - sumOfDebits();
    }
    public static void main(String[] args) {
        String[] creditsAsString = args[0].split(",");
        String[] debitsAsString = args[0].split(",");

        float[] credits = new float[creditsAsString.length];
        for(int i=0; i<creditsAsString.length; i++) {
            credits[i] = Float.parseFloat(creditsAsString[i]);
        }
        float[] debits = new float[debitsAsString.length];
        for (int i = 0; i < debitsAsString.length; i++) {
             debits[i] = Float.parseFloat(debitsAsString[i]);

        }

        SavingsCalculator calculator  = new SavingsCalculator(credits,debits);
        float netSavings = calculator.calculate();
        System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
    }

}
