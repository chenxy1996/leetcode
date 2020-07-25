package 面试金典._02_链表问题._02_返回倒数第k个节点;

import 面试金典._02_链表问题.LinkedListPrinter;
import 面试金典._02_链表问题.ListNode;
import 面试金典._02_链表问题.TestSample;

public class Solution {
    public int kthToLast(ListNode head, int k) {
        // 快慢指针
        ListNode slow, fast;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        slow = dummy;
        fast = slow;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.val;
    }

    public static void main(String[] args) {
        ListNode head = TestSample.head;
        LinkedListPrinter.show(head);

        System.out.println(new Solution().kthToLast(head, 3));
    }
}
