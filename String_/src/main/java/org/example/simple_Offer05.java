package org.example;

/**
 * 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1： 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class simple_Offer05 {
    public String replaceSpace(String s) {
        //双指针

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') sb.append("  ");
        }

        int left = s.length()-1;
        s += sb.toString();
        int right = sb.length();
        char[] chars = s.toCharArray();
        while (left >= 0) {
            if (chars[left] == ' '){
                chars[right] = '0';
                chars[--right] = '2';
                chars[--right] = '%';
            }else {
                chars[right] = chars[left];
            }

            left--;
            right--;
        }

        return new String(chars);
    }

    public String replaceSpace2(String s) {
        //双指针

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
