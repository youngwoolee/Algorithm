package code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode_771 {
    public int numJewelsInStones(String J, String S) {
        int result = 0;

        Set jewels = new HashSet();
        String[] jewel = J.split("");
        String[] stone = S.split("");
        jewels.addAll(Arrays.asList(jewel).subList(0, J.length()));
        for(int i=0; i< stone.length; i++) {
            if(jewels.contains(stone[i])) {
                result++;
            }
        }

//        for(int i=0; i<S.length(); i++) {
//            for(int j=0; j< jewel.length; j++) {
//                if(stone[i].equals(jewel[j])) {
//                    ++result;
//                }
//            }
//        }

        return result;
    }

    public static void main(String[] args) {

        LeetCode_771 leetCode_771 = new LeetCode_771();

        /*
         * J is types of stones that are jewels
         * S is stones you have
         * */
        int result = leetCode_771.numJewelsInStones("aA", "aAAbbbb");
        System.out.println(result);
    }
}
