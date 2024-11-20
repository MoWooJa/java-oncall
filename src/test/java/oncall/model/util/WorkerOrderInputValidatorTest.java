package oncall.model.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WorkerOrderInputValidatorTest {
    public class WorkerOrderInputValidator {
        private static final String LINE_SEPARATOR = System.lineSeparator();

        public static void validate(List<String>weekDayWorkOrder, List<String>holidayWorkOreder) {
            isNotDuplicateInEach(weekDayWorkOrder, holidayWorkOreder);
            throwWhenWorkersNameIsLongerThanStandardOrNull(weekDayWorkOrder);
            throwWhenWorkersNumberIsOutOfPorperRnage(weekDayWorkOrder);
        }

        private static void throwWhenWorkersNumberIsOutOfPorperRnage(List<String> weekDayWorkOrder) {
            if (weekDayWorkOrder.size() > 35 || weekDayWorkOrder.size() < 5) {
                throw new IllegalArgumentException("[ERROR] 적정 근무자 수는 5명 이상 35명 이하 입니다.");
            }
        }

        private static void isNotDuplicateInEach(List<String> weekDayWorkOrder, List<String> holidayWorkOreder) {
            throwWhenDulicateWorkerRemain(weekDayWorkOrder);
            throwWhenDulicateWorkerRemain(holidayWorkOreder);
        }


        private static void throwWhenWorkersNameIsLongerThanStandardOrNull(List<String> weekDayWorkOrder) {
            for (String worker : weekDayWorkOrder) {
                if(worker.length() >5) {
                    throw new IllegalArgumentException("[ERROR] 근무자의 이름은 5글자 이하여야 합니다. 다시 입력해 주세요."+LINE_SEPARATOR);
                }
                if(worker.length()<1) {
                    throw new IllegalArgumentException("[ERROR] 근무자의 이름은 1글자 이상이어야 합니다. 다시 입력해 주세요."+LINE_SEPARATOR);
                }
                if(worker.equals(null)) {
                    throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."+LINE_SEPARATOR);
                }
            }
        }
        private static void throwWhenDulicateWorkerRemain(List<String> workOrder) {
            Set<String> workOrederNotDuplicated = new HashSet<>(workOrder);
            if(workOrederNotDuplicated.size() != workOrder.size()) {
                throw new IllegalArgumentException("[Error] 같은 순번에 중복된 근무자가 있습니다.");
            }
        }

    }

    @DisplayName("근무자는 각 순번에 한번씩 만 지정되어야한다.")
    @Test
    void workerListValidatorTest() {

//        WorkerOrderInputValidator.validate(weekDayWorkOrder, holidayWorkOreder);
    }
}

//- [ ] 순번 입력 검증기
//  - [ ] 평일 순번, 휴일 순번 각 1개
//    - [ ] 근무자는 동일 순번 2회 등장 불가
//    - [ ] 근무자는 각 순번에 각 1회 등장
//    - [ ] 이름은 1자~5자
//    - [ ] 구분자는 ","
//        - [ ] 둘 중 하나라도 오류 있으면 주중 순번 부터 재입력
//- [ ] 월, 시작요일 검증기
//  - [ ] 정수,"요일"
//        - [ ] 숫자, 문자 규칙
//      - [ ] "숫자,문자" 패턴, 구분자 ","
//        - [ ] 숫자 1~12
//        - [ ] 문자 월, 화, 수, 목, 금, 토, 일 중
