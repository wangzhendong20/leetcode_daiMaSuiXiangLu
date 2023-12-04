package org.zhendong;

import java.util.Arrays;
import java.util.Map;

public class middle435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,((o1, o2) -> Integer.compare(o1[1],o2[1])));
        int unoverlap = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end <= intervals[i][0]) {
                end = intervals[i][1];
                unoverlap++;
            }
        }
        return intervals.length - unoverlap;
    }
}
