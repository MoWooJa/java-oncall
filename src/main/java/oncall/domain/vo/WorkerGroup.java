package oncall.domain.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkerGroup {
    private List<String> weekdaysWorker;
    private List<String> holidaysWorker;

    private static final int MIN_WORKER_COUNT = 5;
    private static final int MAX_WORKER_COUNT = 35;

    public List<String> getWeekdaysWorker() {
        return weekdaysWorker;
    }

    public List<String> getHolidaysWorker() {
        return holidaysWorker;
    }

    public WorkerGroup(List<String> weekdaysWorker, List<String> holidaysWorker) {
        this.weekdaysWorker = weekdaysWorker;
        this.holidaysWorker = holidaysWorker;
        validateWorkerCount();
    }

    private void validateWorkerCount() {
        Set<String> workerNames = new HashSet<>(weekdaysWorker);
        workerNames.addAll(holidaysWorker);

        validateWorkerCountRange(workerNames);
        hasDuplicatedWorker(weekdaysWorker);
        hasDuplicatedWorker(holidaysWorker);
        validateOneTimesWork(weekdaysWorker, holidaysWorker);
    }

    private void validateWorkerCountRange(Set<String> workerNames) {
        if (workerNames.size() < MIN_WORKER_COUNT || workerNames.size() > MAX_WORKER_COUNT) {
            throw new IllegalArgumentException("ERROR : 비상 근무자는 5명이상 35명 이하여야 합니다.");
        }
    }

    private void hasDuplicatedWorker(List<String> workers) {
        Set<String> workerNames = new HashSet<>(workers);
        if (workerNames.size() != workers.size()) {
            throw new IllegalArgumentException("ERROR : 같은 근무 그룹안에서 중복된 이름의 근무자는 존재할 수 없습니다.");
        }
    }
    private void validateOneTimesWork(List<String> weekdaysWorker, List<String> holidaysWorker) {
        if (weekdaysWorker.size()!=holidaysWorker.size()) {
            throw new IllegalArgumentException("ERROR : 근무 그룹안 비상 근무자의 수는 같아야 합니다.");
        }
    }
}
