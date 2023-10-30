package org.zhendong;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class middle46 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums,used);
        return res;
    }

    private void backtracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true) continue;
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums,used);
            used[i] = false;
            path.removeLast();
        }
    }
}
