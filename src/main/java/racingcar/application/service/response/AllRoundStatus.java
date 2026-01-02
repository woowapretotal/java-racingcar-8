package racingcar.application.service.response;

import java.util.ArrayList;
import java.util.List;

public record AllRoundStatus(
        List<List<CarStatus>> roundStatuses
) {

    public static AllRoundStatus initialStatus() {
        return new AllRoundStatus(new ArrayList<>());
    }

    public void addRoundStatus(List<CarStatus> carStatuses) {
        roundStatuses().add(carStatuses);
    }
}
