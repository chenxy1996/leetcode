package 面试金典._02_链表问题._04_分割列表;

import 面试金典._02_链表问题.LinkedListPrinter;
import 面试金典._02_链表问题.ListNode;
import 面试金典._02_链表问题.TestSample;

/**
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
 * 如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于
 * “右半部分”即可，其不需要被置于左右两部分之间。
 */
public class Solution {
    // 就像快排分割
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode curr1 = dummy1, curr2 = dummy2;
        while (head != null) {
            int val = head.val;
            if (val < x) {
                curr1.next = head;
                curr1 = curr1.next;
            } else {
                curr2.next = head;
                curr2 = curr2.next;
            }
            head = head.next;
        }
        curr2.next = null;
        curr1.next = dummy2.next;
        return dummy1.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = TestSample.head;
        LinkedListPrinter.show(head);
        head = solution.partition(head, 3);
        LinkedListPrinter.show(head);
    }
}
