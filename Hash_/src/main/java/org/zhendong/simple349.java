package org.zhendong;

import java.util.ArrayList;

public class simple349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] record = new int[1001];
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            record[nums1[i]] = 1;
        }

        for (int i = 0; i < nums2.length; i++) {
            if (record[nums2[i]] == 1){
                array.add(nums2[i]);
                record[nums2[i]] = 0;
            }
        }

        int[] res = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            res[i] = array.get(i);
        }

        return res;
    }
}
