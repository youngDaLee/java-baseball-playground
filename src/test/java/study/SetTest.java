package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    /**
     * 요구사항 1.
     */
    @Test
    void setTest01() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    /**
     * 요구사항 2
     */
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void setTest02(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    /**
     * 요구사항 3
     */
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3", "4:4", "5:5"}, delimiter = ':')
    void setTest03(String input, String expected) {
        assertThat(numbers.contains(Integer.parseInt(input))).isTrue();
    }
}
