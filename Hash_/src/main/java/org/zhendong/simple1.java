package org.zhendong;

import java.util.HashMap;

public class simple1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> record = new HashMap<>();
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (record.containsKey(target-nums[i])){
                break;
            }else {
                record.put(nums[i], i);
            }
        }
        return new int[]{record.get(target-nums[i]),i};
    }
}
