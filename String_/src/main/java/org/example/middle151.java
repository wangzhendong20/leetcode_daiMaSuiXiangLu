package org.example;

public class middle151 {
    public String reverseWords(String s) {
        StringBuffer sb = deleteSpace(s);
        reverseAll(sb,0,sb.length()-1);
        reverseEachWord(sb);

        return sb.toString();

    }

    private StringBuffer deleteSpace(String s) {
        StringBuffer sb = new StringBuffer();
        int start  = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        while (start <= end) {
            char c = s.charAt(start);
            if (c!= ' ' || sb.charAt(sb.length()-1) != ' '){
                sb.append(c);
            }
            start++;
        }
        return sb;
    }


    private void reverseAll(StringBuffer sb, int start, int end) {
        for (;start < end;start++,end--) {
            char c = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,c);
        }
    }

    private void reverseEachWord(StringBuffer sb) {
        int start = 0,end = 0;
        for (; end < sb.length(); end++) {
            if (sb.charAt(end) == ' ') {
                reverseAll(sb,start,end-1);
                start = end + 1;
            }
        }
        reverseAll(sb,start,end-1);
    }

}
