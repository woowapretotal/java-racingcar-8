package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarPositionTest {

    @DisplayName("초기 위치는 0에서 시작한다.")
    @Test
    void initialPosition_ShouldBeZero() {
        // given & when
        CarPosition carPosition = CarPosition.initialPosition();

        // then
        assertThat(carPosition.value()).isEqualTo(0);
    }

    @DisplayName("자동차가 전진하면 위치가 1만큼 증가한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 100})
    void shouldIncreasePosition_whenMove(int value) throws Exception {
        // given
        CarPosition carPosition = CarPosition.initialPosition();

        // when
        for (int i = 0; i < value; i++) {
            carPosition = carPosition.advance();
        }

        // then
        assertThat(carPosition.value()).isEqualTo(value);
    }
}
