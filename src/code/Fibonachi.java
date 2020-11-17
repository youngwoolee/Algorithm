package code;

public class Fibonachi {

    public static void main(String[] args) {

    }

    public int fibo(int i) {
        if(i == 0 || i == 1) {
            return i;
        }
        return fibo(i - 1) + fibo(i - 2);
    }


    public static int fibo_dp(int N) {
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[N];
    }
}
