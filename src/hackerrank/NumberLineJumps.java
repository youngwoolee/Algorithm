package hackerrank;

public class NumberLineJumps {


    static String kangaroo(int x1, int v1, int x2, int v2) {
        if(v1 <= v2) {
            return "NO";
        }

        for(int i=0; i< Integer.MAX_VALUE; i++) {
            int k1 = x1 + (v1 * i);
            int k2 = x2 + (v2 * i);
            if(k1 == k2) {
                return "YES";
            }
            if(k1 > k2 ) return "NO";

        }
        return "NO";
    }


    public static void main(String[] args) {

//        int x1 = 0;
//        int v1 = 3;
//        int x2 = 4;
//        int v2 = 2;
//        int x1 = 0;
//        int v1 = 2;
//        int x2 = 5;
//        int v2 = 3;
        int x1 = 21;
        int v1 = 6;
        int x2 = 47;
        int v2 = 3;

        System.out.println(kangaroo(x1, v1, x2, v2));
    }
}
