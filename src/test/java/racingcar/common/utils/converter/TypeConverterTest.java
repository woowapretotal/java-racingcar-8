package racingcar.common.utils.converter;

import racingcar.common.error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TypeConverterTest {

    @Nested
    @DisplayName("toInteger 메서드를 검증한다")
    class ToIntegerMethod {

        @ParameterizedTest
        @CsvSource({
                "123, 123",
                "-456, -456",
                "0, 0",
                "2147483647, 2147483647",
                "-2147483648, -2147483648"
        })
        @DisplayName("유효한 정수 문자열을 정수로 변환한다")
        void shouldConvertValidStringToInteger(String input, int expected) {
            // when
            int result = TypeConverter.toInteger(input);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @ParameterizedTest
        @ValueSource(strings = {"abc", "12.34", "1a2", " ", "", "one", "1,000"})
        @DisplayName("정수 형식이 아닌 문자열 입력 시 예외를 발생시킨다")
        void shouldThrowExceptionWhenInputIsNotInteger(String input) {
            // when && then
            assertThatThrownBy(() -> TypeConverter.toInteger(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.INVALID_INTEGER_FORMAT.message());
        }

        @ParameterizedTest
        @NullSource
        @DisplayName("null 입력 시 예외를 발생시킨다")
        void shouldThrowExceptionWhenInputIsNull(String input) {
            // when && then
            assertThatThrownBy(() -> TypeConverter.toInteger(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INTEGER_FORMAT.message());
        }

        @ParameterizedTest
        @ValueSource(strings = {"9999999999999", "-9999999999999"})
        @DisplayName("Integer 범위를 초과하는 문자열 입력 시 예외를 발생시킨다")
        void shouldThrowExceptionWhenInputExceedsIntegerRange(String input) {
            // when & then
            assertThatThrownBy(() -> TypeConverter.toInteger(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.INVALID_INTEGER_FORMAT.message());
        }

        @ParameterizedTest
        @ValueSource(strings = {" 123 ", " 123", "123 "})
        @DisplayName("앞뒤 공백이 있는 숫자 문자열 입력 시 예외를 발생시킨다")
        void shouldThrowExceptionWhenInputHasWhitespace(String input) {
            // when && then
            assertThatThrownBy(() -> TypeConverter.toInteger(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.INVALID_INTEGER_FORMAT.message());
        }
    }

    @Nested
    @DisplayName("toDecimal 메서드를 검증한다.")
    class ToDecimalMethod {

        @ParameterizedTest
        @CsvSource({
                "123.45, 123.45",
                "-456.78, -456.78",
                "0.0, 0.0",
                "123, 123.0"
        })
        @DisplayName("유효한 소수 문자열을 소수로 변환한다")
        void shouldConvertValidStringToDecimal(String input, double expected) {
            // when
            double result = TypeConverter.toDecimal(input);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @ParameterizedTest
        @ValueSource(strings = {"abc", "12.34.56", "1a2", " ", "", "one"})
        @DisplayName("소수 형식이 아닌 문자열 입력 시 예외를 발생시킨다")
        void shouldThrowExceptionWhenInputIsNotDecimal(String input) {
            // when && then
            assertThatThrownBy(() -> TypeConverter.toDecimal(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.INVALID_DECIMAL_FORMAT.message());
        }

        @ParameterizedTest
        @NullSource
        @DisplayName("null 입력 시 예외를 발생시킨다")
        void shouldThrowExceptionWhenInputIsNull(String input) {
            // when && then
            assertThatThrownBy(() -> TypeConverter.toDecimal(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.EMPTY_INPUT.message());
        }
    }
}
