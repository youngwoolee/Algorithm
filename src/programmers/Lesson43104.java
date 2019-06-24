package programmers;

public class Lesson43104 {
    public long solution(int N) {
        long answer = 0;

        long[] fibonacci = new long[N + 1];
        int[] dp = new int[N];
        fibonacci[1] = 1;
        for (int i = 2; i < fibonacci.length; i++){
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        return round(N, fibonacci);

    }

    public long round(int N, long[] fibonacci) {
        return fibonacci[N] * 4 + fibonacci[N - 1] * 2;
    }

    public static void main(String[] args) {
        int N = 5;
        Lesson43104 lesson43104 = new Lesson43104();
        System.out.println(lesson43104.solution(N));
    }
}
