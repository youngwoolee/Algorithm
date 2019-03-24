package leetcode;

public class LeetCode_62 {

    public int[] dx = {1, 0};
    public int[] dy = {0, 1};
    public int uniquePaths(int m, int n) {

        int[][] map = new int[n][m];

        //좌표 이동
        for(int i=0; i< n; i++) {
            for(int j=0; j<m; j++) {
                if(i == 0 || j== 0) {
                    map[i][j] = 1;
                }
                else {
                    map[i][j] = map[i-1][j] + map[i][j-1];
                }
            }
        }

        return map[n-1][m-1];
    }

    public static void main(String[] args) {
        int m = 7;
        int n = 3;
        LeetCode_62 leetCode_62= new LeetCode_62();
        int result = leetCode_62.uniquePaths(m, n);

        System.out.println(result);
    }
}
