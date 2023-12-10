import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class simple496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
        stack.push(0);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] > nums2[stack.peek()]) {
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                    if (map.containsKey(nums2[stack.peek()])) {
                        int index = map.get(nums2[stack.peek()]);
                        result[index] = nums2[i];
                    }
                    stack.pop();
                }
                stack.push(i);
            } else {
                stack.push(i);
            }
        }
        return result;
    }
}
