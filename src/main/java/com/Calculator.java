package com;

import java.util.ArrayList;
import java.util.List;

// 정수, 소수 가능
record Result(double result) {}

public abstract class Calculator {

    protected List<Result> results;

    public Calculator () {
        this.results = new ArrayList<>();
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
