package 剑指offer._24_reverseList;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // 递归方法
    public ListNode reverseList0(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        } else {
            ListNode newHead = reverseList0(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }
}
