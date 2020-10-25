package leetcode;

public class LeetCode_1043 {

    public static int maxSumAfterPartitioning(int[] arr, int k) {

        int n =arr.length;
        int[] dp = new int[arr.length + 1];
        for (int i = 1; i < arr.length + 1; i++) {
            int mx = arr[i - 1];
            for (int j = 1; j <= k && i - j >= 0; j++) {
                mx = Math.max(mx, arr[i - j]);
                dp[i] = Math.max(dp[i], dp[i - j] + mx * j);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] arr = {1,15,10,7,9,2,5};
        int k = 3;

        System.out.println(maxSumAfterPartitioning(arr, k));


    }
}
