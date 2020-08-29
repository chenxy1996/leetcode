package 剑指offer二刷_20200806._24_翻转链表.递归;

import 剑指offer.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        return newHead;
    }
}
