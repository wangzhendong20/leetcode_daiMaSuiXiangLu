package org.zhendong;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class middle347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
            }else {
                if (priorityQueue.peek()[1] < entry.getValue()) {
                    priorityQueue.poll();
                    priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }

        int[] res = new int[k];
        for (int i = k-1; i >= 0; i--) {
            res[i] = priorityQueue.poll()[0];
        }

        return res;
    }
}
