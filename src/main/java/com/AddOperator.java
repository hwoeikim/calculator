package com;

public class AddOperator {

    public double operate(double a, double b) {
       if (a < 0 || b < 0) {
            throw new CalculatorException("입력값은 0보다 커야 합니다.");
        }

       return a + b;
    }

}