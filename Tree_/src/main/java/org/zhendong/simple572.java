package org.zhendong;

public class simple572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
         if (root == null) return false;
         if (compare(root,subRoot)) return true;

         return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    private boolean compare(TreeNode p,TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null && q != null) return false;
        else if (p != null && q == null) return false;
        else if (p.val != q.val) return false;

        return compare(p.left,q.left) && compare(p.right,q.right);
    }

}
