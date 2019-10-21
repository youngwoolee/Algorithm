package programmers;

import java.util.*;

public class Lesson42586 {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        int prevDay = 0;
        for(int i=0; i<progresses.length; i++) {
            int day = 1;
            while(progresses[i] + day * speeds[i] < 100) {
                day++;
            }
            queue.add(day);
        }

        while(!queue.isEmpty()) {
            int day = queue.poll();
            // 처음
            if(map.isEmpty()) {
                map.put(day, 1);
                prevDay = day;
            } else {
                // 이전 날짜가 더 크면 이전 날짜에 +1, 아니면 (새로운 날짜, 1)
                if(prevDay >= day) {
                    map.put(prevDay, map.get(prevDay) + 1);
                } else {
                    map.put(day, 1);
                    prevDay = day;
                }
            }
        }
        Integer[] integerResult = map.values().toArray(new Integer[0]);
        return Arrays.stream(integerResult).mapToInt(Integer::intValue).toArray();

    }



    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        Lesson42586 lesson42586 = new Lesson42586();
        System.out.println(lesson42586.solution(progresses, speeds));
    }
}
