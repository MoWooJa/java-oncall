package oncall.domain.vo;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.NotThrownAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void 이름이_1글자_5글자이면_성공한다() {
        //given
        String name = "김아무개";
        //when & then
        assertThatCode(() -> new Name(name))
            .doesNotThrowAnyException();

    }
    @ParameterizedTest
    @ValueSource(strings = {"","김아무개다섯글자초과"})
    void 이름이_5글자_이상이면_예외가_발생한다(String name) {
        //given
        //when & then
        Assertions.assertThatThrownBy(()-> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}