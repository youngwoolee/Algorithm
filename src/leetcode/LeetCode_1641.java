package leetcode;

public class LeetCode_1641 {

    public static int countVowelStrings(int n) {
        int [] dp = new int [6];
        for (int i=1; i<dp.length; i++)
            dp[i] = 1;
        for (int i=1; i<=n; i++) {
            for (int k=1; k<=5; k++) {
                dp[k] += dp[k-1];
            }
        }
        return dp[5];
    }

    public static void main(String[] args) {
        System.out.println(countVowelStrings(1));
        System.out.println(countVowelStrings(2));
    }
}
