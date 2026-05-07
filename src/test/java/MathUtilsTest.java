import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Unit tests for {@link MathUtils}.
 *
 * <p>Sử dụng JUnit 5 Jupiter API:
 * - @Nested: nhóm tests theo chức năng, output đọc dễ hơn JUnit 4
 * - @DisplayName: tên test có nghĩa, không cần đọc code để hiểu intent
 * - @ParameterizedTest: tránh viết 5 test method giống nhau, DRY principle
 */
@DisplayName("MathUtils Unit Tests")
class MathUtilsTest {

    private MathUtils mathUtils;

    @BeforeEach
    void setUp() {
        mathUtils = new MathUtils();
    }

    @Nested
    @DisplayName("Addition Tests")
    class AdditionTests {

        @Test
        @DisplayName("Should return correct sum for positive numbers")
        void shouldAddTwoPositiveNumbers() {
            assertEquals(5, mathUtils.add(2, 3), "2 + 3 should equal 5");
        }

        @Test
        @DisplayName("Should handle negative numbers correctly")
        void shouldAddNegativeNumbers() {
            assertEquals(-1, mathUtils.add(-3, 2), "-3 + 2 should equal -1");
        }

        @ParameterizedTest(name = "{0} + {1} = {2}")
        @DisplayName("Parameterized addition test")
        @CsvSource({
                "1, 1, 2",
                "0, 0, 0",
                "-5, 5, 0",
                "100, 200, 300"
        })
        void shouldAddCorrectly(int a, int b, int expected) {
            assertEquals(expected, mathUtils.add(a, b));
        }
    }

    @ParameterizedTest(name = "subtract({0}, {1}) = {2}")
    @CsvSource({"10, 3, 7", "0, 5, -5", "-5, -5, 0"})
    @DisplayName("subtract() — comprehensive coverage")
    void subtractComprehensive(int a, int b, int expected) {
        assertEquals(expected, mathUtils.subtract(a, b));
    }

    @ParameterizedTest(name = "multiply({0}, {1}) = {2}")
    @CsvSource({"3, 4, 12", "0, 5, 0", "-3, 4, -12", "-3, -4, 12"})
    @DisplayName("multiply() — comprehensive coverage")
    void multiplyComprehensive(int a, int b, int expected) {
        assertEquals(expected, mathUtils.multiply(a, b));
    }

    @Nested
    @DisplayName("Division Tests")
    class DivisionTests {

        @Test
        @DisplayName("Should divide correctly")
        void shouldDivideTwoNumbers() {
            assertEquals(4, mathUtils.divide(8, 2));
        }

        @Test
        @DisplayName("Should throw ArithmeticException when dividing by zero")
        void shouldThrowExceptionWhenDividingByZero() {
            // assertThrows trả về exception object để có thể assert thêm về message
            ArithmeticException exception = assertThrows(
                    ArithmeticException.class,
                    () -> mathUtils.divide(10, 0),
                    "Division by zero should throw ArithmeticException"
            );
            assertEquals("Cannot divide by zero", exception.getMessage());
        }
    }
}