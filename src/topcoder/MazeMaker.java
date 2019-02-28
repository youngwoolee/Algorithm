package topcoder;

import java.util.LinkedList;
import java.util.Queue;

public class MazeMaker {

    public int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {

        int max =0;
        int width = maze[0].length();
        int height = maze.length;

        int[][] board = new int[height][width];

        for(int i=0; i< height; i++) {
            for(int j=0; j< width; j++) {
                board[i][j] = -1;
            }
        }
        board[startRow][startCol] = 0;

        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();

        queueX.add(startCol);
        queueY.add(startRow);

        while(!queueX.isEmpty()) {
            int x = queueX.poll();
            int y = queueY.poll();

            //좌표 이동
            for(int i=0; i< moveRow.length; i++) {
                int nextX = x + moveCol[i];
                int nextY = y + moveRow[i];

                //이동한 좌표가 범위가 미로 사이즈를 넘어가지 않을때, 아직 지나가지 않은길, 장애물이 없을때
                if(0<= nextX && nextX <width && 0<= nextY && nextY < height
                        && board[nextY][nextX] == -1
                        && maze[nextY].charAt(nextX) == '.') {
                    board[nextY][nextX] = board[y][x] + 1;
                    queueX.add(nextX);
                    queueY.add(nextY);
                }
            }
        }

        for(int i=0; i< height; i++) {
            for(int j=0; j< width; j++) {
                if(maze[i].charAt(j) =='.' && board[i][j] == -1) {
                    return -1;
                }
                max = Math.max(max, board[i][j]);
            }
        }



        return max;
    }


    public static void main(String[] args) {

        MazeMaker mazeMaker = new MazeMaker();
        String[] maze = {".......", "X.X.X..", "XXX...X","....X..", "X....X.","......."};
        int startRow = 5;
        int startCol = 0;
        int[] moveRow = {1, 0, -1, 0, -2};
        int[] moveCol = {0, -1, 0, 1, 3};

        int answer = mazeMaker.longestPath(maze, startRow, startCol, moveRow, moveCol);

        System.out.print("Returns: " + answer);

    }

}
