package codility;

public class MinMaxDivision {

    public static int solution(int K, int M, int[] A) {
        int high = sum(A);
        int low = max(A);

        int mid = 0;

        int smallestSum = 0;

        while (high >= low) {
            mid = (high + low) / 2;
            int numberOfBlock = blockCount(mid, A);

            if (numberOfBlock > K) {
                low = mid + 1;
            } else if (numberOfBlock <= K) {
                smallestSum = mid;
                high = mid - 1;
            }

        }
        return smallestSum;
    }

    public static int sum(int[] A) {
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            total += A[i];
        }
        return total;
    }

    public static int max(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) max = A[i];
        }
        return max;
    }

    public static int blockCount(int max, int[] A) {
        int current = 0;
        int count = 1;
        for (int i = 0; i< A.length; i++) {
            if (current + A[i] > max) {
                current = A[i];
                count++;
            } else {
                current += A[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int K = 3;
        int M = 5;
        int[] A = {2,1,5,1,2,2,2};

        System.out.println(solution(K, M, A));
    }
}
