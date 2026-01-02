package racingcar.application.controller;

import racingcar.application.controller.reader.ConsoleInputHandler;
import racingcar.application.service.RacingService;
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
        /*int xx = inputReader.readXX();
        XServiceXXXResponse response = xService.logic(new XServiceXXXRequest(xx));
        outputView.printXX(response);*/
    }
}
