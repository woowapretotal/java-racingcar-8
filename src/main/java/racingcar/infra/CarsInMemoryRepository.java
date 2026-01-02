package racingcar.infra;

import racingcar.domain.Cars;
import racingcar.domain.CarsRepository;

import java.util.Optional;

public class CarsInMemoryRepository implements CarsRepository {

    @Override
    public Optional<Cars> findCars() {
        return Optional.empty();
    }

    @Override
    public void save(final Cars x) {

    }
}
