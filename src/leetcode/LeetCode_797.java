package leetcode;
import java.util.ArrayList;
import java.util.List;

public class LeetCode_797 {

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> res = new ArrayList<>();
        if(graph.length == 0)
            return res;
        List<Integer> path = new ArrayList<>();
        path.add(0);

        dfs(graph,0,path,res);
        return res;
    }
    private static void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> res){
        if(node == graph.length - 1){
            res.add(new ArrayList(path));
            return;
        }
        for(int n : graph[node]){
            path.add(n);
            dfs(graph,n,path,res);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        List<List<Integer>> lists = allPathsSourceTarget(graph);
        System.out.println(lists);
    }
}
