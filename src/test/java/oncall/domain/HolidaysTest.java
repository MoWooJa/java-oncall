package oncall.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HolidaysTest {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "3, 1",
            "5, 5",
            "6, 6",
            "8, 15",
            "10, 3",
            "10, 9",
            "12, 25"
    }
    )
    void 휴일_비상_근무를_정상적으로_계산하면_성공한다(int month, int day) {
        //given
        boolean expected = true;
        //when
        boolean holiday = Holidays.isHoliday(month, day);
        //then
        assertEquals(expected, holiday);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 11",
            "3, 22",
            "5, 1",
            "6, 1",
            "8, 1",
            "10, 1",
            "10, 1",
            "12, 1"
    }
    )
    void 휴일_비상_근무가_아닌_경우_false를_리턴하면_성공한다(int month, int day) {
        //given
        boolean expected = false;
        //when
        boolean holiday = Holidays.isHoliday(month, day);
        //then
        assertEquals(expected, holiday);
    }

}