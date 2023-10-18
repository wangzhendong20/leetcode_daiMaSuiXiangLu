package org.zhendong;

import java.util.Deque;
import java.util.LinkedList;

public class simple104 {
    public int maxDepth(TreeNode root) {
        int max = 0;
        if (root == null) return max;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
            max++;
        }
        return max;
    }
}
