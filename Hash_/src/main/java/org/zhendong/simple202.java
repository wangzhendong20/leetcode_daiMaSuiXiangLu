package org.zhendong;

import java.util.HashSet;

public class simple202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)){
            set.add(n);
            n = getSum(n);
        }

        return n == 1;


    }

    private int getSum(int n){
        int sum = 0;
        while (n > 0) {
            sum += (n%10) * (n%10);
            n = n/10;
        }
        return sum;
    }
}
