import java.util.Arrays;

public class middle1049 {
    public static int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        int[] dp = new int[target+1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }

        return sum - dp[target] - dp[target];
    }

    public static void main(String[] args) {
        int[] stones = new int[]{2,7,4,1,8,1};
        int res = lastStoneWeightII(stones);
    }
}
