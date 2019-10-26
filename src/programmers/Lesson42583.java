package programmers;

import java.util.*;

public class Lesson42583 {

    public class Truck {
        int weight;
        int distance;

        public Truck(int weight, int distance) {
            this.weight = weight;
            this.distance = distance;
        }
    }

   public int solution(int bridge_length, int weight, int[] truck_weights) {
       int time = 0;
       int weightLeft = weight;
       Truck truck = null;

       Queue<Truck> outside = new LinkedList<Truck>();
       List<Truck> inside = new ArrayList<Truck>();

       for (int t : truck_weights) {
           outside.add(new Truck(t, bridge_length));
       }

       while (!(inside.isEmpty()&&outside.isEmpty())) {
           time++;

           // 먼저 다리위 트럭이 distance이상 지나갔으면 inside에서 제거해주고 남은 무게도 증가시켜줍니다.
           if (!inside.isEmpty() && inside.get(0).distance <= 0) {
               weightLeft += inside.get(0).weight;
               inside.remove(0);
           }

           // 남은 무게보다 가벼운 트럭이 있다면 inside로 넣어줍니다.
           if (!outside.isEmpty() && weightLeft - outside.peek().weight >= 0) {
               weightLeft -= outside.peek().weight;
               inside.add(outside.poll());
           }

           // 다리 위 트럭의 distance를 1씩 감소시킵니다.
           for (int i = 0; i < inside.size(); i++) {
               truck = inside.get(i);
               truck.distance--;
           }
       }
       return time;
   }


    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        Lesson42583 lesson42583 = new Lesson42583();
        System.out.println(lesson42583.solution(bridge_length, weight, truck_weights));
    }
}
