package com;

public class SubtractOperator {

    public int operate(int a, int b) {
        if (a < 0 || b < 0) {
            throw new CalculatorException("입력값은 0보다 큰 양의 정수여야 합니다.");
        }

        return a - b;
    }
}