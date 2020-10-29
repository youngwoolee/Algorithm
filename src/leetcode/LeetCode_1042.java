package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_1042 {
    public static int[] gardenNoAdj(int n, int[][] paths) {
        //인접리스트를 가진 그래프 배열
        List<Integer>[] g = new ArrayList[n];
        for(int i=0; i<n; i++) {
            g[i] = new ArrayList<>();
        }

        for(int[] p : paths) {
            g[p[0] - 1].add(p[1]-1);
            g[p[1] - 1].add(p[0]-1);
        }

        int[] colors = new int[n];
        for(int i=0; i < n ; i++) {
            if(colors[i] > 0) {
                continue;
            }
            boolean[] takenColors = new boolean[5];
            for(int adj: g[i]) {
                takenColors[colors[adj]] = true;
            }

            //1~4 까지 당시에 사용한 색깔을 제외하고 배열에 하나씩 넣는다
            for (int c = 1; c <= 4; c++) {
                if (!takenColors[c]) {
                    colors[i] = c;
                    break;
                }
            }

        }

        return colors;
    }
    public static void main(String[] args) {

        int n = 3;
        int[][] paths = {{1,2},{2,3},{3,1}};
        int[] result = gardenNoAdj(n, paths);
        for(int r :result) {
            System.out.println(r);
        }
    }
}
