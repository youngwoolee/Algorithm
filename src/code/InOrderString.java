package code;

public class InOrderString {

    private static final int C = 26;

    private static void printSortedStrings(int k) {
        printSortedStrings(k, "");
    }

    private static void printSortedStrings(int k, String prefix) {
        if(k ==0) {
            if(isInOrder(prefix)) {
                System.out.println(prefix);
            }
        }else {
            for(int i=0; i< C; i++) {
                char c = ithLetter(i);
                printSortedStrings(k-1, prefix +c);
            }
        }
    }

    private static char ithLetter(int i) {
        return (char) (((int)'a') + i);
    }

    private static boolean isInOrder(String prefix) {
        for(int i=1; i<prefix.length(); i++) {
            int prev = ithLetter(prefix.charAt(i-1));
            int curr = ithLetter(prefix.charAt(i));
            if(prev > curr) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int k= 2;
        printSortedStrings(k);

    }


}
