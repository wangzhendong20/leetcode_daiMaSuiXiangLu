public class middle474 {
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String str : strs) {
            int oneNum = 0;
            int zeroNum = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') zeroNum++;
                else oneNum++;
            }

            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeroNum][j-oneNum] + 1);
                }
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        // strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        int res = findMaxForm(strs, m, n);
    }
}
