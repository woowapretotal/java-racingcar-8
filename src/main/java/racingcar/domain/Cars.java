package racingcar.domain;

import racingcar.common.error.DomainException;
import racingcar.common.error.ErrorMessage;

import java.util.List;

import static racingcar.common.error.ErrorMessage.EMPTY_CAR_NAME;
import static racingcar.common.error.ErrorMessage.NOT_ENOUGH_CAR_NAME;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<String> cars) {
        validateCarNumbers(cars);
        validateCarNameDuplicated(cars);
        this.cars = cars.stream()
                .map(Car::createAtStart)
                .toList();
    }

    private void validateCarNumbers(final List<String> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new DomainException(NOT_ENOUGH_CAR_NAME);
        }
    }

    private void validateCarNameDuplicated(final List<String> rawCarNames) {
        long count = rawCarNames.stream()
                .distinct()
                .count();

        if (rawCarNames.size() != count) {
            throw new DomainException(ErrorMessage.DUPLICATED_CAR_NAME);
        }
    }

    public void moveCarsBy(MoveCondition moveCondition) {
        cars.replaceAll(car ->
                moveCondition.canMove() ? car.move() : car
        );
    }

    public List<Car> determineWinners() {
        Car maxCar = cars.stream()
                .max((c1, c2) -> Integer.compare(c2.getPosition(), c1.getPosition()))
                .orElseThrow(() -> new DomainException(EMPTY_CAR_NAME));

        return cars.stream()
                .filter(maxCar::isSamePosition)
                .toList();
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }
}
