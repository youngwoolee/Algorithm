package codility;


import java.util.Stack;

public class Nesting {

    public static int solution(String S) {
        // write your code in Java SE 8
        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            }
            else if(stack.isEmpty() || stack.pop() == c) {
                return 0;
            }
        }
        if(stack.isEmpty()) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
//        String S = "(()(())())";
        String S = "())";

        System.out.println(solution(S));
    }
}
