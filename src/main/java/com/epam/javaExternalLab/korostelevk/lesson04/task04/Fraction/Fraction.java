package com.epam.javaExternalLab.korostelevk.lesson04.task04.Fraction;

import com.epam.javaExternalLab.korostelevk.lesson04.task04.Fraction.FractionExceptions.FractionException;

public class Fraction {

    private int numerator;

    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = checkZero(numerator);
        this.denominator = checkZero(denominator);
        rebuildSign();
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = checkZero(numerator);
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = checkZero(denominator);
        rebuildSign();
    }

    private static int checkZero(int number) {
        if (number == 0) {
            throw new FractionException();
        }
        return number;
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return String.valueOf(numerator);
        }
        return numerator + "/" + denominator;
    }

    private void rebuildSign() {
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }
}
