package 面试金典._02_链表问题._08_环路检测;

import 面试金典._02_链表问题.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = head;
        while (slow != fast && fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            }
        }
        if (fast == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        System.out.println(new Solution().detectCycle(head).val);
    }
}
