package 剑指offer二刷_20200806._35_02_链表排序.归并排序.循环;

import 剑指offer.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        // i 为每次合并的两个链表各自的数量
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for(int i = 1; i < length; i *= 2) {
            p = dummy.next;
            ListNode tail = dummy;
            while (p != null) {
                ListNode p1 = p;
                ListNode p2 = cut(p1, i);
                p = cut(p2, i);
                tail.next = merge(p1, p2);
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
        }
        return dummy.next;
    }

    private ListNode cut(ListNode head, int cnt) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        for (int i = 0; p != null && i < cnt - 1; i++) {
            p = p.next;
        }
        if (p == null) {
            return null;
        }
        ListNode res = p.next;
        p.next = null;
        return res;
    }

    private ListNode merge(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        p.next = p1 == null ? p2 : p1;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next = new ListNode(0);

        head = new Solution().sortList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
