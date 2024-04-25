package uk.gov.digital;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    @DisplayName("Empty string returns an integer zero")
    @Test
    void emptyInputStringReturnZero () {
        int result = StringCalculator.calculate("");
        assertEquals(0, result);
    }
    @DisplayName("Single number input returns the value")
    @ParameterizedTest
    @MethodSource("returnsInput")

    void singleNumReturnsValue(String input, int expected) {
        int actual = StringCalculator.calculate(input);
        assertEquals(expected, actual);
    }
    // cnuse csvSource annotwtion to do param tests too
    private static Stream<Arguments> returnsInput() {
        return Stream.of(
                Arguments.of("1", 1),
                Arguments.of("2", 2),
                Arguments.of("0", 0)
        );
    }
    @DisplayName("two number input comma delimited returns the sum")
    @Test
    void returnsSumOfTwoNumbers() {
        int result = StringCalculator.calculate("2,3");
        assertEquals(5, result);
    }
    @DisplayName("two number input newline delimited returns the sum")
    @Test
    void returnsSumOfTwoNumbersNewline() {
        int result = StringCalculator.calculate("2\n4");
        assertEquals(6, result);
    }
    @DisplayName("three numbers input delimited comma & new line returns the sum")
    @Test
    void returnsSumOfThreeNumbers() {
        int result = StringCalculator.calculate("2\n4,2");
        assertEquals(8, result);
    }
  @Test
    void exceptionForNegativeNumbers () {

      Exception exception = assertThrows(IllegalArgumentException.class,
              () -> {StringCalculator.calculate("-1");
      });
      assertEquals("numbers cannot be negative", exception.getMessage());
  }


}
