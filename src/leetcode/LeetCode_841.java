package leetcode;

import java.util.*;

public class LeetCode_841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> stack = new Stack();
        stack.push(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int nei: rooms.get(node)){
                if (!seen[nei]) {
                    seen[nei] = true;
                    stack.push(nei);
                }
            }
        }

        for (boolean v: seen) {
            if (!v) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();

        List<Integer> room0 = Arrays.asList(1,3);
        List<Integer> room1 = Arrays.asList(3,0,1);
        List<Integer> room2 = Arrays.asList(2);
        List<Integer> room3 = Arrays.asList(0);

        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        LeetCode_841 leetCode_841 = new LeetCode_841();
        System.out.println(leetCode_841.canVisitAllRooms(rooms));
    }
}
