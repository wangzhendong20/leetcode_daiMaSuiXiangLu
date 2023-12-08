import java.util.Arrays;

public class middle494 {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((target + sum) % 2 == 1) return 0;
        if (Math.abs(target) > sum) return 0;
        int bagSize = (target + sum) / 2;
        int[] dp = new int[bagSize+1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j-nums[i]];
            }
        }

        for (int i : dp) {
            System.out.print(i + " ");
        }

        return dp[bagSize];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        int target = 3;
        int res = findTargetSumWays(nums,target);
    }
}
