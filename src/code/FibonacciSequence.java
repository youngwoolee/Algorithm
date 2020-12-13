package code;

public class FibonacciSequence {


    public static int solution(int a1, int a2, int index) {

        int result = 0, last1= 0, last2 = 0;
        if(index == 1) {

            return a1;
        }
        if(index == 2) {
            return a2;
        }

        last1 = a1;
        last2 = a2;
        for(int i = 3; i<=  index; i++) {
            result = last1 + last2;
            last1 = last2;
            last2 = result;

        }
        return result;
    }


    public static void main(String[] args) {

        int a1 = 0;
        int a2 = 1;
        int index = 6;

        System.out.println(solution(a1,a2,index));

    }
}
