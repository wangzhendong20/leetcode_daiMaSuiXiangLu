public class simple392 {
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        if (dp[s.length()][t.length()] == s.length()) return true;
        return false;

    }




    public boolean isSubsequence2(String s, String t) {
        int i = 0;
        int j = 0;
        for (; i < s.length()&&j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }
        if (i == s.length()) return true;
        return false;
    }
}
