package racingcar.config;

import racingcar.application.controller.RacingController;
import racingcar.application.controller.reader.ConsoleInputHandler;
import racingcar.application.service.RacingService;
import racingcar.application.view.ConsoleInputView;
import racingcar.application.view.ConsoleOutputView;
import racingcar.domain.CarsRepository;
import racingcar.domain.MoveCondition;
import racingcar.domain.RandomMoveCondition;
import racingcar.infra.CarsInMemoryRepository;

public class AppConfig {
    private final CarsRepository carsRepository = new CarsInMemoryRepository();
    private final ConsoleInputView inputView = new ConsoleInputView();
    private final ConsoleOutputView outputView = new ConsoleOutputView();
    private final ConsoleInputHandler inputHandler = new ConsoleInputHandler(inputView, outputView);

    public CarsRepository carsRepository() {
        return carsRepository;
    }

    public MoveCondition moveCondition() {
        return new RandomMoveCondition();
    }

    public RacingService racingService() {
        return new RacingService(moveCondition(), carsRepository());
    }

    public RacingController racingController() {
        return new RacingController(racingService(), inputHandler, outputView);
    }
}
