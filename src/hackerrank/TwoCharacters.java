package hackerrank;

import java.util.*;

public class TwoCharacters {

    static int alternate(String s) {

        char[] chars = s.toCharArray();
        int result = 0;

        if(s.length() ==1) {
            return result;
        }

        Map<Character, Integer> map = new HashMap<>();
        for(Character c : chars) {
            if(map.containsKey(c)){
                map.computeIfPresent(c, (k, v) -> v+1);
            }
            else {
                map.put(c, 1);
            }
        }

        System.out.println(map);
        List<Character> keys = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        for (char i : map.keySet()) keys.add(i);
        for (int i : map.values()) values.add(i);

        Vector<Vector<Character>> vecVec = new Vector<>();
        for (int i=0; i<values.size(); i++) {
            for (int j=0; j<values.size(); j++) {
                if (Math.abs(values.get(j)-values.get(i)) <= 1) {
                    if(i != j){
                        Vector<Character> vec = new Vector<>();
                        vec.add(keys.get(i));
                        vec.add(keys.get(j));
                        if (vec.size() == 2) vecVec.add(vec);
                    }
                }
            }
        }


        for(Vector<Character> vec : vecVec) {
            char value1 = vec.get(0);
            char value2 = vec.get(1);

            result = Math.max(result, maxSolving(s, value1, value2));
        }


        return result;
    }

    static int maxSolving(String s, char x, char y) {
        Character lastSeen = 0;
        int length=0;
        char[] chars = s.toCharArray();

        List<Character> characterList = new ArrayList<>();
        for(char c : chars) {
            if(c == x || c == y) characterList.add(c);
        }

        lastSeen = characterList.get(0);
        length = 1;

        for(int i=1; i < characterList.size(); i++) {
            if(!characterList.get(i).equals(lastSeen)) {
                lastSeen = characterList.get(i);
                length++;
                continue;
            }
            return 0;

        }


        return length;
    }
    public static void main(String[] args) {

        String s = "asvkugfiugsalddlasguifgukvsa";
        System.out.println(alternate(s));
    }
}
