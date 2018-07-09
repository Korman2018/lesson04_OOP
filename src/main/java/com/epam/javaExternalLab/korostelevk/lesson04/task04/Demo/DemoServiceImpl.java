package com.epam.javaExternalLab.korostelevk.lesson04.task04.Demo;


import com.epam.javaExternalLab.korostelevk.lesson04.task04.Fraction.Fraction;

import static com.epam.javaExternalLab.korostelevk.lesson04.task04.Demo.Operations.*;
import static com.epam.javaExternalLab.korostelevk.lesson04.task04.Fraction.FractionUtils.FractionCalculationUtils.*;

public class DemoServiceImpl implements DemoService {

    @Override
    public void fractionAllTests() {
        System.out.println("Fraction test\n");

        Fraction fractionOne = new Fraction(5, -35);
        Fraction fractionTwo = new Fraction(-6, -20);

        System.out.println(builSimplifyPresentation(fractionOne));
        System.out.println(builSimplifyPresentation(fractionTwo));
        System.out.println(buildMathFunctionPresentation(fractionOne, fractionTwo, ADDITION));
        System.out.println(buildMathFunctionPresentation(fractionOne, fractionTwo, SUBTRACTION));
        System.out.println(buildMathFunctionPresentation(fractionOne, fractionTwo, MULTIPLICATION));
        System.out.println(buildMathFunctionPresentation(fractionOne, fractionTwo, DIVISION));
    }

    private static String buildMathFunctionPresentation(Fraction one, Fraction two, Operations operation) {
        StringBuilder sb = new StringBuilder("(");
        Fraction result = null;

        switch (operation) {
            case ADDITION:
                result = sum(one, two);
                break;
            case SUBTRACTION:
                result = sub(one, two);
                break;
            case MULTIPLICATION:
                result = mult(one, two);
                break;
            case DIVISION:
                result = div(one, two);
                break;
            default:
        }

        sb.append(one).append(")").append(operation.getOperation()).append("(")
                .append(two).append(") = ").append(result);

        return sb.toString();
    }

    private static String builSimplifyPresentation(Fraction fraction) {
        StringBuilder sb = new StringBuilder();
        sb.append(fraction).append(" = ").append(simplify(fraction));
        return sb.toString();
    }
}
