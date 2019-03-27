package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode_242 {

        public boolean isAnagram(String s, String t) {

            char[] var1 = s.toCharArray();
            char[] var2 = t.toCharArray();

            Arrays.sort(var1);
            Arrays.sort(var2);

            return Arrays.equals(var1, var2);

        }
        public static void main(String[] args) {

            String s = "anagram";
            String t = "nagaram";
            LeetCode_242 leetCode_242 = new LeetCode_242();
            System.out.println(leetCode_242.isAnagram(s, t));
        }
}
