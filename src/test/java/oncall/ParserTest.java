package oncall;

import oncall.domain.dto.ParsedInput;
import oncall.util.Parser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

class ParserTest {

    @ParameterizedTest
    @MethodSource("provideInputForParsing")
    void 올바른_형식이_입력되면_파싱을_성공한다(String input, String expectedMonth,String expectedDay ) {
        //given
        //when
        ParsedInput parsedInput = Parser.parseInput(input);
        //then
        Assertions.assertThat(parsedInput.getMonth()).isEqualTo(expectedMonth);
        Assertions.assertThat(parsedInput.getKoreanDay()).isEqualTo(expectedDay);


    }
    @ParameterizedTest
    @ValueSource(strings =
            {
                    ",월,5",
                    "월,,5",
                    "월,5,"
            }
    )
    void 올바르지_않은_형식이_입력되면_예외가_발생한다(String input) {
        //given
        //when & then
        Assertions.assertThatThrownBy(()->Parser.parseInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideInputForParsing() {
        return Stream.of(
                Arguments.of("5,월", "5", "월"),
                Arguments.of("6,화", "6", "화"),
                Arguments.of("7,목", "7", "목")
        );

    }

}