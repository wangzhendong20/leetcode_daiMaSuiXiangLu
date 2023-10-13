package org.example;

public class simple541 {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i=i+2*k) {
            if (i+k <= chars.length){
                reverse(chars,i,i+k);
                continue;
            }

            reverse(chars,i, chars.length);
        }

        return new String(chars);
    }

    private void reverse(char[] ch, int begin, int end){
        for (int i = begin,j=end-1; i < j; i++,j--) {
            char tmp = ch[i];
            ch[i] = ch[j];
            ch[j] = tmp;
        }
    }


}
