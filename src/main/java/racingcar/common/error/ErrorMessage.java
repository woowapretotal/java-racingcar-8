package racingcar.common.error;

public enum ErrorMessage {
    INVALID_INTEGER_FORMAT("정수 형식의 문자가 아닙니다."),
    INVALID_DECIMAL_FORMAT("소수 형식의 문자가 아닙니다."),
    EMPTY_CAR_NAME("자동차 이름은 공백이거나 비어있을 수 없습니다."),
    EXCEED_MAX_LENGTH("자동차 이름은 %d자 이하여야 합니다."),
    BELOW_MIN_POSITION("자동차 위치는 %d 이상이어야 합니다."),
    EMPTY_CSV_VALUE("비어있는 항목이 존재합니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String formatted(final Object... args) {
        return message.formatted(args);
    }
}
