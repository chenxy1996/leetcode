package 剑指offer二刷_20200806.链表删除节点;

import 剑指offer.ListNode;

public class Solution {
    public static ListNode remove(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        } else {
            ListNode curr = head;
            while (curr.next != null && curr.next.val != val) {
                curr = curr.next;
            }
            // 判断是不是确实找到了而不是链表中没有值为 val 的节点
            if (curr.next != null && curr.next.val == val) {
                curr.next = curr.next.next;
            }
            return head;
        }
    }

    public static ListNode remove0(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.val != val) {
            curr = curr.next;
        }
        if (curr.next != null && curr.next.val == val) {
            curr.next = curr.next.next;
        }
        return dummy.next;
    }

    public static ListNode remove1(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.val != val) {
            curr = curr.next;
        }
        if (curr.next != null && curr.next.val == val) {
            if (curr.next.next == null) {
                curr.next = null;
            } else {
                curr.next.val = curr.next.next.val;
                curr.next.next = curr.next.next.next;
            }

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head = remove1(head, 5);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
