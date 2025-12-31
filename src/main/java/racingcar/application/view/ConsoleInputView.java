package racingcar.application.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.utils.converter.TypeConverter;

public class ConsoleInputView {

    public int readNumber() {
        return TypeConverter.toInteger(readLine());
    }

    public String readLine() {
        return Console.readLine();
    }
}
