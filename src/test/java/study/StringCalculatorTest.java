package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
        System.setOut(new PrintStream(output));
    }

    // 올바른 인풋
    @Test
    void 올바른인풋() {
        String actual = "2 + 3 * 4 / 2";
        String[] values = actual.split(" ");
        assertThat(stringCalculator.calculateString(values)).isEqualTo(10.0);
    }

    // 올바르지 않은 인풋 - 숫자 연달아 입력
    @Test
    void 올바르지않은인풋_숫자연속입력() {
        String actual = "1 1 2";
        String[] values = actual.split(" ");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.calculateString(values);
        });
        assertThat(output.toString().trim()).contains("는 연산자가 아닙니다.");
    }

    // 올바르지 않은 인풋 - 짝수개 인풋
    @Test
    void 올바르지않은인풋_짝수개인풋() {
        String actual = "1 + - 1";
        String[] values = actual.split(" ");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.calculateString(values);
        });
        assertThat(output.toString().trim()).contains("올바른 입력이 아닙니다.");
    }


    // 올바르지 않은 인풋 - 연산자로 시작
    @Test
    void 올바르지않은인풋_연산자로시작() {
        String actual = "+ 2 2";
        String[] values = actual.split(" ");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.calculateString(values);
        });
        assertThat(output.toString().trim()).contains("numberFormatException");
    }

    // 올바르지 않은 인풋 - 연산자로끝, 연산자 연속 입력
    @Test
    void 올바르지않은인풋_연산자로끝_연산자연속입력() {
        String actual = "1 + /";
        String[] values = actual.split(" ");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.calculateString(values);
        });
        assertThat(output.toString().trim()).contains("numberFormatException");
    }

    @AfterEach
    void resetOutputStream() {
        System.setOut(System.out);
        output.reset();
    }
}
