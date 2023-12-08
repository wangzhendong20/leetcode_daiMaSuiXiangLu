package org.zhendong;

import java.util.Arrays;

public class middle416 {
    public boolean canPartition(int[] nums) {
        int[] dp = new int[10001];
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }
        if (dp[target] == target) return true;
        return false;
    }
}
