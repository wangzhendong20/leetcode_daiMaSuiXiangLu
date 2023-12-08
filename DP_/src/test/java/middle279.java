public class middle279 {
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int j = 0; j <= n; j++) {
            for (int i = 1; i*i <= j; i++) {
                dp[j] = Math.min(dp[j], dp[j-i*i] + 1);
            }
        }
//        for (int i = 1; i * i <= n; i++) { // 遍历物品
//            for (int j = i * i; j <= n; j++) { // 遍历背包
//                dp[j] = Math.min(dp[j - i * i] + 1, dp[j]);
//            }
//        }

        for (int i : dp) {
            System.out.print(i+" ");
        }
        System.out.println();
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int res = numSquares(n);
    }
}
