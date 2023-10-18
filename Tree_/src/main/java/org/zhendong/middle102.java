package org.zhendong;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class middle102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        deque.add(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
            res.add(list);
        }

        return res;
    }

    List<List<Integer>> resList = new ArrayList<>();

    private void levelOrderwithDiGui(TreeNode cur,Integer deep) {
        if (cur == null) return;
        deep++;

        if (resList.size() < deep) {
            List<Integer> item = new ArrayList<>();
            resList.add(item);
        }

        resList.get(deep-1).add(cur.val);
        levelOrderwithDiGui(cur.left,deep);
        levelOrderwithDiGui(cur.right,deep);
    }
}
