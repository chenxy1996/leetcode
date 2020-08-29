package 剑指offer二刷_20200806._25_03_分隔链表;

import 剑指offer.ListNode;

/**
 * 86 题
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummySmaller = new ListNode(0);
        ListNode dummyBigger = new ListNode(0);
        ListNode s = dummySmaller;
        ListNode b = dummyBigger;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                s.next = p;
                s = s.next;
            } else {
                b.next = p;
                b = b.next;
            }
            p = p.next;
        }
        s.next = dummyBigger.next;
        b.next = null;
        return dummySmaller.next;
    }
}
