package org.zhendong;

import java.util.Deque;
import java.util.LinkedList;

public class middle116 {
    public NextNode connect(NextNode root) {
        if (root == null) return root;
        Deque<NextNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            NextNode pre = deque.poll();
            if (pre.left != null) deque.add(pre.left);
            if (pre.right != null) deque.add(pre.right);
            for (int i = 1; i < len; i++) {
                NextNode node = deque.poll();
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
                pre.next = node;
                pre = node;
            }
            pre.next = null;
        }
        return root;
    }
}
