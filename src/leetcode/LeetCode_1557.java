package leetcode;


import java.util.*;

public class LeetCode_1557 {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        List<Integer> res = new ArrayList();

        boolean[] inDegree = new boolean[n];

        for (List<Integer> edge : edges) {

            inDegree[edge.get(1)] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!inDegree[i])
                res.add(i);
        }

        return res;
    }

    public static void main(String[] args) {
//        int n = 6;
        int n = 5;
//        List<List<Integer>> edges = List.of(Arrays.asList(0, 1), Arrays.asList(0, 2), Arrays.asList(2, 5), Arrays.asList(3, 4), Arrays.asList(4, 2));
        List<List<Integer>> edges = List.of(Arrays.asList(0, 1), Arrays.asList(2, 1), Arrays.asList(3, 1), Arrays.asList(1, 4), Arrays.asList(2, 4));
        LeetCode_1557 leetCode_1557 = new LeetCode_1557();
        leetCode_1557.findSmallestSetOfVertices(n, edges);
    }

}
