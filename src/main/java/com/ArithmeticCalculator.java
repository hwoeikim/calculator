package com;

public class ArithmeticCalculator extends Calculator {

    public ArithmeticCalculator () {
        super();
    }

    public int calculate(int a, int b, char operator) {

        if (a < 0 || b < 0) {
            throw new CalculatorException("0 이상의 양의 정수를 입력해야 합니다.");
        }
        if (operator == '/' && b == 0) {
            throw new CalculatorException("나눗셈에서 두번째 숫자(분모)는 0일 수 없습니다.");
        }


        int calculatorResult = 0;

        switch (operator) {
            case '+':
                calculatorResult = a + b;
                break;
            case '-':
                calculatorResult = a - b;
                break;
            case '*':
                calculatorResult = a * b;
                break;
            case '/':
                calculatorResult = a / b;
                break;
        }

        results.add(new Result(calculatorResult));
        return calculatorResult;
    }


}
