package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @DisplayName("자동차 객체 생성 시 초기 위치는 0이다.")
    @Test
    void shouldPositionBeZero_whenCreateInitCar() throws Exception {
        // given & when
        Car car = Car.createAtStart("bebe");

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("이동 시 자동차 객체의 위치가 증가한다.")
    @Test
    void carPositionIncrease_whenCarMove() {
        // given
        Car car = Car.createAtStart("bebe");

        // when
        Car movedCar = car.move();

        // then
        assertThat(movedCar.getPosition()).isGreaterThan(car.getPosition());
    }

    @DisplayName("동일한 위치의 자동차와 비교가 가능하다")
    @Test
    void canCompare_havingSamePosition() {
        // given
        Car car1 = Car.createAtStart("bebe");
        Car car2 = Car.createAtStart("keke");

        // when
        boolean result = car1.isSamePosition(car2);

        // then
        assertThat(result).isTrue();
    }
}
