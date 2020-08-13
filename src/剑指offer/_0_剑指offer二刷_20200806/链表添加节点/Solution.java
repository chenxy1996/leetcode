package 剑指offer._0_剑指offer二刷_20200806.链表添加节点;

import 剑指offer.ListNode;

import java.util.List;

public class Solution {
    public static ListNode add(ListNode head, ListNode node) {
        if (head == null) {
            head = node;
        } else {
            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }
        return head;
    }

    public static ListNode add0(ListNode head, ListNode node) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
        return dummy.next;
    }

    public static void main(String[] args) {
//        ListNode head = null;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode newNode = new ListNode(5);
        head = add0(head, newNode);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
