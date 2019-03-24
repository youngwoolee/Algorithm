package leetcode;

import com.sun.deploy.util.ArrayUtil;

public class LeetCode_121 {

    public int maxProfit(int[] prices) {

        if(prices.length<=1) {
            return 0;
        }

        int min=prices[0];
        int result=0;

        for(int i=1; i<prices.length; i++){
            result = Math.max(result, prices[i]-min);
            min = Math.min(min, prices[i]);
        }

        return result;
    }
    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};
        LeetCode_121 leetCode_121 = new LeetCode_121();
        leetCode_121.maxProfit(prices);
    }
}
