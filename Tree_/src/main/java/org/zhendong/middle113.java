package org.zhendong;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class middle113 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null) return res;
        path.add(root.val);
        traversal(root,targetSum-root.val);
        return res;
    }

    private void traversal(TreeNode root, int count) {
        if (root.left == null && root.right == null && count == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (root.left == null && root.right == null) return;
        if (root.left != null) {
            path.add(root.left.val);
            count -= root.left.val;
            traversal(root.left,count);
            count += root.left.val;
            path.remove(path.size()-1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            count -= root.right.val;
            traversal(root.right,count);
            count += root.right.val;
            path.remove(path.size()-1);
        }
        return;
    }
}
