package 面试金典._02_链表问题._01_移除重复节点;


import 面试金典._02_链表问题.ListNode;

import java.util.StringJoiner;

public class LinkedListPrinter {
    public static void show(ListNode node) {
        StringJoiner sj = new StringJoiner(" ---> ");
        while (node != null) {
            sj.add(String.valueOf(node.val));
            node = node.next;
        }
        System.out.println(sj.toString());
    }
}
