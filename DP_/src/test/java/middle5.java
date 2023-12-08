public class middle5 {
    public static String longestPalindrome(String s) {
        //动态规划
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
        String result = longestPalindrome(inputStr);
        System.out.println(result);
    }

    public static String longestPalindrome2(String s) {
        //中心扩散
        if (s.length() <= 1) return s;
        int maxlen = 1;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = extend(s,i,i,s.length());
            int len2 = extend(s,i,i+1,s.length());
            int len = Math.max(len1,len2);
            if (len > maxlen) {
                maxlen = len;
                start = i - (maxlen - 1)/2;
            }
        }
        return s.substring(start,start+maxlen);
    }

    private static int extend(String s, int i, int j, int n) {
        int len = 1;
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            len = j - i + 1;
            i--;
            j++;
        }
        return len;
    }
}
