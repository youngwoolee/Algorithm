package leetcode;

import java.util.Arrays;

public class LeetCode_287 {
    public int findDuplicate(int[] nums) {

        Arrays.sort(nums);
        for(int i=1; i< nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                return nums[i];
            }
        }

        return -1;
    }
    public static void main(String[] args) {

//        int[] nums = {1,3,4,2,2};
        int[] nums = {2,2,2,2,2};
        LeetCode_287 leetCode_287 = new LeetCode_287();
        System.out.println(leetCode_287.findDuplicate(nums));
    }
}
