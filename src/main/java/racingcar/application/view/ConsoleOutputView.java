package racingcar.application.view;

import racingcar.application.service.response.AllRoundStatus;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutputView {

    public void printOnboardingMessage(final String message) {
        System.out.println(message);
    }

    public void printAllRoundStatus(final AllRoundStatus allRoundStatus) {
        System.out.println("실행 결과");
        System.out.println(
                allRoundStatus.roundStatuses().stream()
                .map(OutputFormatter::formatRoundStatus)
                .collect(Collectors.joining(System.lineSeparator()))
        );
    }

    public void printWinner(final List<String> winners) {
        System.out.println(OutputFormatter.formatWinners(winners));
    }
}
