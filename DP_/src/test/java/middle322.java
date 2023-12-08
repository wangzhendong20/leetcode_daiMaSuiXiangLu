public class middle322 {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j-coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
                }
            }
        }
        for (int i : dp) {
            System.out.print(i + " ");
        }
        System.out.println();
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        int res = coinChange(coins, amount);
    }
}
