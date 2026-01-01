package racingcar.domain;

import racingcar.common.error.DomainException;
import racingcar.common.error.ErrorMessage;

import java.util.Objects;

public class CarPosition implements Comparable<CarPosition> {
    private static final int MIN_POSITION = 0;
    private static final int INITIAL_POSITION = 0;
    private static final int STEP = 1;

    private final int value;

    private CarPosition(final int value) {
        validatePossibleValue(value);
        this.value = value;
    }

    public static CarPosition initialPosition() {
        return new CarPosition(INITIAL_POSITION);
    }

    private void validatePossibleValue(final int value) {
        if (value < MIN_POSITION) {
            throw new DomainException(ErrorMessage.BELOW_MIN_POSITION, MIN_POSITION);
        }
    }

    public CarPosition advance() {
        return new CarPosition(value + STEP);
    }

    public int value() {
        return value;
    }

    @Override
    public int compareTo(final CarPosition other) {
        return Integer.compare(this.value, other.value);
    }

    @Override
    public boolean equals(final Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        CarPosition carPosition = (CarPosition) object;
        return value == carPosition.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
