package org.zhendong;

import java.util.ArrayList;
import java.util.List;

public class middle17 {
    List<String> res = new ArrayList<>();
    StringBuffer sb = new StringBuffer();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.equals("")){
            return res;
        }

        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtracking(digits,numString,0);
        return res;
    }

    private void backtracking(String digits, String[] numString, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String s = numString[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length() ; i++) {
            sb.append(s.charAt(i));
            backtracking(digits,numString,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
