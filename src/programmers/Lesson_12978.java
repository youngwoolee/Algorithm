package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Lesson_12978 {
    class Edge implements Comparable<Edge> {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }

    PriorityQueue<Edge> pq;
    ArrayList<ArrayList<Edge>> adj;
    int[] dist;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        pq = new PriorityQueue<>();
        adj = new ArrayList<>();
        dist = new int[N+1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=0; i<=N; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i< road.length; i++) {
            int from = road[i][0];
            int to = road[i][1];
            int weight = road[i][2];

            adj.get(from).add(new Edge(to, weight));
            adj.get(to).add(new Edge(from, weight));
        }

        dist[1] =0;
        pq.offer(new Edge(1, 0));

        dijkstra();


        for(int distance : dist){
            if(distance <= K) answer++;
        }

        return answer;
    }

    private void dijkstra() {
        while(!pq.isEmpty()){
            Edge e = pq.poll();

            for(Edge ne : adj.get(e.to)){
                if(dist[ne.to] > dist[e.to] + ne.weight){
                    dist[ne.to] = dist[e.to] + ne.weight;
                    pq.offer(ne);
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = 5;
        int K = 3;
        //int[][] road = new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int[][] road = new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};

        Lesson_12978 lesson_12978 = new Lesson_12978();
        System.out.println(lesson_12978.solution(N, road, K));


    }




}
