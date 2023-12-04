package org.zhendong;

import java.util.Arrays;

public class simple455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int index = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (index >= 0 && s[index] >= g[i]) {
                res++;
                index--;
            }
        }
        return res;
    }
}
