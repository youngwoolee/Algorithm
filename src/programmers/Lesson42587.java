package programmers;

import java.util.*;

public class Lesson42587 {

   public int solution(int[] priorities, int location) {
        int answer = 0;
       PriorityQueue queue = new PriorityQueue<>(Collections.reverseOrder());
       for(int num : priorities) {
           queue.add(num);
       }
        int cnt =1;
        while(!queue.isEmpty()) {
            for(int i=0; i< priorities.length; i++) {
                if(priorities[i] == (int) queue.peek()) {
                    if(i == location) return cnt;
                    queue.poll();
                    cnt ++;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 1;

        Lesson42587 lesson42587 = new Lesson42587();
        System.out.println(lesson42587.solution(priorities, location));
    }
}
