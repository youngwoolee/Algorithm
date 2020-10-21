package code;

import java.util.HashSet;
import java.util.Set;

public class WeightedUniformStrings {

    private static Set<Integer> weight = new HashSet<>();

    static String[] weightedUniformStrings(String s, int[] queries) {

        String[] result = new String[queries.length];

        char prev = 0;
        int prevWeight = 0;
        for(int i = 0 ;i<s.length();i++)
        {
            if(prev == s.charAt(i))
            {
                prevWeight+=(s.charAt(i)-'a'+1);
            }
            else
            {
                prevWeight =(s.charAt(i)-'a'+1);
            }

            weight.add(prevWeight);
            prev = s.charAt(i);
        }

        for(int i=0; i<queries.length; i++) {
            if(weight.contains(queries[i])) {
                result[i] = "Yes";
            } else {
                result[i] = "No";
            }
        }

        return result;
    }







    public static void main(String[] args) {

        String s = "abccddde";
        String s1 = "aaabbbbcccddd";
        String s2 = "aaabbaa";
        int[] queries = {1,3,12,5,9,10};
        int[] queries1 = {9,7,8,12,5};
        System.out.println(weightedUniformStrings(s2, queries1));
    }
}
