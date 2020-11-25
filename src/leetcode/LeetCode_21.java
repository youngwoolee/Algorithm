package leetcode;

public class LeetCode_21 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode firstNode = new ListNode(0);
        ListNode nextNode = firstNode;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                nextNode.next = l2;
                l2 = l2.next;
            } else {
                nextNode.next = l1;
                l1 = l1.next;
            }
            nextNode = nextNode.next;
        }

        if (l1 == null) {
            nextNode.next = l2;
        }
        if (l2 == null) {
            nextNode.next = l1;
        }

        return firstNode.next;
    }

    public static void main(String[] args) {
        ListNode l4 = new ListNode(4, null);
        ListNode l2 = new ListNode(2, l4);
        ListNode l1 = new ListNode(1, l2);

        ListNode r4 = new ListNode(4, null);
        ListNode r3 = new ListNode(3, r4);
        ListNode r1 = new ListNode(1, r3);

        LeetCode_21 leetCode_21 = new LeetCode_21();
        leetCode_21.mergeTwoLists(l1, r1);

    }
}
