package org.zhendong;

import java.util.Stack;

public class middle150 {
    public int evalRPN(String[] tokens) {
        Stack<Long> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                long num1 = stack.pop();
                long num2 = stack.pop();
                if (token.equals("+")) stack.push(num1 + num2);
                if (token.equals("-")) stack.push(num2 - num1);
                if (token.equals("*")) stack.push(num1 * num2);
                if (token.equals("/")) stack.push(num2 / num1);
            } else {
                stack.push(Long.valueOf(token));
            }
        }
        return stack.pop().intValue();
    }
}
