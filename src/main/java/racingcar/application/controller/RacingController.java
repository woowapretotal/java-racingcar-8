package racingcar.application.controller;

import racingcar.application.controller.reader.ConsoleInputHandler;
import racingcar.application.service.RacingService;
import racingcar.application.service.response.AllRoundStatus;
import racingcar.application.view.ConsoleOutputView;

import java.util.List;

public class RacingController {
    private final RacingService racingService;
    private final ConsoleInputHandler inputHandler;
    private final ConsoleOutputView outputView;

    public RacingController(final RacingService racingService, final ConsoleInputHandler inputHandler, final ConsoleOutputView outputView) {
        this.racingService = racingService;
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void saveCars() {
        List<String> carNames = inputHandler.readCarNames();
        racingService.saveCars(carNames);
    }

    public void runGame() {
        int tryCount = inputHandler.readTryCount();
        AllRoundStatus allRoundStatus = racingService.proceedGame(tryCount);
        outputView.printAllRoundStatus(allRoundStatus);
    }

    public void findWinners() {
        List<String> winnerNames = racingService.determineWinner();
        outputView.printWinner(winnerNames);
    }
}
