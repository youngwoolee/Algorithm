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

public class ChessMetric {

    int dx[] = {1, 1, 0, -1, -1, -1, 0, 1, -2, -2, -1, 1, 2, 2, 1, -1};
    int dy[] = {0, -1, -1, -1, 0, 1, 1, 1, -1, 1, 2, 2, 1, -1, -2, -2};

    public long howMany(int size, int[] start, int[] end, int numMoves) {

        long[][] ways = new long[size][size];
        //시작 위치
        ways[start[0]][start[1]] = 1;

        for (int i = 0; i < numMoves; i++) {
            long[][] prevResult = ways;
            ways = new long[size][size];

            for (int x = 0; x < size; x++) {

                for (int y = 0; y < size; y++) {

                    for (Move move : Move.values()) {
                        int nextX = x + move.x;
                        int nextY = y + move.y;

                        if (nextX >= 0 && nextX < size && nextY >= 0 && nextY < size) {
                            ways[nextX][nextY] += prevResult[x][y];
                        }

                    }
                }
            }

        }
        return ways[end[0]][end[1]];

    }


    public static void main (String[]args){

        ChessMetric chessMetric = new ChessMetric();

        int size = 3;
        int[] start = {0, 0};
        int[] end = {0, 0};
        int numMoves = 2;

        long answer = chessMetric.howMany(size, start, end, numMoves);

        System.out.print("Returns: " + answer);

    }

    private enum Move {
        LEFT(-1, 0), RIGHT(1, 0), UP(0, 1), DOWN(0, -1),
        UP_LEFT(-1, 1), UP_RIGHT(1, 1), DOWN_LEFT(-1, -1), DOWN_RIGHT(1, -1),
        UUL(-1, 2), UUR(1, 2), ULL(-2, 1), URR(2, 1),
        DDL(-1, -2), DDR(1, -2), DLL(-2, -1), DRR(2, -1);

        public int x;
        public int y;

        Move(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

