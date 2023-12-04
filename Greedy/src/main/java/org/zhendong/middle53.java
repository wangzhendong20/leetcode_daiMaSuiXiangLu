package org.zhendong;

public class middle53 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > res) {
                res = sum;
            }
            if (sum <= 0) sum = 0;
        }
        return res;
    }
}
