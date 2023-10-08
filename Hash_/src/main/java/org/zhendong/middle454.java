package org.zhendong;

import java.util.HashMap;

public class middle454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> record = new HashMap<>();
        for (int a: nums1) {
            for (int b: nums2) {
                int sum = a+b;
                record.put(sum,record.getOrDefault(sum,0)+1);
            }
        }
        int res = 0;
        for (int c:nums3
             ) {
            for (int d:nums4
                 ) {
                res += record.getOrDefault(0-c-d,0);
            }
        }

        return res;
    }
}
