package oncall;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public MonthAndDayDto getMonthAndDay() {
        System.out.println("비상 근무를 배정할 월과 시작 요일을 입력하세요");
        String input = Console.readLine();
        return inputValidator.validateMonthAndDay(input);
    }

    public People getWeekDaysList() {
        System.out.println("평일 비상 근무 순번대로 사원 닉네임을 입력하세요");
        String input = Console.readLine();
        return inputValidator.validatePeopleList(input);
    }

    public OnCalls getWeekendsList(People weekdays) {
        System.out.println("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요");
        String input = Console.readLine();
        People weekends = inputValidator.validatePeopleList(input);
        return new OnCalls(weekdays, weekends);
    }
}
