package org.zhendong;

import java.util.Deque;
import java.util.LinkedList;

public class middle513 {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) return 0;
        int value = 0;
        deque.add(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                TreeNode cur = deque.poll();
                if (cur.left != null) deque.add(cur.left);
                if (cur.right != null) deque.add(cur.right);
                if (i == 0) {
                    value = cur.val;
                }
            }
        }
        return value;
    }

    int maxDepth = Integer.MIN_VALUE;
    int res = 0;
    public int findBottomLeftValue2(TreeNode root) {
        traversal(root,0);
        return res;
    }

    private void traversal(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                res = root.val;
            }
            return;
        }

        if (root.left != null) {
            depth++;
            traversal(root.left,depth);
            depth--;
        }

        if (root.right != null) {
            depth++;
            traversal(root.right,depth);
            depth--;
        }
        return;
    }
}
