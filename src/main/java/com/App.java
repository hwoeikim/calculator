package com;

import java.util.Scanner;

record Result(int result) {}

public class App {
    public static void main(String[] args) {

        Result[] results = new Result[10];
        int count = 0;

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

            // 결과를 저장
            // 결과가 10개를 초과하는 경우 가장 먼저 저장된 값 삭제 후 새로운 결과 저장

            Result newResult = new Result(result);

            if (count < 10) {
                results[count] = newResult;
                count++;
            } else {
                for (int i = 1; i < 10; i++) {
                    results[i - 1] = results[i];
                }
                results[9] = newResult;
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");

            String answer = sc.next();
            if (answer.equals("exit")) {
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

//        처음부터 int result = switch(operator)로
//        int result = switch (oprator) {
//            case '+' -> a + b;
//            case '-' -> a - b;
//            case '*' -> a * b;
//            case '/' -> {
//                if (b == 0) {
//                    System.out.println("메세지");
//                    yield 0;
//                }
//                yield a/b;
//            }
//            default -> 0;
//        };

