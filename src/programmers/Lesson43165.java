package programmers;

public class Lesson43165 {

    public int  solution(int[] numbers, int target) {
        return dfs(target, numbers, 0);
    }
    public int dfs(int target, int[] numbers, int i) {
        if(i==numbers.length){
            if(target==0)
                return 1;
            else
                return 0;
        }
        return dfs(target-numbers[i], numbers,i+1) + dfs(target+numbers[i], numbers,i+1);

    }

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        Lesson43165 lesson43165 = new Lesson43165();
        System.out.println(lesson43165.solution(numbers, target));
    }
}
