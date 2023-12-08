public class middle647 {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) { // 情况一 和 情况二
                        ans++;
                        dp[i][j] = true;
                    } else if (dp[i+1][j-1]) { // 情况三
                        ans++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return ans;
    }

    public int countSubstrings2(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += extend(s,i,i,s.length());  // 以i为中心
            ans += extend(s,i,i+1,s.length());  // 以i和i+1为中心
        }
        return ans;
    }

    private int extend(String s, int i, int j, int n) {
        int res = 0;
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            res++;
        }
        return res;
    }

    public static String countSubstringsMaxOne(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;
        int maxLen = 1;
        int start = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                int len = j - i + 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) { // 情况一 和 情况二
                        ans++;
                        dp[i][j] = true;
                    } else if (dp[i+1][j-1]) { // 情况三
                        ans++;
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j] && len > maxLen) {
                    start = i;
                    maxLen = len;
                }
            }
        }
        return s.substring(start,start+maxLen);
    }

    public static void main(String[] args) {
        String inputStr = "babaaaaad";
        String result = countSubstringsMaxOne(inputStr);
        System.out.println(result);
    }
}
