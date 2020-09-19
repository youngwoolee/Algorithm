package code;

public class MinStringMatch {

    public static String solution(String A, String B) {

        String divString1 = getDivString(A,B);
        String divString2 = getDivString(B,A);

        if(divString1.length() > divString2.length()) {
            return divString2;
        }
        return divString1;
    }

    private static String getDivString(String A, String B) {
        int index =0;
        String result;
        if(A.length() < B.length()) {
            for (int i = 0; i < A.length(); i++) {
                String str_div = A.substring(A.length() -1 -i);
                String str_div2 = B.substring(0, i + 1);

                if(str_div.equals(str_div2)) {
                    index = i+1;
                }
            }
        }
        else {
            for (int i = 0; i < B.length(); i++) {
                String str_div = A.substring(A.length() -1 -i);
                String str_div2 = B.substring(0, i + 1);

                if(str_div.equals(str_div2)) {
                    index = i+1;
                }
            }
        }
        result = A + B.substring(index);
        return result;
    }

    public static void main(String[] args) {
//        String A = "xyZA";
//        String B = "ABCxy";

        String A = "xyZAA";
        String B = "xyZA";
        System.out.println(solution(A, B));
    }
}
