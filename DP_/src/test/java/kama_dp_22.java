public class kama_dp_22 {
    /*
    需要 n 阶你才能到达楼顶。
    每次你可以爬至多m (1 <= m < n)个台阶。
     */
    private static int climbStairs2(int n, int m) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                if (j >= i) dp[j] += dp[j-i];
            }
        }
        for (int i : dp) {
            System.out.print(i+ " ");
        }
        System.out.println();
        return dp[n];
    }

    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int res = climbStairs2(n, m);
    }
}
