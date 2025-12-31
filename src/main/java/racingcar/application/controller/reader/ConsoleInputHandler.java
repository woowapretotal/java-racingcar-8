package racingcar.application.controller.reader;

import racingcar.application.view.ConsoleInputView;
import racingcar.application.view.ConsoleOutputView;
import racingcar.common.utils.parser.CSVParser;

import java.util.List;

public class ConsoleInputHandler {
    private final ConsoleOutputView outputView;
    private final ConsoleInputView inputView;

    public ConsoleInputHandler(final ConsoleInputView inputView, final ConsoleOutputView outputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public List<String> readCarNames() {
        outputView.printOnboardingMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String line = inputView.readLine();
        return CSVParser.split(line);
    }

    public int readTryCount() {
        outputView.printOnboardingMessage("시도할 횟수는 몇 회인가요?");
        return inputView.readNumber();
    }
}
