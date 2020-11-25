package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LeetCode_559 {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public int maxDepth(Node root) {

        int depth = dfs(root);

        return depth;
    }

    public int dfs(Node node) {

        if(node == null) {
            return 0;
        }

        int count =1;
        for(Node n : node.children) {
            count = Math.max(count, 1+dfs(n));
        }
        return count;
    }


    public static void main(String[] args) {
        Node t2 = new Node(2, new ArrayList<>());
        Node t5 = new Node(5, new ArrayList<>());
        Node t6 = new Node(6, new ArrayList<>());
        Node t3 = new Node(3, Arrays.asList(t5, t6));
        Node t4 = new Node(4, new ArrayList<>());
        Node t1 = new Node(1, Arrays.asList(t3, t2, t4));




        LeetCode_559 leetCode_559 = new LeetCode_559();
        leetCode_559.maxDepth(t1);

    }
}
