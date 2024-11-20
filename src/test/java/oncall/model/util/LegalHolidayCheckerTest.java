package oncall.model.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LegalHolidayCheckerTest {

    @CsvSource(value = {"1,1", "3,1", "5,5", "6,6", "8,15", "10,3", "10,9", "12,25"})
    @DisplayName("법정 공휴일의 월, 일을 입력하면 참을 반환한다.")
    @ParameterizedTest
    void checkLegalHolidayTest(int month, int date) {
        boolean isLegalHoliday = LegalHolidayChecker.isLegalHoliday(month, date);
        assertTrue(isLegalHoliday);
    }

    @CsvSource(value = {"1,2", "3,2", "5,6", "6,7", "8,14", "10,2", "10,10", "12,24"})
    @DisplayName("법정 공휴일이 아닌 월, 일을 입력하면 거짓을 반환한다.")
    @ParameterizedTest
    void checkLegalHolidayTest2(int month, int date) {
        boolean isLegalHoliday = LegalHolidayChecker.isLegalHoliday(month, date);
        assertFalse(isLegalHoliday);
    }
}
