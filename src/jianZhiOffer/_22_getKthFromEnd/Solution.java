package jianZhiOffer._22_getKthFromEnd;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode l = head;
        ListNode r = head;

        while (k > 0) {
            r = r.next;
            k--;
        }

        while (r != null) {
            l = l.next;
            r = r.next;
        }

        return l;
    }
}
