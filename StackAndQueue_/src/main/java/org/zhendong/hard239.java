package org.zhendong;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class hard239 {

    class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        void poll(int val) {
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.poll();
            }
        }

        void add(int val) {
            while (!deque.isEmpty() && deque.getLast() < val) {
                deque.removeLast();
            }
            deque.add(val);
        }

        int peek() {
            return deque.peek();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) return nums;
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int j = 0;
        MyQueue queue = new MyQueue();
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        res[j++] = queue.peek();
        for (int i = k; i < nums.length; i++) {
            queue.poll(nums[i-k]);
            queue.add(nums[i]);
            res[j++] = queue.peek();
        }
        return res;
    }
}
