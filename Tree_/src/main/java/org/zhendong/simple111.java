package org.zhendong;

import java.util.Deque;
import java.util.LinkedList;

public class simple111 {
    public int minDepth(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            depth++;
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = deque.poll();
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
        }
        return depth;
    }
}
