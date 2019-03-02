package topcoder;

public class BadNeighbors {

    public int maxDonations(int[] donations) {

        int i;
        int ans=0;

        int N = donations.length;
        int[] dp = new int[N];

        //0부터 N-1 까지 경우
        for(i=0; i<N-1; i++) {
            dp[i] = donations[i];
            if(i> 0) {
                dp[i] = Math.max(dp[i], dp[i-1]);
            }
            if(i> 1) {
                dp[i] = Math.max(dp[i], dp[i-2] +donations[i]);
            }
            ans = Math.max(ans, dp[i]);
        }

        //1 부터 N 까지 경우
        for(i=0; i<N-1; i++) {
            dp[i] = donations[i+1];
            if(i>0) {
                dp[i] = Math.max(dp[i], dp[i-1]);
            }
            if(i>1){
                Math.max(dp[i], dp[i-2] + donations[i+1]);
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }


    public static void main(String[] args) {

        BadNeighbors badNeighbors = new BadNeighbors();

        int[] donations= {10, 3, 2, 5, 7, 8};

        long answer = badNeighbors.maxDonations(donations);

        System.out.print("Returns: " + answer);

    }
}
