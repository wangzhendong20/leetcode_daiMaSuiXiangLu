package org.zhendong;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class middle763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] hash = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //获得每个字母的最远位置。
            hash[chars[i] - 'a'] = i;
        }
        int idx = 0;
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            //当前位置和最远位置相同，则到了分割点。
            idx = Math.max(idx, hash[chars[i] - 'a']);
            if (i == idx) {
                res.add(i - last);
                last = i;
            }
        }
        return res;
    }
}
