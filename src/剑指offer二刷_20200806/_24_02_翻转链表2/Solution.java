package 剑指offer二刷_20200806._24_02_翻转链表2;

import 剑指offer.ListNode;

/**
 * 92 题
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;

        int i = 0;
        while (i < m - 1) {
            p = p.next;
            i++;
        }

        ListNode trimStartPoint = p;
        p = p.next;
        i++;
        ListNode start = p;

        ListNode prev = null;
        while (i <= n) {
            ListNode temp = p.next;
            p.next = prev;
            prev = p;
            p = temp;
            i++;
        }

        trimStartPoint.next = prev;
        start.next = p;

        return dummy.next;
    }
}
