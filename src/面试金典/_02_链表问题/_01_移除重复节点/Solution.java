package 面试金典._02_链表问题._01_移除重复节点;

import 面试金典._02_链表问题.LinkedListPrinter;
import 面试金典._02_链表问题.ListNode;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Solution {
    // 常规解法
    public static ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(0);
        ListNode last = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (!set.contains(curr.val)) {
                set.add(curr.val);
                last.next = curr;
                last = curr;
            } else {
                last.next = null;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        LinkedListPrinter.show(head);
        head = removeDuplicateNodes(head);
        LinkedListPrinter.show(head);
    }
}
