package org.zhendong;

import java.util.Stack;

public class simple530 {

    int minValue = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
//        traversal(root);
//        return minValue;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode preNode = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                if (pre != null && minValue > cur.val - preNode.val) minValue = cur.val - preNode.val;
                pre = cur;
                cur = cur.right;
            }
        }
        return minValue;
    }

    private void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        if (pre != null && minValue > root.val - pre.val) minValue = root.val - pre.val;
        pre = root;
        traversal(root.right);
    }
}
