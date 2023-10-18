package org.zhendong;

public class middle222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftNum = countNodes(root.left);
        int rightNum = countNodes(root.right);
        int NodesNum = leftNum + rightNum + 1;
        return NodesNum;
    }

    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0, rightDepth = 0;
        while (left != null) {
            left = left.left;
            leftDepth++;
        }

        while (right != null) {
            right = right.right;
            rightDepth++;
        }

        if (leftDepth == rightDepth) {
            return (2<<leftDepth) - 1;
        }

        return countNodes2(root.left) + countNodes(root.right) + 1;
    }
}
