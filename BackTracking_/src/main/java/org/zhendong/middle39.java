package org.zhendong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class middle39 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates,target,0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int startIndex) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && candidates[i] <= target; i++) {
            path.add(candidates[i]);
            target -= candidates[i];
            backtracking(candidates,target,i);
            target += candidates[i];
            path.removeLast();
        }
    }
}
