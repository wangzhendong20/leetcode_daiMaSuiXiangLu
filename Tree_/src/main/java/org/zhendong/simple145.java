package org.zhendong;

import java.util.*;

public class simple145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root,res);
        return res;
    }

    private void traversal(TreeNode cur,List<Integer> list) {
        if (cur == null) return;

        traversal(cur.left,list);
        traversal(cur.right,list);
        list.add(cur.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }

        Collections.reverse(res);
        return res;
    }
}
