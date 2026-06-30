package com;

import java.util.ArrayList;
import java.util.List;

// 데이터를 저장하는 목적의 객체
// 구성을 꺼내는 getter 메서드(result())
record Result(double result) {}

public abstract class Calculator {

    // 필드 -> 결과 저장 리스트 (하위 클래스 접근 가능)
    protected List<Result> results;

    // 생성자 -> Calculator 객체가 생성될 때 결과를 저장할 ArrayList 생성
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
