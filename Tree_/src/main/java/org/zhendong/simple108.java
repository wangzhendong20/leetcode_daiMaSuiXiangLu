package org.zhendong;

public class simple108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums,0, nums.length-1);
    }

    private TreeNode traversal(int[] nums, int left, int right) {
        if (left > right) return null;

        int middle = left + ((right - left) / 2);
        TreeNode root = new TreeNode(nums[middle]);

        root.left = traversal(nums,left,middle-1);
        root.right = traversal(nums,middle+1,right);

        return root;
    }
}
