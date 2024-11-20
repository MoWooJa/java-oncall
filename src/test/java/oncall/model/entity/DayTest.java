package oncall.model.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import oncall.model.entity.type.Week;
import oncall.model.util.LegalHolidayChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DayTest {
    @DisplayName("하루는 일자, 요일을 입력헤 생성할 수 있다.")
    @Test
    void dayCreateAndStoreTest() {
        Day day = new Day(1,1, Week.MONDAY);
        assertThat(day.toString().trim()).isEqualTo("1월 1일 월");
    }

    @DisplayName("하루에 법정 공휴일 여부를 저장할 수 있다.")
    @Test
    void daySetHolliday() {
        Day day = new Day(1, 1, Week.MONDAY);
        day.checkLegalHoliday();
        assertThat(day.isLegalHoliday()).isTrue();
    }

    @DisplayName("하루에 근무자를 저장, 확인, 교체할 수 있다.")
    @Test
    void daySetDeveloper() {
        Day day = new Day(1, 1, Week.MONDAY);
        day.checkLegalHoliday();
        day.assignWorker("루비");
        assertTrue(day.isAssigned("루비"));
        day.assignWorker("루피");
        assertFalse(day.isAssigned("루비"));
        assertTrue(day.isAssigned("루피"));
    }
}
