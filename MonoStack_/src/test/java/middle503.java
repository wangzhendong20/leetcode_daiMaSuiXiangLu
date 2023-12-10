import java.util.Deque;
import java.util.LinkedList;

public class middle503 {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = -1;
        }
        for (int i = 0; i < nums.length * 2; i++) {
            while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek() % nums.length]) {
                result[stack.peek() % nums.length] = nums[i % nums.length];
                stack.pop();
            }
            stack.push(i % nums.length);
        }
        return result;

    }
}
