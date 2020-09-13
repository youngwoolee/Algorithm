package codility;

import java.util.Stack;

public class Fish {

    public static int solution(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<>();
        int live = 0;
        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) {
                stack.push(A[i]);
            } else {
                while (!stack.isEmpty()) {
                    int downStreamFish = (int) stack.peek();
                    if (downStreamFish < A[i]) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
                if (stack.isEmpty()) {
                    live++;
                }
            }
        }
        return live + stack.size();
    }


    public static void main(String[] args) {

        int[] A = { 4, 3, 2, 1, 5 };
        int[] B = { 0, 1, 0, 0, 0 };

        System.out.println(solution(A, B));

    }

}
