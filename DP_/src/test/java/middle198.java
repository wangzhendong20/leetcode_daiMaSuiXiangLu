public class middle198 {
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        for (int i : dp) {
            System.out.print(i+" ");
        }
        System.out.println();
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        int res = rob(nums);
        System.out.println("result = " + res);
    }
}
