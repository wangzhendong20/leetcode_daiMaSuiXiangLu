package org.zhendong;

public class middle376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 1) return 0;
        int curDiff = 0;
        int preDiff = 0;
        int res = 1;
        for (int i = 0; i < nums.length-1; i++) {
            curDiff = nums[i+1] - nums[i];
            if ((preDiff <= 0 && curDiff > 0) || preDiff >= 0 && curDiff < 0) {
                res++;
                preDiff = curDiff;
            }
        }
        return res;
    }

    public int wiggleMaxLength1(int[] nums) {
        int[][] dp = new int[1005][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) dp[i][1] = Math.max(dp[i][1],dp[j][0] + 1);
            }
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
            }
        }
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }
}
