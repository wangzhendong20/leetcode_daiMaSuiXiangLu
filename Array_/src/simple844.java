public class simple844 {
    public boolean backspaceCompare(String s, String t) {
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();

        if (build(schar).equals(build(tchar))){
            return true;
        }
        return false;
    }

    private String build(char[] c){
        int slow = 0,fast = 0;
        while (fast < c.length){
            if (c[fast] != '#'){
                c[slow++] = c[fast++];
            }else {
                fast++;
                if (slow > 0) slow--;
            }
        }

        return new String(c).substring(0,slow);
    }
}
