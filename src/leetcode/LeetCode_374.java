package leetcode;

public class LeetCode_374 {

    public static int arrangeCoins(int n) {

        int start = 1;
        int end = n;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (((1 + mid) * mid / 2) <= (long)n) {
                start = (int)mid + 1;
            } else {
                end = (int)mid - 1;
            }
        }
        return start - 1;
    }

    public static void main(String[] args) {
        int n = 8;

        int result = arrangeCoins(n);

        System.out.println(result);

    }
}
