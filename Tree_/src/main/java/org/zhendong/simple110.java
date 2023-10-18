package org.zhendong;

public class simple110 {
    public boolean isBalanced(TreeNode root) {
        int res = getHeight(root);
        return res == -1 ? false : true;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) return -1;

        int result = 0;
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            result = Math.max(leftHeight,rightHeight) + 1;
        }
        return result;
    }
}
