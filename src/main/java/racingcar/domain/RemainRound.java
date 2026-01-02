package racingcar.domain;

import racingcar.common.error.DomainException;
import racingcar.common.error.ErrorMessage;

import java.util.Objects;

public class RemainRound {
    private static final int MIN_ROUND_STATUS = 0;

    private final int value;

    public RemainRound(final int value) {
        validatePossibleValue(value);
        this.value = value;
    }

    private void validatePossibleValue(final int value) {
        if (value < MIN_ROUND_STATUS) {
            throw new DomainException(ErrorMessage.OUT_RANGE_OF_MOVE_COUNT, MIN_ROUND_STATUS);
        }
    }

    public RemainRound nextRound() {
        return new RemainRound(value - 1);
    }

    public boolean canProceed() {
        return value > MIN_ROUND_STATUS;
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(final Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        RemainRound remainRound = (RemainRound) object;
        return value == remainRound.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
