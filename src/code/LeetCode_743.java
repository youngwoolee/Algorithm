package code;

import java.util.*;

public class LeetCode_743 {
    Map<Integer, Integer> dist;
    public int networkDelayTime(int[][] times, int N, int K) {
        int result = 0;

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] edge : times) {
            if(!graph.containsKey(edge[0])){
                graph.put(edge[0], new ArrayList<>());
            }
            graph.get(edge[0]).add(new int[]{edge[2], edge[1]});
        }

        for(int node: graph.keySet()) {
            Collections.sort(graph.get(node), (a,b) -> a[0] - b[0]);
        }

        dist = new HashMap<>();
        for(int node=1; node<= N; ++node) {
            dist.put(node, Integer.MAX_VALUE);
        }

        dfs(graph, K, 0);

        for(int cand: dist.values()) {
            if(cand == Integer.MAX_VALUE) return -1;
            result = Math.max(result, cand);
        }

        return result;
    }

    public void dfs(Map<Integer, List<int[]>> graph, int node, int elapsed) {
        if(elapsed >= dist.get(node)) {
            return;
        }
        dist.put(node, elapsed);

        if(graph.containsKey(node)) {
            for(int[] info: graph.get(node)) {
                dfs(graph, info[1], elapsed + info[0]);
            }
        }
    }

    public static void main(String[] args) {

        LeetCode_743 leetCode_743 = new LeetCode_743();
        int[][] times = {
                {2,1,1},
                {2,3,1},
                {3,4,1},
        };

        /*
        * times[i] = (u, v, w)
        * u is source node
        * v is target node
        * w is time
        *
        * N is network node count
        * K is we send a signal certain node
        * */
        int result = leetCode_743.networkDelayTime(times, 4, 2);
        System.out.println(result);
    }
}
