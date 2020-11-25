package leetcode;
import java.util.ArrayList;
import java.util.List;

public class LeetCode_897 {
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

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList();
        inorder(root, vals);

        TreeNode ans = new TreeNode(0);
        TreeNode cur = ans;
        for (int v: vals) {
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }

    public void inorder(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1, null, null);
        TreeNode t2 = new TreeNode(2, t1, null);
        TreeNode t4 = new TreeNode(4, null, null);
        TreeNode t3 = new TreeNode(3, t2, t4);
        TreeNode t7 = new TreeNode(7, null, null);
        TreeNode t9 = new TreeNode(9, null, null);
        TreeNode t8 = new TreeNode(1, t7, t9);
        TreeNode t6 = new TreeNode(1, null, t8);
        TreeNode t5 = new TreeNode(5, t3, t6);



        LeetCode_897 leetCode_897 = new LeetCode_897();
        leetCode_897.increasingBST(t1);

    }

}
