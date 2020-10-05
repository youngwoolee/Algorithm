package code;

public class ArraySplitting {

    public static int solution(int[] arr) {

        int leftSum = arr[0];
        int rightSum = 0;
        //leftSum > rightSum count
        int result = 0;

        for(int i=1; i< arr.length; i++) {
            rightSum += arr[i];
        }

        if(isGreaterThan(leftSum, rightSum)) {
            result++;
        }

        for(int i=1; i<arr.length-1; i++) {

            leftSum += arr[i];
            rightSum -= arr[i];

            if(isGreaterThan(leftSum, rightSum)) {
                result++;
            }
        }

        return result;
    }

    public static boolean isGreaterThan(int left, int right) {
        return left >= right;
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, -8, 7};
        System.out.println(solution(arr));
    }
}
