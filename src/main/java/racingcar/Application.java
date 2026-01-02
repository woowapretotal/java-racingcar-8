package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.application.controller.RacingController;
import racingcar.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        try {
            AppConfig appConfig = new AppConfig();
            RacingController racingController = appConfig.racingController();
            racingController.saveCars();
            racingController.runGame();
            racingController.findWinners();
        } finally {
            Console.close();
        }
    }
}
