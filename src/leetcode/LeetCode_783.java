package leetcode;

public class LeetCode_783 {

    int ans = Integer.MAX_VALUE;
    int prev;
    public int minDiffInBST(TreeNode root) {

        prev= -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.left);
        if (prev != -1)
            ans = Math.min(ans, Math.abs(prev - node.val));
        prev = node.val;
        dfs(node.right);
    }

    public static void main(String[] args) {

        TreeNode treeNode8 = new TreeNode(3, null, null);
        TreeNode treeNode4 = new TreeNode(1, null, null);
        TreeNode treeNode5 = new TreeNode(6, null, null);
        TreeNode treeNode6 = new TreeNode(2, treeNode4, treeNode8);
        TreeNode treeNode1 = new TreeNode(4, treeNode6, treeNode5);

        LeetCode_783 leetCode_783 = new LeetCode_783();
        System.out.println(leetCode_783.minDiffInBST(treeNode1));


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
