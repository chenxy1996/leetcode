package 剑指offer._0_剑指offer二刷_20200806._18_01_删除链表的节点;

import 剑指offer.ListNode;

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.val != val) {
            curr = curr.next;
        }
        if (curr.next != null && curr.next.val == val) {
            curr.next = curr.next.next;
        }
        return dummy.next;
    }
}
