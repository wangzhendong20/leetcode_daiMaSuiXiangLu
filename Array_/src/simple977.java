import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class simple977 {
    public int[] sortedSquares(int[] nums) {
        nums = IntStream.of(nums).boxed().sorted(((o1, o2) -> Math.abs(o1) - Math.abs(o2)))
                .mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        return nums;
    }

    public int[] sortedSquares2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int k = nums.length - 1;
        int[] res = new int[nums.length];

        while (left <= right){
            if (Math.abs(nums[left]) < Math.abs(nums[right])){
                res[k--] = nums[right] * nums[right];
                right--;
            }else if (Math.abs(nums[left]) >= Math.abs(nums[right])){
                res[k--] = nums[left] * nums[left];
                left++;
            }
        }

        return res;
    }
}
