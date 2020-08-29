package 剑指offer二刷_20200806._18_02_删除排序链表重复元素_只出现一次;

import 剑指offer.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val != pre.val) {
                pre.next = curr;
                pre = curr;
            }
            curr = curr.next;
        }
        pre.next = null;
        return head;
    }
}
