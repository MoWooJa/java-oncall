package oncall.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WorkerGroupTest {

    @Test
    void 정상적인_근무자_형식이면_성공한다() {
        //given
        List<String> weekdaysWorker = Arrays.asList("a","b","c","d","e");
        List<String> holidaysWorker = Arrays.asList("a","b","c","d","e");
        //when & then
        assertThatCode(() -> new WorkerGroup(weekdaysWorker, holidaysWorker))
                .doesNotThrowAnyException();

    }
    @Test
    @DisplayName("같은 그룹내 중복된 근무자 발생")
    void 비정상적인_근무자_형식이면_예외가_발생한다() {
        //given
        List<String> weekdaysWorker = Arrays.asList("a","b","c","d","e","a");
        List<String> holidaysWorker = Arrays.asList("a","b","c","d","e","a");
        //when & then
        assertThatThrownBy(() -> new WorkerGroup(weekdaysWorker, holidaysWorker))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @Test
    @DisplayName("평일과 휴일 근무자 수 불일치")
    void 비정상적인_근무자_형식이면_예외가_발생한다2() {
        //given
        List<String> weekdaysWorker = Arrays.asList("a","b","c","d","e","f");
        List<String> holidaysWorker = Arrays.asList("a","b","c","d","e");
        //when & then
        assertThatThrownBy(() -> new WorkerGroup(weekdaysWorker, holidaysWorker))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @Test
    @DisplayName("5명 이내의 근로자 수")
    void 비정상적인_근무자_형식이면_예외가_발생한다3() {
        //given
        List<String> weekdaysWorker = Arrays.asList("a","b","c");
        List<String> holidaysWorker = Arrays.asList("a","b","c");
        //when & then
        assertThatThrownBy(() -> new WorkerGroup(weekdaysWorker, holidaysWorker))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @Test
    @DisplayName("35명 초과의 근로자 수")
    void 비정상적인_근무자_형식이면_예외가_발생한다4() {
        //given
        List<String> weekdaysWorker = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9",
                "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
                "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36");
        List<String> holidaysWorker = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9",
                        "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
                        "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36");
        //when & then
        assertThatThrownBy(() -> new WorkerGroup(weekdaysWorker, holidaysWorker))
                .isInstanceOf(IllegalArgumentException.class);

    }
}