package 面试金典._02_链表问题._03_删除中间节点;

import 面试金典._02_链表问题.LinkedListPrinter;
import 面试金典._02_链表问题.ListNode;
import 面试金典._02_链表问题.TestSample;

/**
 * 题目太蠢，没讲明白
 */
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode node = TestSample.head;
        LinkedListPrinter.show(node);
        new Solution().deleteNode(node);
        LinkedListPrinter.show(node);
    }
}
