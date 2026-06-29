package com;

public class CircleCalculator extends Calculator {

    public CircleCalculator () {
        super();
    }

    public double calculateCircleArea (int radius) {
        if (radius <= 0) {
            throw new CalculatorException("반지름은 0보다 큰 양의 정수여야 합니다.");
        }
        double circleArea = radius * radius * 3.14;
        results.add(new Result(circleArea));
        return circleArea;
    }

    @Override
    public void inquiryResults () {
        if (results.isEmpty()) {
            System.out.println("조회할 기록이 없습니다.");
            return;
        }
        for (Result r : results) {
            System.out.println("원의 넓이 결과값 목록: " + r.result());
        }

    }
}
