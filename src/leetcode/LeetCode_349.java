package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode_349 {

    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> hashSet = new HashSet<>();

        Arrays.sort(nums1);

        for(int i=0; i < nums2.length; i++) {
            if(binarySearch(nums1, nums2[i])) {
                hashSet.add(nums2[i]);
            }
        }

        return hashSet.stream().mapToInt(Integer::intValue).toArray();
    }

    private static boolean binarySearch(int[] nums, int i) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == i) {
                return true;
            }
            if(nums[mid] > i) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        int[] result = intersection(nums1, nums2);

        for(int a : result) {
            System.out.println(a);
        }
    }
}
