package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public final class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("빈 string이 입력될 때")
    void emptyStringTest() {
        Integer result = calculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("null이 입력될 때")
    void nullTest() {
        Integer result = calculator.calculate(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("하나의 정수가 입력될 때")
    void calculateSingleIntegerTest() {
        String input = "3";
        Integer result = calculator.calculate(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("여러개의 정수가 콤마와 한께 입력될 때")
    void calculateMultipleIntegerTest() {
        String input = "1,2,3";
        Integer result = calculator.calculate(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("여러개의 정수가 콜론와 한께 입력될 때")
    void collonSplitterTest() {
        String input = "1,2;3";
        Integer result = calculator.calculate(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("여러개의 정수가 커스텀 구분자와 한께 입력될 때")
    void customSplitterTest() {
        String input = "//;\n1;2;3";
        Integer result = calculator.calculate(input);
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,a,3", "1,-2,3"})
    @DisplayName("잘못된 값이 포함될 때")
    void illegalArgumentExceptionTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));
    }
}
