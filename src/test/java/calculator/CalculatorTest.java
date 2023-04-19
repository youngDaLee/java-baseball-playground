package calculator;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void calc() {
        double test = Calculator.calc("1 + 2 * 3");
        assertThat(test).isEqualTo(9);
    }

    @Test
    void main() {
        String calcString = "1 + 2 * 3";
        InputStream in = new ByteArrayInputStream(calcString.getBytes());
        System.setIn(in);

        calculator.Calculator.main();
    }
}