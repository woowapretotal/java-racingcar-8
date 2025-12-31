package racingcar.application.service.response;

import java.util.List;

public record AllRoundStatus(
        List<List<CarStatus>> roundStatuses
) {
}
