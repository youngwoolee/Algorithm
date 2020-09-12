package codility;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {


    public static int solution(int[] A) {
        // write your code in Java SE 8

        Set<Integer> hashSet = new HashSet<>();
        for(int a: A) {
            hashSet.add(a);
        }

        for(int i=1; i<= A.length; i++) {
            if(!hashSet.contains(i)) {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        int[] A = {4,1,3,2};
        System.out.println(solution(A));

    }
}
