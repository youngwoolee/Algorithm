package topcoder;

public class ThePalindrome {

    public static int find(String s) {

        for(int i=s.length();;i++) {
            boolean flag = true;
            for(int j=0; j<s.length(); j++) {

                //반대쪽에 문자가 존재하는데 다를경우 플래그를 변경
                if((i - j - 1) < s.length() && s.charAt(j) != s.charAt(i - j - 1)) {
                    flag = false;
                    break;
                }
            }

            if(flag) return i;
        }
    }

    public static void main(String[] args) {

        String s = "abab";

        int answer = find(s);

        System.out.print("Returns: " + answer);

    }
}
