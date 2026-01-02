package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.error.DomainException;
import racingcar.common.error.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차 이름은 비어있을 수 없다")
    void carNameShouldFilled(String input) {
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(DomainException.class)
                .hasMessage(ErrorMessage.EMPTY_CAR_NAME.message());
    }

    @ParameterizedTest
    @ValueSource(strings = {"b", "bebe", "bebeb", "as b"})
    @DisplayName("5자 이하의 자동차 이름을 만들 수 있다.")
    void nameLength_shouldBelowFive(String input) {
        assertThatNoException()
                .isThrownBy(() -> new CarName(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"bebebb", "asfdffffff"})
    @DisplayName("5자를 초과하는 자동차 이름을 생성할 수 없다..")
    void nameLengthOverFive_shouldThrowException(String input) {
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(DomainException.class)
                .hasMessage(ErrorMessage.CAR_NAME_EXCEED_MAX_LENGTH.formatted(5));
    }
}
