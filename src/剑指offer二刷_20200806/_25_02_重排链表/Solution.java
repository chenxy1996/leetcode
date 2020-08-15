package 剑指offer._0_剑指offer二刷_20200806._25_02_重排链表;

import 剑指offer.ListNode;

public class Solution {
    public static void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 找到中间节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 翻转后半部分
        ListNode prev = null;
        while (slow != null) {
            ListNode tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }
        // 归并
        while (head != prev && head.next != prev) {
            ListNode tmp1 = head.next;
            head.next = prev;
            ListNode tmp2 = prev.next;
            prev.next = tmp1;
            head = tmp1;
            prev = tmp2;
        }
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
        ListNode head = null;
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        reorderList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
