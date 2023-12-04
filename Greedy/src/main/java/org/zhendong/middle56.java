package org.zhendong;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class middle56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,((o1, o2) -> Integer.compare(o1[0],o2[0])));
        List<int[]> res = new LinkedList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                res.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end,intervals[i][1]);
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[res.size()][2]);
    }
}
