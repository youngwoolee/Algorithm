package code;

public class SubString {

    private static boolean isRotation(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        return isSubstring(s1 + s1 , s2);
    }

    private static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);

    }


    public static void main(String[] args) {

        System.out.println(isRotation("string", "ringst"));
        System.out.println(isRotation("string", "ringstr"));
    }
}
