package day24;

import java.util.Arrays;

public class NonOverlapingInterval {

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));

        int lastEndTime = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] >= lastEndTime) {
                count++;
                lastEndTime = intervals[i][1];
            }
        }


        return intervals.length - count;
    }
}
