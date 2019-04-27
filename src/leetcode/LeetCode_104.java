package leetcode;

public class LeetCode_104 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {

        return depth(root, 0);
    }

    int depth(TreeNode node, int depth) {
        if(node == null) return depth;
        return Math.max(depth(node.left, depth+1), depth(node.right, depth+1));
    }

    public static void main(String[] args) {
        LeetCode_104 leetCode_104 = new LeetCode_104();

        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        System.out.println(leetCode_104.maxDepth(t1));

    }
}
