package racingcar.application.view;

import racingcar.application.service.response.CarStatus;

import java.util.List;
import java.util.stream.Collectors;

public final class OutputFormatter {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String POSITION_CHARACTER = "-";
    private static final String COMMA_SEPARATOR = ", ";
    private static final String WINNER_PREFIX = "최종 우승자 : ";

    private OutputFormatter() {
    }

    public static String formatRoundStatus(List<CarStatus> carStatuses) {
        return carStatuses.stream()
                .map(OutputFormatter::formatCarStatus)
                .collect(Collectors.joining(LINE_SEPARATOR));
    }

    private static String formatCarStatus(CarStatus carStatus) {
        return "%s : ".formatted(carStatus.name()) + POSITION_CHARACTER.repeat(carStatus.position());
    }

    public static String formatWinners(List<String> carNames) {
        String commaSeparatedNames = String.join(COMMA_SEPARATOR, carNames);
        return WINNER_PREFIX + commaSeparatedNames;
    }
}
