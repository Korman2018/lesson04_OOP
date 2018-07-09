package com.epam.javaExternalLab.korostelevk.lesson04.task04.Fraction.FractionExceptions;

public class FractionException extends RuntimeException {

    public FractionException() {
        super("Found equal zero number");
    }
}
