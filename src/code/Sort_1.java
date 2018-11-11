package code;

import java.util.Arrays;

public class Sort_1 {


    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        int start=0;
        int end=0;

        answer = new int[commands.length];

        for(int i=0; i< commands.length; i++) {

            //구해야하는 계산 개수 만큼
            start = commands[i][0];
            end = commands[i][1];

            int[] tempList = Arrays.copyOfRange(array, start-1, end);
            Arrays.sort(tempList);

            answer[i] = tempList[commands[i][2]-1];

        }

        return answer;
    }

    public static void main(String[] args) {

        Sort_1 sort_1 = new Sort_1();

        int[] array = {14, 3, 10, 9, 1, 16};
        int[][] commands = {
                {2, 5, 1}
        };

        sort_1.solution(array, commands);
    }

}
