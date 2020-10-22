package hackerrank;

import java.util.Arrays;
import java.util.List;
public class SubArrayDivision {

    static int birthday(List<Integer> s, int d, int m) {

        int count = 0;
        int sum = 0;
        if(m <= s.size()) {
            for(int i=0; i<m; i++) {
                sum += s.get(i);
            }
        }
        if(sum == d) count++;

        for(int i=0; i < s.size()-m; i++) {
            sum = sum - s.get(i) + s.get(i+m);
            if(sum == d) count++;
        }
        return count;
    }

    public static void main(String[] args) {

//        List<Integer> s = List.of(1,2,1,3,2);S
//        int d =3;
//        int m =2;

//        List<Integer> s = List.of(1,1,1,1,1,1);
//        int d =3;
//        int m =2;
//
//        List<Integer> s = List.of(4);
//        int d =4;
//        int m =1;

        List<Integer> s = List.of(2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1);
        int d =18;
        int m =7;

        System.out.println(birthday(s,d,m));
    }
}
