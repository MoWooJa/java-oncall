package oncall;

import oncall.domain.DaysOfWeek;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DaysOfWeekTest {


    @ParameterizedTest
    @ValueSource(strings = {"월","화","수","목","금","토","일"})
    void 정상적인_요일을_입력하면_성공한다(String koreanDay) {
        //given
        //when
        DaysOfWeek daysOfWeek = DaysOfWeek.check(koreanDay);
        //then
        Assertions.assertThat(daysOfWeek.getKoreanDay()).isEqualTo(koreanDay);
    }
    @ParameterizedTest
    @ValueSource(strings = {"윌","황","숭","몽","긍","통","잉"})
    void 비정상적인_요일을_입력하면_예외가_발생한다(String koreanDay) {
        //given
        //when & then
        Assertions.assertThatThrownBy(()->DaysOfWeek.check(koreanDay))
                .isInstanceOf(IllegalArgumentException.class);
        //then
    }
}