package org.zhendong;

import java.util.*;
import java.util.stream.Collectors;

public class simple501 {

    Map<Integer,Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        // 普通二叉树
        List<Integer> resList = new ArrayList<>();
        if (root == null) return new int[]{};
        traversal(root);

        List<Map.Entry<Integer, Integer>> mapList = map.entrySet().stream()
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                .collect(Collectors.toList());
        resList.add(mapList.get(0).getKey());
        for (int i = 1; i < mapList.size(); i++) {
            if (mapList.get(i).getValue() == mapList.get(i-1).getValue()) {
                resList.add(mapList.get(i).getKey());
            } else {
                break;
            }
        }
        return resList.stream().mapToInt(Integer::intValue).toArray();
    }

    private void traversal(TreeNode root) {
        if (root == null) return;

        traversal(root.left);

        map.put(root.val,map.getOrDefault(root.val,0)+1);

        traversal(root.right);
    }


    int maxCount = 0;
    int count = 0;
    TreeNode pre = null;
    List<Integer> resList = new ArrayList<>();
    public int[] findMode2(TreeNode root) {
        // 二叉搜索树
        traversal2(root);
        return resList.stream().mapToInt(Integer::intValue).toArray();
    }

    private void traversal2(TreeNode cur) {
        if (cur == null) return;

        traversal2(cur.left);

        if (pre == null) {
            count = 1;
        } else if (cur.val == pre.val) {
            count++;
        } else {
            count = 1;
        }
        pre = cur;

        if (count == maxCount) resList.add(cur.val);

        if (count > maxCount) {
            resList.clear();
            maxCount = count;
            resList.add(cur.val);
        }

        traversal2(cur.right);
        return;
    }
}
