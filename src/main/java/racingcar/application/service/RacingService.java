package racingcar.application.service;

import racingcar.application.service.response.AllRoundStatus;
import racingcar.application.service.response.CarStatus;
import racingcar.common.error.ApplicationException;
import racingcar.domain.*;

import java.util.List;

import static racingcar.common.error.ErrorMessage.EMPTY_CAR_INFO;

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

    public AllRoundStatus proceedGame(int tryCount) {
        Cars cars = findCars();
        RemainRound remainRound = new RemainRound(tryCount);
        AllRoundStatus allRoundStatus = AllRoundStatus.initialStatus();

        while (remainRound.canProceed()) {
            proceedRound(cars, allRoundStatus);
            remainRound = remainRound.nextRound();
        }

        return allRoundStatus;
    }

    private void proceedRound(Cars cars, AllRoundStatus allRoundStatus) {
        cars.moveCarsBy(moveCondition);
        List<CarStatus> carStatuses = createCarStatuses(cars);
        allRoundStatus.addRoundStatus(carStatuses);
    }

    private List<CarStatus> createCarStatuses(Cars cars) {
        return cars.getCars().stream()
                .map(CarStatus::from)
                .toList();
    }

    public List<String> determineWinner() {
        Cars cars = findCars();
        List<Car> winners = cars.determineWinners();
        return winners.stream()
                .map(Car::getName)
                .toList();
    }

    private Cars findCars() {
        return carsRepository.findCars()
                .orElseThrow(() -> new ApplicationException(EMPTY_CAR_INFO));
    }
}
