package com.epam.javaExternalLab.korostelevk.lesson04.task04.Fraction.FractionUtils;

import com.epam.javaExternalLab.korostelevk.lesson04.task04.Fraction.Fraction;

public class FractionCalculationUtils {

    private FractionCalculationUtils() {
    }

    public static Fraction simplify(Fraction fraction) {
        int numerator = fraction.getNumerator();
        int denominator = fraction.getDenominator();
        int commonDivisor = findGreatestCommonDivisor(numerator, denominator);

        fraction.setNumerator(numerator / commonDivisor);
        fraction.setDenominator(denominator / commonDivisor);
        return fraction;
    }

    public static Fraction sum(Fraction one, Fraction two) {
        Fraction simplifyOne = simplify(one);
        Fraction simplifyTwo = simplify(two);

        int numeratorOne = simplifyOne.getNumerator();
        int denominatorOne = simplifyOne.getDenominator();
        int numeratorTwo = simplifyTwo.getNumerator();
        int denominatorTwo = simplifyTwo.getDenominator();

        int resultNumerator;
        int resultDenominator;

        if (denominatorOne % denominatorTwo == 0) {
            resultNumerator = numeratorOne + numeratorTwo * denominatorOne / denominatorTwo;
            resultDenominator = denominatorOne;
        } else {
            if (denominatorTwo % denominatorOne == 0) {
                resultNumerator = numeratorTwo + numeratorOne * denominatorTwo / denominatorOne;
                resultDenominator = denominatorTwo;
            } else {
                resultNumerator = numeratorOne * denominatorTwo + numeratorTwo * denominatorOne;
                resultDenominator = denominatorOne * denominatorTwo;
            }
        }
        return simplify(new Fraction(resultNumerator, resultDenominator));
    }

    public static Fraction sub(Fraction one, Fraction two) {
        return sum(one, new Fraction(-two.getNumerator(), two.getDenominator()));
    }

    public static Fraction mult(Fraction one, Fraction two) {
        Fraction simplifyOne = simplify(one);
        Fraction simplifyTwo = simplify(two);

        int newNumerator = simplifyOne.getNumerator() * simplifyTwo.getNumerator();
        int newDenominator = simplifyOne.getDenominator() * simplifyTwo.getDenominator();

        return simplify(new Fraction(newNumerator, newDenominator));
    }

    public static Fraction div(Fraction one, Fraction two) {
        return simplify(mult(one, new Fraction(two.getDenominator(), two.getNumerator())));
    }

    private static int findGreatestCommonDivisor(int one, int two) {
        while (one != 0) {
            int oldOne = one;
            one = two % one;
            two = oldOne;
        }
        return two;
    }
}
