package org.zhendong;

public class middle45 {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int curDis = 0;
        int ans = 0;
        int nextDis = 0;
        for (int i = 0; i < nums.length; i++) {
            nextDis = Math.max(nums[i] + i, nextDis);
            if (i == curDis) {
                ans++;
                curDis = nextDis;
                if (nextDis >= nums.length - 1) break;
            }
        }
        return ans;
    }
}
