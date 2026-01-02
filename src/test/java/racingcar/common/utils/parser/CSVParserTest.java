package racingcar.common.utils.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.error.ErrorMessage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CSVParserTest {

    @DisplayName("CSV를 받아 문자열 목록으로 반환한다.")
    @Test
    void shouldReturnStringList_whenCsvIsGiven() {
        // given
        String csv = "pobi,bebe,hehe";

        // when
        List<String> values = CSVParser.split(csv);

        // then
        assertThat(values).hasSize(3);
        assertThat(values).containsExactly("pobi", "bebe", "hehe");
    }

    @DisplayName("빈 문자열이 입력되는 경우 실패한다")
    @Test
    void shouldThrowException_whenCsvEmpty() {
        // given
        String csv = "";

        // when && then
        assertThatThrownBy(() -> CSVParser.split(csv))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_CSV_VALUE.message());
    }

    @DisplayName("쉼표 사이의 공백은 trim 처리한다.")
    @Test
    void shouldTrimWhiteSpace_whenCsvIncludeWhiteSpace() {
        // given
        String csv = "pobi, bebe, hehe";

        // when
        List<String> values = CSVParser.split(csv);

        // then
        assertThat(values).hasSize(3);
        assertThat(values).containsExactly("pobi", "bebe", "hehe");
    }

}
