package oncall;

import oncall.domain.model.Month;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MonthTest {

    @ParameterizedTest
    @ValueSource(strings = {"1","2","3","4","5","6","7","8","9","10","11","12"})
    void 제대로_된_월을_입력하면_enum을_반환한다(String month) {
        //given
        //when
        Month check = Month.check(month);
        //then
        Assertions.assertThat(check.getMonth()).isEqualTo(month);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0","13","100"})
    void 제대로_된_월을_입력하지_않으면_예외가_발생한다(String month) {
        //given
        //when & then
        Assertions.assertThatThrownBy(() -> Month.check(month))
                .isInstanceOf(IllegalArgumentException.class);
    }
}