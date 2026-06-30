package com;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {

        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        CircleCalculator circleCalculator = new CircleCalculator();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("원하시는 기능을 선택하세요(1: = 사칙연산 &  / 2: = 원의 넓이 구하기 / 3: 종료): ");
            int function = readInt(sc);

            switch (function) {
                case 1:
                    System.out.println("--- 사칙연산 계산기 ---");

                    while (true) {

                        System.out.println("첫 번째 숫자를 입력하세요: ");
                        double a = readDouble(sc);

                        System.out.println("두 번째 숫자를 입력하세요: ");
                        double b = readDouble(sc);

                        System.out.println("연산 기호(+, -, *, /, %)를 입력하세요: ");
                        char operator = readOperator(sc);

                        // 입력받은 값 연산 수행

                        try {
                            double result = arithmeticCalculator.calculate(a, b, operator);
                            System.out.println("결과: " + result);
                        } catch (CalculatorException e) {
                            System.out.println("Error: " + e.getMessage());
                            continue;
                        }


                        // 가장 먼저 저장된 결과 삭제
                        System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");

                        String answerRemove = sc.next();
                        if (answerRemove.equals("remove")) {
                            arithmeticCalculator.removeResult();
                        }

                        // 저장된 연산 결과 모두 출력
                        System.out.println("저장된 연산 결과를 조회하시겠습니까? (inquiry 입력 시 조회)");

                        String answerInquiry = sc.next();
                        if (answerInquiry.equals("inquiry")) {
                            arithmeticCalculator.inquiryResults();
                        }

                        // 종료 여부
                        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");

                        String answerExit = sc.next();
                        if (answerExit.equals("exit")) {
                            System.out.println("계산을 종료합니다.");
                            break;
                        }
                    }
                    break;


                case 2:
                    System.out.println("--- 원의 넓이 계산 모드 ---");

                    while (true) {

                        // 원의 넓이 구하기
                        System.out.println("원의 반지름을 입력해주세요: ");
                        int radius = readInt(sc);

                        try {
                            System.out.println("원의 넓이: " + circleCalculator.calculateCircleArea(radius));
                        } catch (CalculatorException e) {
                            System.out.println("Error: " + e.getMessage());
                            continue;
                        }

                        // 저장된 원의 넓이 값들 바로 전체 조회

                       circleCalculator.inquiryResults();

                        // 종료 여부
                        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");

                        String answerExit = sc.next();
                        if (answerExit.equals("exit")) {
                            System.out.println("계산을 종료합니다.");
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;

                default:
                    System.out.println("올바른 번호(1, 2, 3)를 입력해 주세요.");
                    break;

            }

        }


    }


    private static char readOperator(Scanner sc) {
        while (true) {
            String input = sc.next();
            char o = input.charAt(0);

            if (o=='+' || o=='-' || o=='*' || o=='/' || o=='%') {
                return o;
            }

            System.out.println("올바른 사칙연산 기호(+, -, *, /, %)를 입력해주세요: ");
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
                System.out.println("0 이상의 양의 정수를 입력해주세요: ");
                continue;
            }
            return input;
        }
    }

    private static double readDouble(Scanner sc) {
        while (true) {
            if(!sc.hasNextDouble()) {
                System.out.println("0 이상의 숫자를 입력해주세요: ");
                sc.next();
                continue;
            }

            double input = sc.next();
            if (input < 0) {
                System.out.println("0 이상의 숫자를 입력해주세요: ");
                continue;
            }
            return input;
        }

    }
}