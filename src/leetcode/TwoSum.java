package leetcode;

import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < nums.length; i++) map.put(nums[i], i);
        for(int i=0; i < nums.length; i++) {
            Integer j = map.get(target-nums[i]);
            if(j != null && i != j) return new int[] {i, j};
        }
        return null;
    }

    public static void main(String[] args) {

        int[] nums = {6,4,3,8,7,5,2};
        int[] result = twoSum(nums, 5);
        System.out.println(result[0] + ", " + result[1]);
    }
}
