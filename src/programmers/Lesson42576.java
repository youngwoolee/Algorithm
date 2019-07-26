package programmers;
import java.util.*;

public class Lesson42576 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> completionMap = new HashMap<>();

        for(String completionEle : completion) {
            Integer count = Optional.ofNullable(completionMap.get(completionEle)).orElse(0);
            completionMap.put(completionEle, count+1);
        }

        for(String participantEle : participant) {
            if(!completionMap.containsKey(participantEle) || completionMap.get(participantEle) <= 0){
                answer += participant;
                return participantEle;
            }
            else {
                completionMap.put(participantEle, completionMap.get(participantEle) -1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};
        Lesson42576 lesson42576 = new Lesson42576();
        lesson42576.solution(participant, completion);

    }
}
