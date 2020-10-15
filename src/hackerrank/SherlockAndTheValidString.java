package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAndTheValidString {

    static String isValid(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for ( char c : s.toCharArray()) {

            if(map.containsKey(c)) {
                map.computeIfPresent(c, (k, v) -> v+1);
            }else {
                map.put(c, 1);
            }
        }

        Map<Integer, Integer> resultMap = new HashMap<>();

        map.values().forEach(value -> {
            if(resultMap.containsKey(value)) {
                resultMap.computeIfPresent(value, (k, v) -> v+1);
            }else {
                resultMap.put(value, 1);
            }
        });

        //더이상 진행안해도 YES인경우
        if(resultMap.size() == 1) return "YES";


        if(resultMap.size() == 2) {

            //2개일경우는 문자열을 하나 제거해서 조정가능
            int[] keyArray = resultMap.keySet().stream().mapToInt(Integer::intValue).toArray();
            int[] valueArray = resultMap.values().stream().mapToInt(Integer::intValue).toArray();

            //key의 차이가 1을 초과하고 1개짜리 key와 value가 1개면 YES
            if(Math.abs(keyArray[0] - keyArray[1]) > 1 && (keyArray[0] == 1 && valueArray[0] == 1) || (keyArray[1] == 1 && valueArray[1] == 1)) return "YES";

            //key의 차이가 1인데 value중 하나가 1일경우 YES
            if(Math.abs(keyArray[0] - keyArray[1]) == 1 && (valueArray[0] == 1 || valueArray[1] ==1)) return "YES";

        }

        return "NO";
    }

    public static void main(String[] args) {
        String s = "abbac";

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String s1 = String.valueOf(chars);

        System.out.println(isValid(s));
    }
}
