package org.zhendong;

import java.util.Deque;
import java.util.LinkedList;

public class simple101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left,root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        else if (left != null && right == null) return false;
        else if (left == null && right == null) return true;
        else if (left.val != right.val) return false;

        boolean inside = compare(left.right, right.left);
        boolean outside = compare(left.left,right.right);
        boolean isCompare = inside && outside;
        return isCompare;
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root.left);
        deque.add(root.right);
        while (!deque.isEmpty()) {
            TreeNode left = deque.pop();
            TreeNode right = deque.pop();
            if (left == null && right == null) continue;
            if (left == null || right == null || (left.val != right.val)) {
                return false;
            }
            deque.add(left.left);
            deque.add(right.right);
            deque.add(left.right);
            deque.add(right.left);
        }
        return true;
    }
}
