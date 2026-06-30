package com;

public enum OperatorType {
    // 사용할 상수 정의 및 연산자 매핑
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/'),
    MOD('%');

    // 저장할 필드
    private final char operator;

    // 생성자 (연산자를 enum과 연결)
    OperatorType(char operator) {
        this.operator = operator;
    }

    public char getOperator() {
        return this.operator;
    }

    public static OperatorType from(char operator) {
        for (OperatorType type : OperatorType.values()) {
            if (type.getOperator() == operator) {
                return type;
            }
        }
        throw new CalculatorException("올바른 연산 기호(+, -, *, /, %)가 아닙니다.");
    }
}