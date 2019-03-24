package leetcode;

import java.util.Arrays;

public class LeetCode_53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = nums[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {-1, -2};
        LeetCode_53 leetCode_53 = new LeetCode_53();
        int result = leetCode_53.maxSubArray(nums);

        System.out.println(result);
    }
}
