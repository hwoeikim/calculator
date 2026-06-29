package com;

import java.util.ArrayList;
import java.util.List;

// 구성을 꺼내는 메서드 자동 생성
record Result(int result) {}

public class Calculator {
    private List<Result> results = new ArrayList<>();

    public Calculator () {

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

    public void removeResult() {
        if(!results.isEmpty()) {
            results.remove(0);
            System.out.println("성공적으로 삭제되었습니다.");
        } else {
            System.out.println("삭제할 기록이 없습니다.");
        }
    }


    public List<Result> getResults() {
        return this.results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public void inquiryResults() {
        if (results.isEmpty()) {
            System.out.println("조회할 기록이 없습니다.");
            return;
        }
        for (Result r : results) {
            System.out.println("연산결과 목록: " + r.result());
        }

    }



}
