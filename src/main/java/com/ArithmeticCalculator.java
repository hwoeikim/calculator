package com;

public class ArithmeticCalculator extends Calculator {

    private final AddOperator addOperator;
    private final SubtractOperator subtractOperator;
    private final MultiplyOperator multiplyOperator;
    private final DivideOperator divideOperator;

    public ArithmeticCalculator () {
        super();
        this.addOperator = new AddOperator();
        this.subtractOperator = new SubtractOperator();
        this.multiplyOperator = new MultiplyOperator();
        this.divideOperator = new DivideOperator();
    }


    public int calculate(int a, int b, char operator) {

        int result = 0;

        switch (operator) {
            case '+':
                result = addOperator.operate(a, b);
                break;

            case '-':
                result = subtractOperator.operate(a, b);
                break;

            case '*':
                result = multiplyOperator.operate(a, b);
                break;

            case '/':
                result = divideOperator.operate(a, b);
                break;

            default:
                throw new CalculatorException("올바른 사칙연산 기호(+, -, *, /)를 입력해주세요");
        }

        results.add(new Result(result));
        return result;
    }
}