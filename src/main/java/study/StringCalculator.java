package study;

import java.util.Arrays;

// 정상 입력

// 1. 숫자 - 연산자 - 숫자의 형태
//  1 2 3 + /
//  짝수 인덱스 -> 숫자, 홀수 인덱스 -> 연산자

// 2. 숫자 하나만 입력 -> 그대로 리턴


// 비정상 입력 -> 예외 처리
// 연달아 숫자 입력
// 연달아 연산자 입력
// 연산자로 시작 또는 끝나는 경우

public class StringCalculator {

    final String[] operator = {"+", "-", "*", "/"};

    public Double calculateString(String[] values){
        // 유효 인풋 체크
        if (!isValidate(values)) throw new IllegalArgumentException();

        // 계산
        Double result = Double.valueOf(values[0]);

        for (int i = 1; i < values.length; i++) {
            if (values[i].equals("+")) {
                result += Double.valueOf(values[i + 1]);
            } else if (values[i].equals("-")) {
                result -= Double.valueOf(values[i + 1]);
            } else if (values[i].equals("*")) {
                result *= Double.valueOf(values[i + 1]);
            } else if (values[i].equals("/")) {
                result /= Double.valueOf(values[i + 1]);
            }
            i++;
        }

        return result;
    }

    private Boolean isValidate(String[] values) {
        try {
            if (values.length % 2 == 0) {
                System.out.println("올바른 입력이 아닙니다.");
                return false;
            }
            for (int i = 0; i < values.length; i++) {
                if (i % 2 == 0) {
                    Integer.parseInt(values[i]);
                } else if (i % 2 == 1) {
                    if (!Arrays.asList(operator).contains(values[i])) {
                        System.out.println(values[i] +"는 연산자가 아닙니다.");
                        return false;
                    }
                }
            }
        } catch (Exception numberFormatException) {
            System.out.println("numberFormatException = " + numberFormatException);
            return false;
        }
        return true;
    }
}
