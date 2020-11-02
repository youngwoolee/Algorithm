package leetcode;

public class LeetCode_378 {
    public static int kthSmallest(int[][] matrix, int k) {

        int low = matrix[0][0];
        int high = matrix[matrix.length - 1][matrix[0].length - 1];

        while(low < high) {
            int mid = low + (high - low) / 2;
            int count = count(matrix, mid);

            if(count >= k) {
                high = mid -1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    //배열의 요소중에 특정값보다 작은 개수
    private static int count(int[][] matrix, int mid) {
        int n = matrix.length;
        int count = 0;
        for(int i=0; i< n; ++i) {
            for(int j=0; j< n; ++j) {
                if(matrix[i][j] > mid) {
                    break;
                }
                if(matrix[i][j] <= mid) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
                };
        int k = 8;
        System.out.println(kthSmallest(matrix, k));
    }
}
