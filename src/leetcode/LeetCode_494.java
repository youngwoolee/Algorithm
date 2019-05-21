package leetcode;

public class LeetCode_494 {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0)
            return 0;
        int res[] = new int[1];
        dfsCore(nums, 0, 0, 0, S, res);
        return res[0];
    }
    private void dfsCore(int[] nums, int sum, int idx, int k,
                         int target, int[] res) {
        if (k == nums.length) {
            if (sum == target)
                res[0] += 1;
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            dfsCore(nums, sum + nums[i], i + 1, k + 1, target, res);
            dfsCore(nums, sum - nums[i], i + 1, k + 1, target, res);
        }
    }
    public static void main(String[] args) {

        int[] nums = {1,1,1,1,1};
        int S = 3;
        LeetCode_494 leetCode_494 = new LeetCode_494();
        System.out.println(leetCode_494.findTargetSumWays(nums, S));
    }
}
