package LeetCodeProblems;

import java.util.Comparator;

public class JobsComparator implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o2.profit, o1.profit);
    }
}
