package org.zhendong;

public class simple112 {


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return traversal(root,targetSum - root.val);
    }

    private boolean traversal(TreeNode cur, int count) {
        if (cur.left == null && cur.right == null && count == 0) return true;
        if (cur.left == null && cur.right == null) return false;

        if (cur.left != null) {
            count -= cur.left.val;
//            if (traversal(cur.left,count-cur.left.val)) return true;
            if (traversal(cur.left,count)) return true;
            count += cur.left.val;
        }
        if (cur.right != null) {
            count -= cur.right.val;
//            if (traversal(cur.right,count-cur.right.val)) return true;
            if (traversal(cur.right,count)) return true;
            count += cur.right.val;
        }
        return false;
    }

}
