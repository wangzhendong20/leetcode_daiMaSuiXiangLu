package org.zhendong;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class middle106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        return traversal(inorder,postorder);

    }

    public TreeNode traversal(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;
        int rootValue = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootValue);
        if (postorder.length == 1) return root;

        int index = 0;
        for (; index < inorder.length; index++) {
            if (inorder[index] == rootValue) break;
        }

        int[] inorderLeft = Arrays.copyOfRange(inorder,0,index);
        int[] inorderRight = Arrays.copyOfRange(inorder,index+1,inorder.length);

        int[] postorderLeft = Arrays.copyOfRange(postorder,0,inorderLeft.length);
        int[] postorderRight = Arrays.copyOfRange(postorder,inorderLeft.length,postorder.length-1);

        root.left = traversal(inorderLeft,postorderLeft);
        root.right = traversal(inorderRight,postorderRight);

        return root;
    }


    Map<Integer, Integer> map;  // 方便根据数值查找位置
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) { // 用map保存中序序列的数值对应位置
            map.put(inorder[i], i);
        }

        return findNode(inorder,  0, inorder.length, postorder,0, postorder.length);  // 前闭后开
    }

    public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        // 参数里的范围都是前闭后开
        if (inBegin >= inEnd || postBegin >= postEnd) {  // 不满足左闭右开，说明没有元素，返回空树
            return null;
        }
        int rootIndex = map.get(postorder[postEnd - 1]);  // 找到后序遍历的最后一个元素在中序遍历中的位置
        TreeNode root = new TreeNode(inorder[rootIndex]);  // 构造结点
        int lenOfLeft = rootIndex - inBegin;  // 保存中序左子树个数，用来确定后序数列的个数
        root.left = findNode(inorder, inBegin, rootIndex,
                postorder, postBegin, postBegin + lenOfLeft);
        root.right = findNode(inorder, rootIndex + 1, inEnd,
                postorder, postBegin + lenOfLeft, postEnd - 1);

        return root;
    }
}
