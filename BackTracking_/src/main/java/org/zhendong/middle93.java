package org.zhendong;

import java.util.ArrayList;
import java.util.List;

public class middle93 {

    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backtracking(new StringBuffer(s),0,0);
        return res;
    }

    private void backtracking(StringBuffer sb, int startIndex, int pointNum) {
        if (pointNum == 3) {
            if (isValid(sb, startIndex, sb.length() - 1)) {
                res.add(sb.toString());
                return;
            }

        }

        for (int i = startIndex; i < sb.length(); i++) {
            if (isValid(sb,startIndex,i)) {
                sb.insert(i+1,".");
                pointNum++;
                backtracking(sb,i+2,pointNum);
                pointNum--;
                sb.deleteCharAt(i+1);
            } else break;
        }
    }

    private boolean isValid(StringBuffer sb, int start, int end) {
        if (start > end) return false;
        if (sb.charAt(start) == '0' && start != end) return false;
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (sb.charAt(i) > '9' || sb.charAt(i) < '0') return false;
            num = num * 10 + Integer.valueOf(sb.charAt(i) - '0');
            if (num > 255) return false;
        }
        return true;
    }
}
