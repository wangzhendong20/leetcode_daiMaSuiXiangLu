public class hard76 {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }

        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        while (r < s.length()){
            char c = s.charAt(r);
            if (need[c] > 0){
                count--;
            }
            need[c]--;
            if (count == 0){
                while (l < r && need[s.charAt(l)] < 0){
                    need[s.charAt(l)]++;
                    l++;
                }
                if (r - l + 1 < size){
                    size = r - l +1;
                    start = l;
                }
                // 释放左边移动出窗口的字符
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
