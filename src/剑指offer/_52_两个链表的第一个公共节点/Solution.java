package 剑指offer._52_两个链表的第一个公共节点;

import 剑指offer.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = traverse(headA);
        int b = traverse(headB);
        ListNode less = headA;
        ListNode longer = headB;
        int delta = a - b;
        if (delta > 0) {
            less = headB;
            longer = headA;
        } else {
            delta = -delta;
        }
        for (int i = 0; i < delta; i++) {
            longer = longer.next;
        }
        while (longer != null) {
            if (longer == less) {
                return longer;
            } else {
                longer = longer.next;
                less = less.next;
            }
        }
        return null;
    }

    private static int traverse(ListNode head) {
        int res = 0;
        while (head != null) {
            res++;
            head = head.next;
        }
        return res;
    }
}
