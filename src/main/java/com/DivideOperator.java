package com;

public class DivideOperator {

    public int operate(int a, int b) {
        if (a < 0 || b < 0) {
            throw new CalculatorException("입력값은 0보다 큰 양의 정수여야 합니다.");
        }

        if (b == 0) {
            throw new CalculatorException("나눗셈에서 분모는 0일 수 없습니다.");
        }

        return a / b;
    }
}