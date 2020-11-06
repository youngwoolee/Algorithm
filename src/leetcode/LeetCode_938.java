package leetcode;

public class LeetCode_938 {
    int ans;

    public int rangeSumBST(TreeNode root, int low, int high) {

        ans = 0;
        dfs(root, low, high);
        return ans;
    }

    public void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R)
                ans += node.val;
            if (L < node.val)
                dfs(node.left, L, R);
            if (node.val < R)
                dfs(node.right, L, R);
        }
    }

    public static void main(String[] args) {

        TreeNode treeNode7 = new TreeNode(3, null, null);
        TreeNode treeNode8 = new TreeNode(7, null, null);
        TreeNode treeNode4 = new TreeNode(18, null, null);
        TreeNode treeNode5 = new TreeNode(5, treeNode7, treeNode8);
        TreeNode treeNode6 = new TreeNode(15, null, treeNode4);
        TreeNode treeNode1 = new TreeNode(10, treeNode5, treeNode6);

        int low = 7;
        int high = 15;
        LeetCode_938 leetCode_938 = new LeetCode_938();
        leetCode_938.rangeSumBST(treeNode1, low, high);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

