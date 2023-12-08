import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class middle139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int j = 1; j <= s.length(); j++) { //背包
            for (int i = 0; i < j && !dp[j]; i++) {  //物品
                String str = s.substring(i,j);
                if (set.contains(str) && dp[i]) {
                    dp[j] = true;
                }
            }
        }

        for (boolean b : dp) {
            System.out.print(b + " ");
        }
        System.out.println();

        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String>  wordDict = Arrays.asList("apple", "pen");
        boolean res = wordBreak(s, wordDict);
    }
}
