package org.zhendong;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class simple144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root,res);

        return res;
    }

    private void traversal(TreeNode cur, List<Integer> list) {
        if (cur == null) return;

        list.add(cur.val);
        traversal(cur.left,list);
        traversal(cur.right,list);
    }


    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);

        }
        return res;
    }
}
