package 剑指offer二刷_20200806._35_02_链表排序.归并排序.递归;

import 剑指offer.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode left = head;
        ListNode right = slow.next;
        slow.next = null;
        left = sortList(left);
        right = sortList(right);

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next =right;
                right = right.next;
            }
            p = p.next;
        }
        p.next = left == null ? right : left;

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
