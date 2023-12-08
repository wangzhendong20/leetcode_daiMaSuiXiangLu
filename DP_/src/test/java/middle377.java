public class middle377 {
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) dp[j] += dp[j - nums[i]];
            }
        }

        for (int i : dp) {
            System.out.print(i + " ");
        }
        System.out.println();
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int target = 4;
        int res = combinationSum4(nums, target);
    }
}
