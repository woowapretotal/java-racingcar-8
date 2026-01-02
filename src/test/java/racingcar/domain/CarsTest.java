package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.common.error.DomainException;
import racingcar.common.error.ErrorMessage;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @DisplayName("자동차 이름 목록이 비어있을 수 없다.")
    @Test
    void cannotCreateCars_withEmptyCarName() {
        // given
        List<String> carNames = List.of();

        // when & then
        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(DomainException.class)
                .hasMessage(ErrorMessage.NOT_ENOUGH_CAR_NAME.message());
    }

    @Nested
    class carsLogicTest {
        List<String> carNames;

        @BeforeEach
        void init() {
            carNames = List.of("bebe", "keke", "hehe");
        }

        @DisplayName("자동차 이름을 통해 자동차를 생성할 수 있다.")
        @Test
        void canCreateCars_withCarName() throws Exception {
            // given & when & then
            assertThatNoException()
                    .isThrownBy(() -> new Cars(carNames));
        }

        @DisplayName("여러 자동차를 움직일 수 있다.")
        @Test
        void canMoveCars() {
            // given
            Cars cars = new Cars(carNames);

            // when
            cars.moveCarsBy(new AlwaysMoveCondition());

            // then
            List<Integer> carPositions = cars.getCars().stream()
                    .map(Car::getPosition)
                    .toList();

            assertThat(carPositions)
                    .containsExactly(1, 1, 1);
        }

        @DisplayName("우승자를 단독으로 식별할 수 있다.")
        @Test
        void canDetermineOneWinner() {
            // given
            Cars cars = new Cars(carNames);
            SequentialMoveCondition moveCondition = new SequentialMoveCondition(true, false, false);
            cars.moveCarsBy(moveCondition);

            // when
            List<Car> winners = cars.determineWinners();

            // then
            assertThat(winners).hasSize(1);
            assertThat(winners.getFirst().getName()).isEqualTo("bebe");
        }

        @DisplayName("여러 우승자를 공동으로 식별할 수 있다.")
        @Test
        void canDetermineWinners() {
            // given
            Cars cars = new Cars(carNames);
            SequentialMoveCondition moveCondition = new SequentialMoveCondition(true, true, false);
            cars.moveCarsBy(moveCondition);

            // when
            List<Car> winners = cars.determineWinners();

            // then
            assertThat(winners).hasSize(2);
            List<String> names = winners.stream().map(Car::getName).toList();
            assertThat(names).containsExactly("bebe", "keke");
        }
    }

}
