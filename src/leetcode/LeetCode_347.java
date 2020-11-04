package leetcode;

import java.util.*;

public class LeetCode_347 {

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a, b)->(b.getValue() - a.getValue()));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }

        List<Integer> res = new ArrayList<>();
        for(int i =0; i< k; ++i) {
            Map.Entry<Integer, Integer> poll = maxHeap.poll();
            res.add(poll.getKey());
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {

        int[] nums = {2,2,3,1,1,1};
        int k = 2;

        topKFrequent(nums, k);
    }
}
