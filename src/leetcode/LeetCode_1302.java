package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1302 {
    Map<Integer, Integer> map;
    int deepestLevel;

    public int deepestLeavesSum(TreeNode root) {
        map = new HashMap<>();
        deepestLevel = 0;
        helper(root, 0);
        return map.get(deepestLevel);
    }

    private void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            map.put(level, map.getOrDefault(level, 0) + root.val);
            deepestLevel = Math.max(deepestLevel, level);
            return;
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }


    public static void main(String[] args) {

        TreeNode treeNode7 = new TreeNode(7, null, null);
        TreeNode treeNode8 = new TreeNode(8, null, null);
        TreeNode treeNode4 = new TreeNode(4, treeNode7, null);
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode6 = new TreeNode(6, null, treeNode8);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode3 = new TreeNode(3, null, treeNode6);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);

        LeetCode_1302 leetCode_1302 = new LeetCode_1302();

        System.out.println(leetCode_1302.deepestLeavesSum(treeNode1));
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
