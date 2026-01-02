package racingcar.application.service.response;

import racingcar.domain.Car;

public record CarStatus(
        String name,
        int position
) {

    public static CarStatus from(Car car) {
        return new CarStatus(car.getName(), car.getPosition());
    }
}
