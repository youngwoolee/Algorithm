package leetcode;

public class LeetCode_200 {
    public static int numIslands(char[][] grid) {
        int count =0;
        for(int i=0; i < grid.length; ++i) {
            for(int j=0; j<grid[0].length; ++j) {
                if(grid[i][j] == '1') {
                    traverse(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void traverse(char[][] grid, int x, int y) {
        if( x>=0 && y >=0 && x< grid.length&& y < grid[0].length && grid[x][y] == '1') {
            grid[x][y] = '0';
            traverse(grid, x+1, y);
            traverse(grid, x-1, y);
            traverse(grid, x, y+1);
            traverse(grid, x, y-1);
        }

    }


    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.println(numIslands(grid));
    }
}
