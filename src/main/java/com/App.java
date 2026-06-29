package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

record Result(int result) {}

public class App {
    public static void main(String[] args) {

        List<Result> results = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while (true) {// 양의 정수 2개 전달 받기

            System.out.println("첫 번째 숫자를 입력하세요: ");
            int a = readInt(sc);

            System.out.println("두 번째 숫자를 입력하세요: ");
            int b = readInt(sc);

            // 사칙연산 기호 전달 받기

            System.out.println("사칙연산 기호(+, -, *, /)를 입력하세요: ");
            char operator = readOperator(sc);

            // 연산 진행 및 결과값 출력

            int result = 0;

            switch (operator) {
                case '+':
                    result = a + b;
                    break;
                case '-':
                    result = a - b;
                    break;
                case '*':
                    result = a * b;
                    break;
                case '/':
                    if (b == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        continue;
                    }
                    result = a / b;
                    break;
            }

            System.out.println("결과: " + result);

            // 결과를 저장(무한)
            results.add(new Result(result));

            // 가장 먼저 저장된 결과 삭제
            // (여기선 값이 없을 일은 없지만 연습용 에러방지)
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");

            String answerRemove = sc.next();
            if (answerRemove.equals("remove")) {
                if(!results.isEmpty()) {
                    results.remove(0);
                    System.out.println("성공적으로 삭제되었습니다.");
                } else {
                    System.out.println("삭제할 기록이 없습니다.");
                }
            }

            // 저장된 연산 결과 모두 출력

            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회");

            String answerInquiry = sc.next();
            if (answerInquiry.equals("inquiry")) {
                for (Result r : results) {
                    System.out.println(r.result());
                }
            }

            // 종료 여부
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");

            String answerExit = sc.next();
            if (answerExit.equals("exit")) {
                System.out.println("계산을 종료합니다.");
                break;
            }
        }
    }


    private static char readOperator(Scanner sc) {
        while (true) {
            String input = sc.next();
            char o = input.charAt(0);

            if (o=='+' || o=='-' || o=='*' || o=='/') {
                return o;
            }

            System.out.println("올바른 사칙연산 기호(+, -, *, /)를 입력해주세요: ");
        }
    }

    private static int readInt(Scanner sc) {
        while (true) {
            if(!sc.hasNextInt()) {
                System.out.println("숫자(0 이상의 양의 정수)를 입력해주세요: ");
                sc.next();
                continue;
            }

            int input = sc.nextInt();
            if (input < 0) {
                System.out.print("0 이상의 양의 정수를 입력해주세요: ");
                continue;
            }
            return input;
        }
    }
}

