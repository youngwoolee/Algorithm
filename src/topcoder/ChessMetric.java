/* Copyright (c) 2019 ZUM Internet, Inc.
 * All right reserved.
 * http://www.zum.com
 * This software is the confidential and proprietary information of ZUM
 * , Inc. You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with ZUM.
 *
 * Revision History
 * Author                    Date                     Description
 * ------------------       --------------            ------------------
 *   joeylee                2019-03-08
 */
package topcoder;

import java.util.LinkedList;
import java.util.Queue;

public class ChessMetric {

    int dx[] = {1, 1, 0, -1, -1, -1, 0, 1, -2, -2, -1, 1, 2, 2, 1, -1};
    int dy[] = {0, -1, -1, -1, 0, 1, 1, 1, -1, 1, 2, 2, 1, -1, -2, -2};

    public long howMany(int size, int[] start, int[] end, int numMoves) {

        long[][][] ways = new long[100][100][55];

        //시작 위치
        ways[start[0]][start[1]][0] = 1;

        for(int i=1; i<= numMoves; i++){

            for(int x=0; x<size; x++) {

                for (int y = 0; y < size; y++) {

                    for(int j=0; j< dx.length; j++) {
                        int nextX = x + dx[j];
                        int nextY = y + dy[j];


                        //이동한 좌표가 범위가 보드 사이즈를 넘으면 무시
                        if (0 > nextX || nextX > size || 0 > nextY || nextY > size) {
                            continue;
                        }
                        ways[nextY][nextX][i] += ways[y][x][i-1];

                    }
                }
            }
        }

        return ways[end[0]][end[1]][numMoves];
    }


    public static void main(String[] args) {

        ChessMetric chessMetric = new ChessMetric();

        int size  = 3;
        int[] start = {0, 0};
        int[] end = {0, 0};
        int numMoves = 2;

        long answer = chessMetric.howMany(size, start, end, numMoves);

        System.out.print("Returns: " + answer);

    }

}
