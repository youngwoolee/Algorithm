package topcoder;

import org.junit.Test;

import java.util.Vector;

//결론적으로는 base-1 의 약수를 구하는 문제
public class InterestingDigits {
    public static int[] digits(int base) {

        Vector<Integer> v = new Vector<>();

        for(int i=2; i< base; i++) {
            if ((base - 1) % i == 0) {
                v.add(i);
            }
        }

        int[] ans = new int[v.size()];
        for(int i=0; i<v.size(); i++) {
            ans[i] = v.get(i);
        }

        return ans;
    }



    public static void main(String[] args) {

        int base = 10;
        int[] answer = digits(base);


        System.out.print("Returns:");
        for(int i=0; i< answer.length; i++) {
            System.out.print(answer[i] + ", ");
        }
    }
}

