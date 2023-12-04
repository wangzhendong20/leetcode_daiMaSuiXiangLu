package org.zhendong;

public class hard135 {
    public int candy(int[] ratings) {
        int[] candyVec = new int[ratings.length];
        for (int i = 0; i < candyVec.length; i++) {
            candyVec[i] = 1;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candyVec[i] = candyVec[i-1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candyVec[i] = Math.max(candyVec[i], candyVec[i+1] + 1);
            }
        }

        int result = 0;
        for (int i = 0; i < candyVec.length; i++) {
            result += candyVec[i];
        }
        return result;
    }
}
