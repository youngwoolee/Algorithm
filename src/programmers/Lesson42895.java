package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Lesson42895 {
    public int solution(int N, int number) {
        int answer = 0;
        int start = 0;
        Queue<Integer> queue = new LinkedList();
        //operator +, -, *, /, & 0, 1, 2, 3, 4

        while(true) {
            //N 개수 증가
            start++;

            if(N == number) {
                answer = 1;
                break;
            }
            //연산자 자리가 하나일때
            if(start ==1) {
                if(calculator(N, number) != -1) {
                    answer = calculator(N, number);
                    break;
                }
            }



            //연산자 자리가 두개이상일때
            for(int i=0; i< start; i++) {
                for(int j=0; j<5; j++) {
                    queue.add(i);
                    queue.add(j);
                    //queue 에 넣은 후 계산

                }

            }


            //답 찾았을때
            if(answer == 0) {
                break;
            }

        }

        return answer;
    }

    public int calculator(int N, int number) {

        if(N+N == number) {
            return N+N;
        }

        else if(N-N == number) {
            return N-N;
        }
        else if(N*N == number) {
            return N*N;
        }
        else if(N/N == number) {
            return N/N;
        }
        else if(N*10+N == number) {
            return N*10+N;
        }

        return -1;

    }

    public static void main(String[] args) {
        int N = 5;
        int number = 10;

        Lesson42895 lesson42895 = new Lesson42895();
        int result = lesson42895.solution(N, number);

        System.out.println(result);
    }
}
