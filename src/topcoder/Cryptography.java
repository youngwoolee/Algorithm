package topcoder;

public class Cryptography {

    public static long encrypt(int[] numbers) {

        int max = 0;
        //1더하는 값
        int cryptValue = 0;

        for(int i=0; i< numbers.length; i++) {
            int temp = 1;
            cryptValue = numbers[i] + 1;
            for(int j=0; j< numbers.length; j++) {
                if(i == j) {
                    continue;
                }
                temp *= numbers[j];
                max = Math.max(max, temp * cryptValue);
            }
        }
        return max;
    }



    public static void main(String[] args) {

        int[] numbers = {1, 1, 1, 1};


        long answer = encrypt(numbers);

        System.out.print("Returns: " + answer);

    }
}
