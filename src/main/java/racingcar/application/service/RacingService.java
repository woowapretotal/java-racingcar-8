package racingcar.application.service;

import racingcar.domain.Cars;
import racingcar.domain.CarsRepository;
import racingcar.domain.MoveCondition;

import java.util.List;

public class RacingService {
    private final MoveCondition moveCondition;
    private final CarsRepository carsRepository;

    public RacingService(final MoveCondition moveCondition, final CarsRepository carsRepository) {
        this.moveCondition = moveCondition;
        this.carsRepository = carsRepository;
    }

    public void saveCars(final List<String> carNames) {
        Cars cars = new Cars(carNames);
        carsRepository.save(cars);
    }
}
