package baseball;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.InputStreamAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballTest {
    private Baseball baseball;

    @BeforeEach
    void setUp() {
        baseball = new Baseball();
    }

    @Test
    void playTest() {
    }

    @Test
    void createRandomThreeDigitsTest() {
        // when
        int[] randomThreeDigits = baseball.createRandomThreeDigits();

        // then
        assertThat(randomThreeDigits).hasSize(3);
    }

    @Test
    void getRandomNumberTest() {
        // given
        int minDigit = 0;
        int maxDigit = 9;

        // when
        int randomNumber = baseball.getRandomNumber(minDigit, maxDigit);

        // then
        assertThat(randomNumber).isBetween(0, 9);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123 "})
    void guessThreeDigitsTest(String input) {
        // given
        InputStream in = generateUserInput(input);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        // when
        int result = baseball.guessThreeDigits(scanner);

        // then
        assertThat(result).isEqualTo(123);
    }

    @ParameterizedTest
    @ValueSource(strings = {"문자열 "})
    void guessThreeDigitsWrongInputTest(String input) {
        // given
        InputStream in = generateUserInput(input);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        
        // when + then
        assertThatThrownBy(() -> baseball.guessThreeDigits(scanner)).isInstanceOf(InputMismatchException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {123, 456, 789})
    void validateUserInputTest(int userGuessThreeDigits) {
        // when
        Boolean result = baseball.validateUserInput(userGuessThreeDigits);

        // then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1234, 45, 12345})
    void validateUserWrongInputTest(int userGuessThreeDigits) {
        // when
        Boolean result = baseball.validateUserInput(userGuessThreeDigits);

        // then
        assertThat(result).isFalse();
    }

    /*
    * 참고: https://sakjung.tistory.com/33, https://www.baeldung.com/java-junit-testing-system-in
    * */
    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
