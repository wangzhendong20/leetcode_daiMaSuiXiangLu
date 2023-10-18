package org.zhendong;

import java.util.HashMap;
import java.util.Map;

public class middle105 {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return traversal(preorder,0, preorder.length, inorder,0, inorder.length);
    }

    private TreeNode traversal(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        if (preBegin >= preEnd || inBegin >= inEnd) return null;
        int middleIndex = map.get(preorder[preBegin]);
        TreeNode root = new TreeNode(inorder[middleIndex]);
        int leftOfNum = middleIndex - inBegin;

        root.left = traversal(preorder,preBegin+1,preBegin+1+leftOfNum,inorder,inBegin,middleIndex);
        root.right = traversal(preorder,preBegin+1+leftOfNum,preEnd,inorder,middleIndex+1,inEnd);

        return root;
    }
}
