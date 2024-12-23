package LeetCodeProblems;

import java.util.Comparator;

public class ScheduleIterator implements Comparator<ScheduleTime> {

    @Override
    public int compare(ScheduleTime o1, ScheduleTime o2) {
        return Integer.compare(o1.end, o2.end);
    }
}
