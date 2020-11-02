package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_454 {


    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        int res=0;
        for(int a : A) {
            for(int b : B) {
                map.put(a+b, map.getOrDefault(a+b, 0) + 1);
            }
        }

        for(int c : C) {
            for(int d : D) {
                res += map.getOrDefault(-(c+d), 0);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        System.out.println(fourSumCount(A, B, C, D));
    }
}
