package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    /**
     * String 테스트 요구사항 1구현
     */
    @Test
    void stringTest_01() {
        String[] splitString = "1,2".split(",");
        assertThat(splitString).contains("1", "2");
        assertThat(splitString).containsExactly("1", "2");
    }

    /**
     * String 테스트 요구사항 2구현
     */
    @Test
    void stringTest_02() {
        String removeString = "(1,2)".replace("(", "").replace(")", "");
        assertThat(removeString).isEqualTo("1,2");
    }

    /**
     * String 테스트 요구사항 3구현
     */
    @Test
    @DisplayName("실패")
    void stringTest_03() {
        String abc = "abc";
        assertThatThrownBy( () -> {
            abc.charAt(3);
                }
        ).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
