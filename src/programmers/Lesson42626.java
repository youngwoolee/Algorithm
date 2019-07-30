package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lesson42626 {

    public int solution(int[] scoville, int K) {
        int answer = -1;
        int temp = 0;
        int times = 0;
        int p1 =0, p2=0;
        Queue<Integer> pq = new PriorityQueue<>(scoville.length);

        for(int i=0; i<scoville.length; i++) {
            pq.offer(scoville[i]);
        }

        while(pq.size() > 1) {
            if(pq.peek() >= K) {
                answer = times;
                break;
            }
            p1 = pq.poll();
            p2 = pq.poll();
            temp = p1 + (p2 *2);
            pq.offer(temp);
            times++;

        }

        if(pq.poll() >= K) {
            answer = times;
        }
        return answer;
    }


    public static void main(String[] args) {

        int[] scoville = {1,2,3,9,10,12};
        int k = 7;
        Lesson42626 lesson42626 = new Lesson42626();
        System.out.println(lesson42626.solution(scoville, k));
    }
}
