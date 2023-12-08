public class middle518 {
    private static int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j-coins[i]];
            }
        }
        for (int i : dp) {
            System.out.print(i + " ");
        }
        System.out.println();

        return dp[amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = new int[]{1, 2, 5};
        int res = change(amount,coins);
        System.out.println("result = " + res);
    }
}
