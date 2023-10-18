package org.zhendong;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class simple94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root,res);
        return res;
    }

    private void traversal(TreeNode cur, List<Integer> list) {
        if (cur == null) return;

        traversal(cur.left,list);
        list.add(cur.val);
        traversal(cur.right,list);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}
