package study;

import java.util.Arrays;
import java.util.List;

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
        if (!isValid(values)) throw new IllegalArgumentException();

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

    private Boolean isValid(String[] values) {
        try {
            Boolean x = isValidInput(values);
            if (x != null) return x;
        } catch (Exception numberFormatException) {
            System.out.println("numberFormatException = " + numberFormatException);
            return false;
        }
        return true;
    }

    private Boolean isValidInput(String[] values) {
        List<String> operators = Arrays.asList(operator);

        // ( 숫자, 연산자, 숫자 ) 패턴이므로 values length가 2가 될 수 없다.
        if (values.length % 2 == 0) {
            System.out.println("올바른 입력이 아닙니다.");
            return false;
        }
        for (int i = 0; i < values.length; i++) {
            // 짝수 인덱스
            if (i % 2 == 0) {
                Integer.parseInt(values[i]);
                continue;
            }
            // 홀수 인덱스
            if (!operators.contains(values[i])) {
                System.out.println(values[i] +"는 연산자가 아닙니다.");
                return false;
            }
        }
        return null;
    }
}
