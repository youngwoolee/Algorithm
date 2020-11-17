package leetcode;

public class LeetCode_55 {

    public static boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for(int i = nums.length - 1; i >=0; i--) {
            for(int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                dp[i] = dp[i] || dp[i+j];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
//        int[] nums = {0,2,3};
//        int[] nums = {3,0,8,2,0,0,1};

        System.out.println(canJump(nums));
    }
}
