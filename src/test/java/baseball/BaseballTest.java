package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
