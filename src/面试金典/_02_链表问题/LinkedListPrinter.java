package 面试金典._02_链表问题;


import 面试金典._02_链表问题.ListNode;

import java.util.StringJoiner;

public class LinkedListPrinter {
    public static void show(ListNode node) {
        boolean print = false;
        StringJoiner sj = new StringJoiner(" --> ", "", " --> null");
        while (node != null) {
            print = true;
            sj.add(String.valueOf(node.val));
            node = node.next;
        }

        if (print) {
            System.out.println(sj.toString());
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        show(null);
    }
}
