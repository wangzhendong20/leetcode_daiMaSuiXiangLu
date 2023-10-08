package org.zhendong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class middle15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int left,right;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return result;
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            left = i+1;
            right = nums.length-1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }else {
                    if (sum > 0){
                        right--;
                    }else {
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
