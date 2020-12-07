package leetcode;

public class LeetCode_100 {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;

        if(p == null || q == null) return false;

        if(p.val != q.val) return false;

        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }

    public static void main(String[] args) {

        TreeNode treeNode4 = new TreeNode(3, null, null);
        TreeNode treeNode5 = new TreeNode(2, null, null);
        TreeNode treeNode6 = new TreeNode(1, treeNode4, treeNode5);
        TreeNode treeNode2 = new TreeNode(2, null, null);
        TreeNode treeNode3 = new TreeNode(3, null, null);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);


        System.out.println(isSameTree(treeNode1, treeNode6));

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
