package code;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode_617 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {

        LeetCode_617 leetCode_617 = new LeetCode_617();


        TreeNode treeNode1_1 = new TreeNode(1);
        TreeNode treeNode1_2 = new TreeNode(3);
        TreeNode treeNode1_3 = new TreeNode(2);
        TreeNode treeNode1_4 = new TreeNode(5);

        treeNode1_1.left = treeNode1_2;
        treeNode1_1.right = treeNode1_3;
        treeNode1_2.left = treeNode1_4;

        TreeNode treeNode2_1 = new TreeNode(2);
        TreeNode treeNode2_2 = new TreeNode(1);
        TreeNode treeNode2_3 = new TreeNode(3);
        TreeNode treeNode2_4 = new TreeNode(4);
        TreeNode treeNode2_5 = new TreeNode(7);

        treeNode2_1.left = treeNode2_2;
        treeNode2_1.right = treeNode2_3;
        treeNode2_2.right = treeNode2_4;
        treeNode2_3.right = treeNode2_5;

        TreeNode result = leetCode_617.mergeTrees(treeNode1_1, treeNode2_1);
    }
}
