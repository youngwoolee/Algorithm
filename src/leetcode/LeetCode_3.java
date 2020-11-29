package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_3 {

    public int lengthOfLongestSubstring(String s) {


        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {

            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;

    }

    public static void main(String[] args) {

        String s = "dvdf";
        LeetCode_3 leetCode_3 = new LeetCode_3();
        System.out.println(leetCode_3.lengthOfLongestSubstring(s));


    }
}
