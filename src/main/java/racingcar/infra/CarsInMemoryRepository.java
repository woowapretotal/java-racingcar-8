package racingcar.infra;

import racingcar.domain.Cars;
import racingcar.domain.CarsRepository;

import java.util.Optional;

public class CarsInMemoryRepository implements CarsRepository {
    private Cars cars;

    @Override
    public Optional<Cars> findCars() {
        return Optional.ofNullable(cars);
    }

    @Override
    public void save(final Cars cars) {
        this.cars = cars;
    }
}
