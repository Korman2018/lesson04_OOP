package com.epam.javaExternalLab.korostelevk.lesson04.task04.Demo;

public enum Operations {
    ADDITION("+"), SUBTRACTION("-"), MULTIPLICATION("*"), DIVISION("/");

    String operation;

    Operations(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
