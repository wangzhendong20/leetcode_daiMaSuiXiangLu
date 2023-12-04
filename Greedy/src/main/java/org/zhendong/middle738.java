package org.zhendong;

import java.util.LinkedList;

public class middle738 {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int flag = chars.length;
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[i] > chars[i+1]) {
                chars[i]--;
                flag = i+1;
            }
        }
        for (int i = flag; i < chars.length; i++) {
            chars[i] = '9';
        }

        return Integer.valueOf(String.valueOf(chars));
    }
}
