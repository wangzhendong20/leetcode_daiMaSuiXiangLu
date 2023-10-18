package org.zhendong;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class middle429 {
    public List<List<Integer>> levelOrder(MultiNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<MultiNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                MultiNode node = deque.poll();
                levelList.add(node.val);
                for (int j = 0; j < node.children.size(); j++) {
                    if (node.children.get(j) != null) deque.add(node.children.get(j));
                }
            }
            res.add(levelList);
        }
        return res;
    }
}
