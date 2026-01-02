package racingcar.domain;

import java.util.Optional;

public interface CarsRepository {

    Optional<Cars> findCars();

    void save(Cars cars);
}
