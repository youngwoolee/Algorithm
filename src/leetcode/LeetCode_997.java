package leetcode;

import java.util.*;

public class LeetCode_997 {
    public int findJudge(int N, int[][] trust) {

        int[] count = new int[N+1];
        for (int[] t: trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) return i;
        }
        return -1;
    }
    public static void main(String[] args) {

        int N = 4;
        int[][] trust = {{1,3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
//        int[][] trust = {{1,3},{2,3}};
//        int[][] trust = {{1,3},{2,3},{3,1}};
        LeetCode_997 leetCode_997 = new LeetCode_997();
        System.out.println(leetCode_997.findJudge(N, trust));
    }
}
