package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MooTube {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Graph graph = new Graph(n);

        for (int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.addEdge(node1, node2, weight);
        }

        for (int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            System.out.println(graph.bfs(s, k));
        }

//        graph.printGraph();

//        int N = 4;
//        int Q = 3;
//
//        Graph graph = new Graph(N);
//
//        graph.addEdge(1,2,3);
//        graph.addEdge(2,3,2);
//        graph.addEdge(2,4,4);
//
//        graph.printGraph();
//        System.out.println(solution(graph, 2,1));
//        System.out.println(solution(graph, 1,4));
//        System.out.println(solution(graph, 1,3));

    }

    static class Edge {
        int node;
        int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "destination=" + node +
                    ", weight=" + weight +
                    '}';
        }

    }

    static class Graph {
        int node;
        LinkedList<Edge> [] adjacencylist;

        public Graph(int node) {
            this.node = node;
            this.adjacencylist = new LinkedList[node+1];
            for (int i=0; i<=node; i++) adjacencylist[i] = new LinkedList<>();
        }

        public void addEdge(int node1, int node2, int weight) {
            Edge edge1 = new Edge(node2, weight);
            Edge edge2 = new Edge(node1, weight);
            adjacencylist[node1].addFirst(edge1);
            adjacencylist[node2].addFirst(edge2);
        }

        int bfs(int s, int k) {
            Queue<Integer> queue = new LinkedList<>();
            int answer = 0;
            boolean[] visited = new boolean[node+1];

            visited[s] = true;
            queue.add(s);

            while (!queue.isEmpty()) {
                int poll = queue.poll();

                Iterator<Edge> iterator =  adjacencylist[poll].listIterator();
                while (iterator.hasNext()) {
                    Edge edge = iterator.next();
                    if (!visited[edge.node]) {
                        visited[edge.node] = true;
                        if(edge.weight >= k ) {
                            queue.add(edge.node);
                            answer++;
                        }
                    }
                }
            }

            return answer;
        }



        public void printGraph(){
            for (int i = 1; i<=node ; i++) {
                LinkedList<Edge> list = adjacencylist[i];
                for (Edge edge : list) {
                    System.out.print("node = " + i +" , ");
                    System.out.println(edge);
                }
            }
        }
    }

}

