public class BagProblem_complete {
    private static int testCompletePack(int[] weight, int[] value, int bagSize) {
        int[] dp = new int[bagSize+1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j <= bagSize; j++) {
                dp[j] = Math.max(dp[j], dp[j-weight[i]]+value[i]);
            }
        }
        for (int i : dp) {
            System.out.print(i + " ");
        }
        System.out.println();
        return dp[bagSize];
    }
    private static int testCompletePack2(int[] weight, int[] value, int bagSize) {
        int[][] dp = new int[weight.length][bagSize+1];
        for (int i = 1; i < weight.length ;i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j - weight[i-1] < 0) // 如果当前背包容量放不下第i件物品，那么前i件物品放入背包得到的最大价值就是前i-1件物品放入获得的最大价值
                    dp[i][j] = dp[i-1][j];
                else { // 如果能放下，从放和不放两种选择里取最大值，这里要注意，其实完全背包二维数组的代码跟一维只有下面一个下标不同，那就是“放i”这个选择，因为是可以重复放的，所以是dp[i]
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-weight[i-1]] + value[i-1]);
                }
            }
        }
        // 打印dp数组
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp[weight.length-1][bagSize];
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int res1 = testCompletePack(weight,value,bagWeight);
        int res2 = testCompletePack2(weight,value,bagWeight);
    }

}
