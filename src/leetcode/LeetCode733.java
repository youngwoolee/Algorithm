package leetcode;

public class LeetCode733 {

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }
    public static void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r-1, c, color, newColor);
            if (c >= 1) dfs(image, r, c-1, color, newColor);
            if (r+1 < image.length) dfs(image, r+1, c, color, newColor);
            if (c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
        }
    }

    public static void main(String[] args) {
        int[][] image = new int[][] {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        int sr = 1;
        int sc = 1;
        int newColor = 2;

        int[][] result = floodFill(image, sr, sc, newColor);
        System.out.println(result);
    }
}
