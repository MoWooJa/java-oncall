package oncall.domain.domainService;

import oncall.domain.model.DaysOfWeek;
import oncall.domain.model.WorkerRecord;
import oncall.domain.dto.ParsedInput;
import oncall.domain.service.DateCalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DateCalculateServiceTest {
    private ParsedInput parsedInput;
    private DateCalculateService dateCalculateService;

    @BeforeEach
    void setUp() {
        dateCalculateService = new DateCalculateService();

    }

    @Test
    void 평일_근무일과_휴일_근무일_제대로_계산하면_성공한다() {
        //given
        parsedInput = new ParsedInput("10", "월");

        List<DaysOfWeek> expectedHolidays = List.of(
                DaysOfWeek.WEDNESDAY, // 10/3
                DaysOfWeek.SATURDAY, // 10/7
                DaysOfWeek.SUNDAY,  // 10/8
                DaysOfWeek.TUESDAY,  // 10/9
                DaysOfWeek.SATURDAY, // 10/14
                DaysOfWeek.SUNDAY,  // 10/15
                DaysOfWeek.SATURDAY, // 10/21
                DaysOfWeek.SUNDAY,  // 10/22
                DaysOfWeek.SATURDAY, // 10/28
                DaysOfWeek.SUNDAY   // 10/29
        );

        List<DaysOfWeek> expectedWeekdays = List.of(
                DaysOfWeek.MONDAY,    //10/1
                DaysOfWeek.TUESDAY,   // 10/2
                DaysOfWeek.THURSDAY,  // 10/4
                DaysOfWeek.FRIDAY,    // 10/5
                DaysOfWeek.MONDAY,    // 10/8
                DaysOfWeek.WEDNESDAY, // 10/10
                DaysOfWeek.THURSDAY,  // 10/11
                DaysOfWeek.FRIDAY,    // 10/12
                DaysOfWeek.MONDAY,    // 10/15
                DaysOfWeek.TUESDAY,   // 10/16
                DaysOfWeek.WEDNESDAY, // 10/17
                DaysOfWeek.THURSDAY,  // 10/18
                DaysOfWeek.FRIDAY,    // 10/19
                DaysOfWeek.MONDAY,    // 10/22
                DaysOfWeek.TUESDAY,   // 10/23
                DaysOfWeek.WEDNESDAY, // 10/24
                DaysOfWeek.THURSDAY,  // 10/25
                DaysOfWeek.FRIDAY,    // 10/26
                DaysOfWeek.MONDAY,    // 10/29
                DaysOfWeek.TUESDAY,   // 10/30
                DaysOfWeek.WEDNESDAY  // 10/31
        );
        //when
        WorkerRecord workerRecord = dateCalculateService.calculateWeekdaysAndHolidays(parsedInput);
        //then
        assertEquals(expectedHolidays, workerRecord.getHolidays());
        assertEquals(expectedWeekdays, workerRecord.getWeekdays());

    }


}