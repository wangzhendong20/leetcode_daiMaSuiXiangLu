package org.zhendong;

import java.util.Stack;

public class simple232 {

    class MyQueue {

        Stack<Integer> InStack;
        Stack<Integer> OutStack;

        public MyQueue() {
            InStack = new Stack<>();
            OutStack = new Stack<>();
        }

        public void push(int x) {
            InStack.push(x);
        }

        public int pop() {
            trans();
            return OutStack.pop();
        }

        public int peek() {
            trans();
            return OutStack.peek();
        }

        public boolean empty() {
            if (InStack.isEmpty() && OutStack.isEmpty()) {
                return true;
            }
            return false;
        }

        private void trans() {
            if (!OutStack.isEmpty()) {
                return;
            }
            while (!InStack.isEmpty()) {
                OutStack.push(InStack.pop());
            }
        }
    }
}
