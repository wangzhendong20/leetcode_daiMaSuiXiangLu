package org.zhendong;

import java.util.Stack;

public class simple20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            }else if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || s.charAt(i) != stack.peek()) {
                return false;
            }else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
