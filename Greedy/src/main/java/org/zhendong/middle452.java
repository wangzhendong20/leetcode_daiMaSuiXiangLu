package org.zhendong;

import java.util.Arrays;

public class middle452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, ((o1, o2) -> Integer.compare(o2[0],o1[0])));
        int result = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i-1][1]) {
                result++;
            } else {
                points[i][1] = Math.min(points[i-1][1],points[i][1]);
            }
        }
        return result;
    }
}
