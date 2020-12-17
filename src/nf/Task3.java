package naverFinancial;

import java.util.Arrays;
import java.util.HashSet;

public class Task3 {
    public static int solution(String[] A) {
        HashSet<String> data = new HashSet<>();
        for (int i = 2; i <= A.length; i++) {
            permutation(0, A, new String[i], new boolean[A.length], data);
        }
        int max = 0;
        for (String str : data) {
            max = Math.max(str.length(), max);
        }

        return max;
    }

    private static void permutation(int currentDepth, String[] A, String[] temp, boolean[] visited, HashSet<String> data) {
        if (currentDepth == temp.length) {
            String value = Arrays.toString(temp).replaceAll("\\[|\\]|,|\\s", "");
            System.out.println(value);
            boolean isOk = true;
            for (int i = 0; i < value.length(); i++) {
                char c = value.charAt(i);
                if (value.indexOf(c) != value.lastIndexOf(c)) {
                    isOk = false;
                    break;
                }
            }

            if (isOk) {
                data.add(value);
            }
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (!visited[i]) {
                temp[currentDepth] = A[i];
                visited[i] = true;
                permutation(currentDepth + 1, A, temp, visited, data);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String[] A = new String[] {"co", "dil","ity"};

        System.out.println(solution(A));
    }
}
