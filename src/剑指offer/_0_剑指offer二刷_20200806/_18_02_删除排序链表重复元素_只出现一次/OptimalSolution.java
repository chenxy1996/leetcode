package 剑指offer._0_剑指offer二刷_20200806._18_02_删除排序链表重复元素_只出现一次;

import 剑指offer.ListNode;

public class OptimalSolution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
