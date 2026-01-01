package racingcar.domain;

import racingcar.common.error.DomainException;

import java.util.Objects;

import static racingcar.common.error.ErrorMessage.EMPTY_CAR_NAME;
import static racingcar.common.error.ErrorMessage.EXCEED_MAX_LENGTH;

public class CarName {
    private static final int MAX_LENGTH = 5;

    private final String value;

    public CarName(final String value) {
        validateNotEmpty(value);
        validateLength(value);
        this.value = value;
    }

    private void validateNotEmpty(final String value) {
        if (value == null || value.isBlank()) {
            throw new DomainException(EMPTY_CAR_NAME);
        }
    }

    private void validateLength(final String value) {
        if (value.length() > MAX_LENGTH) {
            throw new DomainException(EXCEED_MAX_LENGTH, MAX_LENGTH);
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(final Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        CarName xvo = (CarName) object;
        return value == xvo.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
