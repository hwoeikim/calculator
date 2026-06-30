package com;

public class ModOperator {

    public double operate (double a, double b) {
        if (a < 0 || b < 0) {
            throw new CalculatorException("입력값은 0보다 커야 합니다.");
        }

        if (b == 0) {
            throw new CalculatorException("나머지를 구할 때 두번째 숫자(분모)는 0일 수 없습니다.");
        }

        return a % b;
    }
}