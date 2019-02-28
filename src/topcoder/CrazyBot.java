package topcoder;

import java.util.LinkedList;
import java.util.Stack;

public class CrazyBot {

    boolean[][] grid = new boolean[100][100];

    int dx[] = {1, -1, 0, 0};
    int dy[] = {0, 0, 1, -1};

    double[] prob = new double[4];

    public double getProbability(int n, int east, int west, int south, int north) {

        int max =0;


        prob[0] = east / 100.0;
        prob[1] = west / 100.0;
        prob[2] = south / 100.0;
        prob[3] = north / 100.0;

        return dfs(50, 50, n);
    }

    private double dfs(int x, int y, int n) {
        if(grid[x][y]) return 0;
        if(n ==0) return 1;

        grid[x][y] = true;
        double ret =0;
        for(int i=0; i< 4; i++) {
            //east, wet,south,north 순으로 로봇을 움직인다

            ret+= dfs(x+dx[i] , y+dy[i], n-1) * prob[i];
        }
        grid[x][y] = false;

        return ret;
    }


    public static void main(String[] args) {

        CrazyBot crazyBot = new CrazyBot();
        int n =7;
        int east = 50;
        int west = 0;
        int south = 0;
        int north = 50;

        double answer = crazyBot.getProbability(n, east, west, south, north);

            System.out.print("Returns: " + answer);

    }
}
