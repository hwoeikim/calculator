package com;

public class ArithmeticCalculator extends Calculator {

    // 포함 관계 합성 -> 연산 수행할 개별 연산자 객체를 멤버 변수로 가짐
    private final AddOperator addOperator;
    private final SubtractOperator subtractOperator;
    private final MultiplyOperator multiplyOperator;
    private final DivideOperator divideOperator;
    private final ModOperator modOperator;

    // 생성될 때, 내부 객체들도 함께 생성 및 결합
    // 부모클래스 생성자 호출 -> 저장 리스트 초기화
    public ArithmeticCalculator () {
        super();
        this.addOperator = new AddOperator();
        this.subtractOperator = new SubtractOperator();
        this.multiplyOperator = new MultiplyOperator();
        this.divideOperator = new DivideOperator();
        this.modOperator = new ModOperator();
    }

    public double calculate (double a, double b, char operator) {

        double result = 0;

        // 입력받은 값 enum 상수 변환
        OperatorType operatorType = OperatorType.from(operator);

        // enum 상수 기준 작동
        switch (operatorType) {
            case ADD:
                result = addOperator.operate(a, b);
                break;

            case SUBTRACT:
                result = subtractOperator.operate(a, b);
                break;

            case MULTIPLY:
                result = multiplyOperator.operate(a, b);
                break;

            case DIVIDE:
                result = divideOperator.operate(a, b);
                break;

            case MOD:
                result = modOperator.operate(a, b);
                break;
        }

        results.add(new Result(result));
        return result;
    }
}