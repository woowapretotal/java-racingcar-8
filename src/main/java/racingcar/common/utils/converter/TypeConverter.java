package racingcar.common.utils.converter;

import racingcar.common.error.ApplicationException;
import racingcar.common.error.ErrorMessage;

public class TypeConverter {

    public static int toInteger(String line) {
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new ApplicationException(ErrorMessage.INVALID_INTEGER_FORMAT);
        }
    }

    public static double toDecimal(String line) {
        try {
            return Double.parseDouble(line);
        } catch (NumberFormatException e) {
            throw new ApplicationException(ErrorMessage.INVALID_DECIMAL_FORMAT);
        }
    }
}
