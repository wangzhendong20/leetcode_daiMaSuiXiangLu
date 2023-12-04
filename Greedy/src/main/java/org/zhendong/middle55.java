package org.zhendong;

public class middle55 {
    public boolean canJump(int[] nums) {
        int count = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count <= 0) {
                return false;
            }
            count = Math.max(nums[i], count-1);
        }
        return true;
    }
}
