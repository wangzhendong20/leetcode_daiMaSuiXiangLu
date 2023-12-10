import java.util.Deque;
import java.util.LinkedList;

public class hard42 {
    public int trap(int[] height) {
        //暴力解法
        int sum = 0;

        for (int i = 0; i < height.length; i++) {
            if (i == 0 || i == height.length -1 ) continue;
            int leftHeight = height[i];
            int rightHeight = height[i];
            for (int r = i+1; r < height.length; r++) {
                if (height[r] > rightHeight) {
                    rightHeight = height[r];
                }
            }
            for (int l = i-1; l >= 0; l--) {
                if (height[l] > leftHeight) {
                    leftHeight = height[l];
                }
            }

            int h = Math.min(leftHeight,rightHeight) - height[i];
            if (h > 0) sum += h;
        }

        return sum;
    }

    public int trap2(int[] height) {
        //双指针优化
        int sum = 0;
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        maxLeft[0] = height[0];
        for (int i = 1; i < len; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i-1]);
        }
        maxRight[len-1] = height[len-1];
        for (int i = len - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i+1]);
        }

        for (int i = 0; i < len; i++) {
            int h = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (h > 0) sum += h;
        }
        return sum;
    }

    public int trap3(int[] height) {
        //单调栈
        int sum = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            if (height[i] < height[stack.peek()]) {
                stack.push(i);
            } else if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int mid = stack.peek();
                    stack.pop();
                    if (!stack.isEmpty()) {
                        int h = Math.min(height[i], height[stack.peek()]) - height[mid];
                        int w = i - stack.peek() - 1;
                        sum += h * w;
                    }
                }
                stack.push(i);
            }
        }
        return sum;
    }
}
