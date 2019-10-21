package programmers;

import java.util.HashMap;

public class Lesson42578 {

    public int solution(String[][] clothes) {
        int answer = 0;
        int sum = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] strs : clothes) {
            int count = 0;
            String key = strs[1]; // 각 배열의 두번째 원소를 키 값으로 저장
            if (map.containsKey(key)) {
                count = map.get(key);
            }
            map.put(key, count + 1);
        }

        for (String key : map.keySet()) {
            sum *= (map.get(key) + 1);
        }
        //다 안입을 경우 한가지 경우의 수 제외
        return sum-1;
    }



    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        Lesson42578 lesson42578 = new Lesson42578();
        System.out.println(lesson42578.solution(clothes));
    }
}
