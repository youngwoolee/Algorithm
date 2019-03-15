package topcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class BatchSystem {
    public int[] schedule(int[] duration, String[] user) {


        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i< user.length; i++) {
            map.put(user[i], 0);
        }

        for(int i=0; i< user.length; i++) {
            map.put(user[i], map.get(user[i]) + duration[i]);
        }

        int ansCount =0;

        //value 에 맞춰 key 정렬
        List<String> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));

        for(int i=0; i< user.length; i++) {

        }


        return null;
    }


    public static void main(String[] args) {

        int[] duration = {400, 100, 100, 100};
        String[] user = {"Danny Messer", "Stella Bonasera", "Stella Bonasera", "Mac Taylor"};

        BatchSystem batchSystem = new BatchSystem();

        int[] answer = batchSystem.schedule(duration, user);

        System.out.print("Returns: " + answer);

    }
}
