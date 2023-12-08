public class middle337 {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] tree = robTree(root);
        return Math.max(tree[0],tree[1]);
    }

    private int[] robTree(TreeNode cur) {
        if (cur == null) return new int[]{0,0};
        int[] left = robTree(cur.left);
        int[] right = robTree(cur.right);
        // 偷cur，那么就不能偷左右节点。
        int val1 = cur.val + left[0] + right[0];
        // 不偷cur，那么可以偷也可以不偷左右节点，则取较大的情况
        int val2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{val2,val1};
    }
}
