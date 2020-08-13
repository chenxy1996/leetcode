package 剑指offer._0_剑指offer二刷_20200806._18_03_删除排序链表重复元素;

import 剑指offer.ListNode;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中没有重复出现的数字。
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        boolean delete = false;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                delete = true;
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
                if (delete) {
                    pre.next = curr;
                } else {
                    pre = pre.next;
                }
                delete = false;
            }
        }
        if (delete) {
            pre.next = null;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(1);

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = new ListNode(5);
        head = new Solution().deleteDuplicates(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
