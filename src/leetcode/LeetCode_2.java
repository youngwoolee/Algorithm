package leetcode;

public class LeetCode_2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum /10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(4, listNode3);
        ListNode listNode1 = new ListNode(2, listNode2);

        ListNode listNode6 = new ListNode(4);
        ListNode listNode5 = new ListNode(6, listNode6);
        ListNode listNode4 = new ListNode(5, listNode5);

        LeetCode_2 leetCode_2 = new LeetCode_2();
        leetCode_2.addTwoNumbers(listNode1, listNode4);
    }



    public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
