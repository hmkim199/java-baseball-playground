package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split(){
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1", "2");
    }

    @Test
    void splitJustOne(){
        String[] actual = "1".split(",");
        assertThat(actual).containsOnly("1");
    }

    @Test
    void substring(){
        String actual = "(1,2)".substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void charAt(){
        Character actual = "123".charAt(2);
        assertThat(actual).isEqualTo('3');
    }

    @Test
    @DisplayName("인덱스 예외 - 예외 던진 주체 테스트")
    void charAtExceptionThrownBy(){
        assertThatThrownBy(() -> {
            Character actual = "12".charAt(2);
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("String index out of range: 2");
    }

    @Test
    @DisplayName("인덱스 예외 - 타입 테스트")
    void charAtExceptionOfType(){
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    Character actual = "ab".charAt(2);
                }).withMessageMatching("String index out of range: 2");
    }

}
