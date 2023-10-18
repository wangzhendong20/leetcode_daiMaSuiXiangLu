package org.zhendong;

public class middle450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        return deleteNode(root,key);
    }

    private TreeNode traversal(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right;
                return root;
            }
        }

        if (root.val > key) root.left = traversal(root.left,key);
        if (root.val < key) root.right = traversal(root.right,key);
        return root;
    }
}
