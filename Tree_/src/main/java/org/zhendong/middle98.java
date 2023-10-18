package org.zhendong;

import java.util.Deque;
import java.util.Stack;

public class middle98 {
    public boolean isValidBST(TreeNode root) {
//        return traversal(root);
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return true;
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (pre != null && pre.val >= cur.val) return false;
                pre = cur;
                cur = cur.right;
            }
        }
        return true;
    }

    long maxValue = Long.MIN_VALUE;
    public boolean traversal(TreeNode root) {
        if (root == null) return true;

        boolean left = traversal(root.left);

        if (maxValue < root.val) {
            maxValue = root.val;
        }else return false;

        boolean right = traversal(root.right);

        return left && right;
    }
}
