package code;

import java.util.Scanner;

/**
 * 세로 N, 가로 M(4 ≤ N, M ≤ 500)*/
public class BackJoon_14500 {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int arr[][] = new int[N][M];

        for(int i=0; i< N; i++) {
            for(int j =0; j< M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                DFS(i, j, 0, 0);

            }
        }
        System.out.println(max);
    }

    //상하좌우 가능한 모형들 (ㅗ 모양 제외)
    //'ㅗ' 모양은 DFS로 구현 불가
    public static void DFS(int x, int y, int depth, int sum) {

        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                continue;
            }
            if (visited[nextX][nextY]) {
                continue;
            }
            visited[nextX][nextY] = true;
            DFS(nextX, nextY, depth + 1, sum + arr[nextX][nextY]);
            visited[nextX][nextY] = false;

        }

    }
}
