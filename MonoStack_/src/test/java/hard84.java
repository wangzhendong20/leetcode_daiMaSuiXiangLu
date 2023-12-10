import java.util.Deque;
import java.util.LinkedList;

public class hard84 {
    public int largestRectangleArea(int[] heights) {
        //暴力解法  （超时）
        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;
            for (; left >= 0; left--) {
                if (heights[left] < heights[i]) break;
            }
            for (; right < heights.length; right++) {
                if (heights[right] < heights[i]) break;
            }

            int w = right - left - 1;
            int h  = heights[i];
            sum = Math.max(sum, w*h);
        }
        return sum;
    }

    public int largestRectangleArea2(int[] heights) {
        //双指针优化
        int sum = 0;
        int len = heights.length;
        int[] leftIndex = new int[len];
        int[] rightIndex = new int[len];
        leftIndex[0] = -1;
        for (int i = 1; i < len; i++) {
            int t = i - 1;
            while (t >= 0  && heights[t] >= heights[i]) {
                t = leftIndex[t];
            }
            leftIndex[i] = t;
        }
        rightIndex[len - 1] = len;
        for (int i = len - 2; i >= 0; i--) {
            int t = i + 1;
            while (t < len && heights[t] >= heights[i]) {
                t = rightIndex[t];
            }
            rightIndex[i] = t;
        }

        for (int i = 0; i < heights.length; i++) {
            int w = rightIndex[i] - leftIndex[i] - 1;
            int h  = heights[i];
            sum = Math.max(sum, w*h);
        }
        return sum;
    }

    public int largestRectangleArea3(int[] heights) {
        //单调栈
        Deque<Integer> st = new LinkedList<>();

        // 数组扩容，在头和尾各加入一个元素
        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++){
            newHeights[index + 1] = heights[index];
        }

        heights = newHeights;

        st.push(0);
        int result = 0;
        // 第一个元素已经入栈，从下标1开始
        for (int i = 1; i < heights.length; i++) {
            // 注意heights[i] 是和heights[st.top()] 比较 ，st.top()是下标
            if (heights[i] > heights[st.peek()]) {
                st.push(i);
            } else if (heights[i] == heights[st.peek()]) {
                st.pop(); // 这个可以加，可以不加，效果一样，思路不同
                st.push(i);
            } else {
                while (heights[i] < heights[st.peek()]) { // 注意是while
                    int mid = st.peek();
                    st.pop();
                    int left = st.peek();
                    int right = i;
                    int w = right - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);
                }
                st.push(i);
            }
        }
        return result;
    }
}
