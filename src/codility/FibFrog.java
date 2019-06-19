package codility;

import java.util.*;

public class FibFrog {
//    public int solution(int[] A) {
//        int dp[] = new int[A.length];
//        int fibo[] = new int[A.length];
//        fibo[0] = 1;
//        fibo[1] = 1;
//        for(int i=2; i< A.length; i++) {
//            fibo[i] = fibo[i - 1] + fibo[i - 2];
//        }
//
//        int result = -1;
//
//        for(int i=1; i<A.length; i++) {
//            dp[0] = 0;
//            if(A[i] == 1) {
//                //건널수 있음
//                dp[i] = dp[i] + dp[i-1];
//            }
//        }
//
//
//        return 0;
//    }
//    public int solution(int[] A) {
//        if (A.length == 0) {
//            return 1;
//        }
//        int[] dp = new int[A.length + 2];
//        dp[0] = 1;
//        dp[A.length + 1] = -1;
//        for (int i = 1; i < A.length + 2; i++) {
//            int step = 1;
//            int previous = 1;
//            int min = Integer.MAX_VALUE;
//            while (step <= i) {
//                // System.out.format("step: %d\n", step);
//                if ((i == A.length + 1 || A[i - 1] == 1) && (i - step - 1 == -1 || A[i - step - 1] == 1) && dp[i - step] > 0) {
//                    min = Math.min(min, dp[i - step] + 1);
//                    // System.out.format("new min: %d\n", min);
//                }
//                int tmp = step;
//                step = step + previous;
//                previous = tmp;
//            }
//            if (min < Integer.MAX_VALUE) {
//                dp[i] = min;
//            }
//            // System.out.format("i: %d, dp: %s\n", i, java.util.Arrays.toString(dp));
//        }
//        // System.out.format("dp: %s\n", java.util.Arrays.toString(dp));
//        return dp[A.length + 1] == -1 ? -1 : dp[A.length + 1] - 1;
//    }
    public int solution(int[] A) {

        if(A == null) return -1;
        int len = A.length;
        if(len == 0) return 1;

        List<Integer> jumpMap = getJumpMap(len);
        Collections.reverse(jumpMap);

        // bfs
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(-1, 0));
        while(!queue.isEmpty()){

            Node currentNode = queue.poll();
            for(int i=0; i< jumpMap.size(); i++){
                int curPos = currentNode.pos + jumpMap.get(i);

                if(curPos == A.length){
                    return currentNode.jumpCnt + 1;
                }
                if(curPos < 0 || curPos > A.length || A[curPos] == 0){
                    continue;
                }

                int jumpCnt = currentNode.jumpCnt + 1;
                queue.add(new Node(curPos, jumpCnt));
                A[curPos] = 0;
            }
        }

        return -1;
    }
    public List<Integer> getJumpMap(int len){
        ArrayList<Integer> jumpMap = new ArrayList<>();
        jumpMap.add(0);
        jumpMap.add(1);

        while(true){
            int prev1 = jumpMap.get(jumpMap.size() - 1);
            int prev2 = jumpMap.get(jumpMap.size() - 2);
            int next = prev1 + prev2;
            jumpMap.add(next);

            if(prev1 + prev2 > len){
                break;
            }
        }
        return jumpMap;
    }

    public class Node {
        int pos;
        int jumpCnt;

        public Node(int pos, int jumpCnt){
            this.pos = pos;
            this.jumpCnt = jumpCnt;
        }
    }


    public static void main(String[] args) {

        FibFrog fibFrog = new FibFrog();
        int A[] = {0,0,0,1,1,0,1,0,0,0,0};
        int result = fibFrog.solution(A);
        System.out.println(result);

    }
}
