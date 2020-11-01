package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode_107 {
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

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelTraversal = new ArrayList<List<Integer>>();
        traverse(root, levelTraversal, 0);

        Collections.reverse(levelTraversal);

        return levelTraversal;
    }

    private static void traverse(TreeNode root, List<List<Integer>> levelTraversal, int level) {
        if(root == null) {
            return;
        }
        while(levelTraversal.size() <= level) {
            levelTraversal.add(new ArrayList<>());
        }
        levelTraversal.get(level).add(root.val);
        traverse(root.left, levelTraversal, level+1);
        traverse(root.right, levelTraversal, level+1);

    }

    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(7, null, null);
        TreeNode t4 = new TreeNode(15, null, null);
        TreeNode t3 = new TreeNode(20, t4, t5);
        TreeNode t2 = new TreeNode(9, null, null);
        TreeNode t1 = new TreeNode(3, t2, t3);


        List<List<Integer>> lists = levelOrderBottom(t1);

        for(List<Integer> list :lists) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
