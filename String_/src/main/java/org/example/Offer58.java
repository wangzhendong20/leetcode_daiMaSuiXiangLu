package org.example;

public class Offer58 {
    public String reverseLeftWords(String s, int n) {
        StringBuffer sb = new StringBuffer(s);
        reverse(sb,0,n-1);
        reverse(sb,n,sb.length()-1);
        reverse(sb,0,sb.length()-1);
        return sb.toString();
    }

    private StringBuffer reverse(StringBuffer sb, int start, int end) {
        for (;start<end;start++,end--) {
            char c = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end,c);
        }
        return sb;
    }
}
