package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_111 {

    public static int minDepth = 1;
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

    public static int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        return bfs(queue);
    }

    public static int bfs(Queue<TreeNode> queue) {
        int level = 1;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for(int i=1; i<=qSize; ++i) {
                TreeNode r = queue.poll();
                if(r == null) {
                    return 0;
                }
                if(r.left == null && r.right == null) {
                    // bfs로 찾으면 바로 level return
                    return level;
                }
                if(r.left != null) {
                    queue.offer(r.left);
                }
                if(r.right != null) {
                    queue.offer(r.right);
                }
            }
            level++;
        }
        return level;
    }

    public static void traverse(TreeNode root, int depth) {
         if(root == null) {
             return;
         }

         if(root.left == null && root.right == null) {
             System.out.println("found left node : " + root.val + ", depth : " + depth);
             minDepth = depth;
         }

         traverse(root.left, depth+1);
         traverse(root.right, depth+1);
    }

    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(7, null, null);
        TreeNode t4 = new TreeNode(15, null, null);
        TreeNode t3 = new TreeNode(20, t4, t5);
        TreeNode t2 = new TreeNode(9, null, null);
        TreeNode t1 = new TreeNode(3, t2, t3);


        TreeNode s5 = new TreeNode(6, null, null);
        TreeNode s4 = new TreeNode(5, null, s5);
        TreeNode s3 = new TreeNode(4, null, s4);
        TreeNode s2 = new TreeNode(3, null, s3);
        TreeNode s1 = new TreeNode(2, null, s2);


        System.out.println(minDepth(s1));

    }
}
