package leetcode;

public class LeetCode_410 {

    public static int splitArray(int[] nums, int m) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; ++i) {
            left = Math.max(left, nums[i]);
            right += nums[i];
        }

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (canSplit(nums, mid, m)) right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }

    private static boolean canSplit(int[] nums, int target, int m) {
        int cnt = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (sum > target) {
                ++cnt;
                sum = nums[i];
                if (cnt > m) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int m = 2;
        System.out.println(splitArray(nums, m));
    }
}
