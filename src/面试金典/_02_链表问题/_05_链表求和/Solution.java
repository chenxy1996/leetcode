package 面试金典._02_链表问题._05_链表求和;

import 面试金典._02_链表问题.LinkedListPrinter;
import 面试金典._02_链表问题.ListNode;

/**
 * 这道题目很久之前是做过的
 */
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int upgrade = 0;
        ListNode curr = dummy;
        while (upgrade != 0 || l1 != null || l2 != null) {
            int sum = upgrade;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            int rem = sum % 10;
            upgrade = sum / 10;
            curr.next = new ListNode(rem);
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);

        ListNode head = addTwoNumbers(l1, l2);
        LinkedListPrinter.show(head);
    }
}
