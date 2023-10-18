package org.zhendong;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class simple637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            double sum = 0;
            for (int i = 0; i < len; i++) {
                TreeNode node = deque.poll();
                sum += node.val;
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
            res.add(sum / len);
        }

        return res;
    }
}
