public class middle122 {
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }
        return dp[prices.length-1][1];
    }
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int res = maxProfit(prices);
    }
}
