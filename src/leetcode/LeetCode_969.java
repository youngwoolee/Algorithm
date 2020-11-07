package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_969 {

    public static List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int max = arr.length;

        while (max > 0) {
            int maxIdx = getMaxIdx(arr, max);

            int k = maxIdx + 1;

            if (k != max) {
                flip(arr, k);
                if(k != 1) {
                    result.add(k);
                }

                flip(arr, max);
                result.add(max);
            }

            max--;
        }

        return result;
    }

    public static int getMaxIdx(int[] arr, int max) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max)
                return i;
        }
        return -1;
    }

    public static void flip(int[] arr, int  k) {
        int left = 0;
        int right = k - 1;
        while (left < right) {
            int save = arr[left];
            arr[left] = arr[right];
            arr[right] = save;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,2,4,1};

        pancakeSort(arr);

    }
}
